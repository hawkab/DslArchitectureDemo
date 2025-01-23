package ru.hwak.impl;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import ru.hwak.behavior.BaseRuleEngine;
import ru.hwak.behavior.Condition;
import ru.hwak.entity.Context;
import ru.hwak.entity.Decision;
import ru.hwak.entity.RuleAction;
import ru.hwak.util.RulesLoader;

/**
 * Сервис реализующий функционал загрузки и обработки правил.
 *
 * @author olshansky
 * @since 23.03.2025
 */
@Service
@RequiredArgsConstructor
public class RuleService {

    private BaseRuleEngine ruleEngine;
    private final Map<String, RuleAction> actionsRegistry;
    private final Map<String, Condition> conditionRegistry;

    /**
     * Метод инициализации движка правил, так же осуществляющий первичную загрузку правил DSL
     * @throws IOException исключение, возбуждаемая в случае ошибок загрузки файла с правилами
     */
    @PostConstruct
    public void init() throws IOException {
        //Загружаем список правил из файла
        var rules = RulesLoader.loadRules("rules.yml");

        // Создаём движок
        ruleEngine = new BaseRuleEngine(rules, actionsRegistry, conditionRegistry);
    }

    /**
     * Получить решения на основе проверки соответствия правилам из переданного контекста запроса
     * @param context контекст запроса
     * @return решения, вынесенные на основе правил
     */
    public List<Decision> execute(final Context context) {
        return ruleEngine.execute(context);
    }
}
