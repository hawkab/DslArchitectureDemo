package ru.hwak.configuration;

import java.io.IOException;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import ru.hwak.behavior.BaseRuleEngine;
import ru.hwak.behavior.Condition;
import ru.hwak.entity.RuleAction;
import ru.hwak.util.RulesLoader;

@Configuration
public class RuleConfiguration {

    private final Map<String, RuleAction> actionsRegistry;
    private final Map<String, Condition> conditionRegistry;

    public RuleConfiguration(Map<String, RuleAction> actionsRegistry,
            Map<String, Condition> conditionRegistry) {
        this.actionsRegistry = actionsRegistry;
        this.conditionRegistry = conditionRegistry;
    }

    /**
     * Метод инициализации движка правил, так же осуществляющий первичную загрузку правил DSL
     * @throws IOException исключение, возбуждаемая в случае ошибок загрузки файла с правилами
     */
    @Bean
    public BaseRuleEngine ruleEngine() throws IOException {
        //Загружаем список правил из файла
        var rules = RulesLoader.loadRules("rules.yml");

        // Создаём движок
        return new BaseRuleEngine(rules, actionsRegistry, conditionRegistry);
    }
}
