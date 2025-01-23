package ru.hwak.behavior;

import ru.hwak.entity.Context;
import ru.hwak.entity.RuleDefinition;

/**
 * Выражение правила {@link RuleDefinition#getExpression()}, оформленное в функцию.
 *
 * @author olshansky
 * @since 23.01.2025
 */
@FunctionalInterface
public interface RuleExpression {
    boolean evaluate(Context context);
}