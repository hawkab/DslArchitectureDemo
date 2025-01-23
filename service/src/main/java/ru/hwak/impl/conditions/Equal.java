package ru.hwak.impl.conditions;

import org.springframework.stereotype.Component;

import ru.hwak.behavior.Condition;
import ru.hwak.behavior.RuleExpression;

/**
 * Условное выражение вычисления идентичности.
 *
 * @author olshansky
 * @since 23.01.2025
 */
@Component
public class Equal implements Condition {

    @Override
    public RuleExpression evaluate(final String variable, final Object value) {
        return context -> value.equals(context.get(variable));
    }
}
