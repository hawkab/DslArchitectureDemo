package ru.hwak.behavior;

/**
 * Доступные условные операторы в DSL.
 *
 * @author olshansky
 * @since 23.01.2025
 */
public class ConditionalOperator {

    public static RuleExpression and(RuleExpression... expressions) {
        return context -> {
            for (RuleExpression expr : expressions) {
                if (!expr.evaluate(context)) {
                    return false;
                }
            }
            return true;
        };
    }

    public static RuleExpression or(RuleExpression... expressions) {
        return context -> {
            for (RuleExpression expr : expressions) {
                if (expr.evaluate(context)) {
                    return true;
                }
            }
            return false;
        };
    }
}