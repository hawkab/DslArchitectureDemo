package ru.hwak.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lombok.Data;
import ru.hwak.behavior.RuleExpression;

/**
 * Описание правила.
 *
 * @author olshansky
 * @since 23.01.2025
 */
@Data
public class RuleDefinition implements Serializable {

    /**
     * Наименование правила
     */
    private String name;

    /**
     * Условия для проверки
     */
    private List<Condition> conditions = new ArrayList<>();

    /**
     * Предварительно скомпилированное выражение
     */
    private RuleExpression expression;

    /**
     * Действие, которое выполняется
     */
    private String action;

    /**
     * Параметры действия
     */
    private Map<String, Object> params = new HashMap<>();

    /**
     * Условие для проверки правила
     */
    @Data
    public static class Condition implements Serializable {

        /**
         * Тип проверки
         */
        private String type;

        /**
         * Название проверяемого атрибута
         */
        private String variable;

        /**
         * Проверяемое значение
         */
        private Object value;
    }
}