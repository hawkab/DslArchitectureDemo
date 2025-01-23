package ru.hwak.impl.conditions;

import org.springframework.stereotype.Component;

import ru.hwak.behavior.Condition;
import ru.hwak.behavior.RuleExpression;

/**
 * Условное выражение сравнения. В результате определяет, что переменная "более чем".
 *
 * @author olshansky
 * @since 23.01.2025
 */
@Component
public class GreaterThan implements Condition {

    @Override
    public RuleExpression evaluate(final String variable, final Object value) {
        return context -> {
            var varValue = context.get(variable);
            return varValue instanceof Number && ((Number) varValue).doubleValue() > ((Number)value).doubleValue();
        };
    }
}
