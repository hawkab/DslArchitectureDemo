package ru.hwak.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import ru.hwak.behavior.BaseRuleEngine;
import ru.hwak.entity.Context;
import ru.hwak.entity.Decision;

/**
 * Сервис реализующий функционал загрузки и обработки правил.
 *
 * @author olshansky
 * @since 23.03.2025
 */
@Service
@RequiredArgsConstructor
public class RuleService {

    private final BaseRuleEngine ruleEngine;

    /**
     * Получить решения на основе проверки соответствия правилам из переданного контекста запроса
     * @param context контекст запроса
     * @return решения, вынесенные на основе правил
     */
    public List<Decision> execute(final Context context) {
        return ruleEngine.execute(context);
    }
}
