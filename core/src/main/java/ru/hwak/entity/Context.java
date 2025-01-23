package ru.hwak.entity;

import java.util.Map;

/**
 * Контекст выполнения правила.
 *
 * @author olshansky
 * @since 23.01.2025
 */
public record Context(Map<String, Object> variables) {

    public Object get(String key) {
        return variables.get(key);
    }

    public void add(String key, Object value) {
        variables.put(key, value);
    }
}