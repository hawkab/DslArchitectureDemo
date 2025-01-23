package ru.hwak.behavior;

/**
 * Специфическое условное выражение.
 *
 * @author olshansky
 * @since 23.01.2025
 */
public interface Condition {
    RuleExpression evaluate(final String variable, final Object value);
}
