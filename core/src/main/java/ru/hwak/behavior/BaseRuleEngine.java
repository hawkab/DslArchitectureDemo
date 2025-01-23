package ru.hwak.behavior;

import java.util.*;

import ru.hwak.entity.*;

/**
 * Базовый движок обработки правил {@link RuleDefinition}.
 *
 * @author olshansky
 * @since 23.01.2025
 */
public class BaseRuleEngine {

    private final Map<String, RuleDefinition> compiledRules = new HashMap<>();
    private final Map<String, RuleAction> actionsRegistry = new HashMap<>();
    private final Map<String, Condition> conditionRegistry = new HashMap<>();

    public BaseRuleEngine(final List<RuleDefinition> ruleDefinitions,
            final Map<String, RuleAction> actionsRegistry,
            final Map<String, Condition> conditionRegistry) {
        //Сопоставление функций согласно условиям правила
        ruleDefinitions.forEach(rule -> {
            rule.setExpression(compileRule(rule));
            compiledRules.put(rule.getName(), rule);
        });
        this.actionsRegistry.putAll(actionsRegistry);
        this.conditionRegistry.putAll(conditionRegistry);
    }

    /**
     * Обрабатывает входные данные из контекста и выносит решения на основе правил
     * @param context контекст запроса
     * @return решения, вынесенные на основе правил
     */
    public List<Decision> execute(final Context context) {
        var decisions = new ArrayList<Decision>();
        compiledRules.forEach((key, value) -> {
            if (value.getExpression().evaluate(context)) {
                decisions.addAll(
                        getDecisions(value.getAction(), value.getParams(), context));
            }
        });
        return decisions;
    }

    /**
     * Вычисляет решение, если контекст соответствует описанному в DSL правилу
     * @param action действие, которое необходимо предпринять для вынесения решения
     * @param params описанные в правиле параметры
     * @param context контекст запроса, к которому применяется правило
     * @return Решения, вынесенные на основе действий правила
     */
    private List<Decision> getDecisions(final String action,
            final Map<String, Object> params,
            final Context context) {
        return Optional.ofNullable(actionsRegistry.get(action))
                .map(m -> m.calculateDecisions(context, params))
                .orElse(Collections.emptyList());
    }

    /**
     * Формирует исполняемую функции из условий описанного правила
     * @param rule правило описанное через DSL
     * @return исполняемая функция, соответствующая условиям правила
     */
    private RuleExpression compileRule(final RuleDefinition rule) {
        var conditions = new ArrayList<RuleExpression>();
        rule.getConditions().forEach(condition ->
                conditions.addAll(
                        Optional.ofNullable(conditionRegistry.get(condition.getType()))
                                .map(m -> Collections.singletonList(
                                        m.evaluate(condition.getVariable(), condition.getValue())))
                                .orElse(Collections.emptyList())
                ));
        return ConditionalOperator.and(conditions.toArray(new RuleExpression[0]));
    }

}