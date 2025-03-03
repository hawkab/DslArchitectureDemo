package ru.hwak.entity;

import java.util.List;
import java.util.Map;

/**
 * Интерфейс-маркер для действий правил {@link RuleDefinition#getAction()}, создающих решения {@link Decision}.
 *
 * @author olshansky
 * @since 23.01.2025
 */
public interface RuleAction {
    List<Decision> calculateDecisions(final Context context, final Map<String, Object> params, final String ruleName);
}
