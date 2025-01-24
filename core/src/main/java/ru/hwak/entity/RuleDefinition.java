package ru.hwak.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ru.hwak.behavior.RuleExpression;

/**
 * Описание правила.
 *
 * @author olshansky
 * @since 23.01.2025
 */
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

        public Condition() {
        }

        public String getType() {
            return this.type;
        }

        public String getVariable() {
            return this.variable;
        }

        public Object getValue() {
            return this.value;
        }

        public void setType(String type) {
            this.type = type;
        }

        public void setVariable(String variable) {
            this.variable = variable;
        }

        public void setValue(Object value) {
            this.value = value;
        }

    }

    public RuleDefinition() {
    }

    public String getName() {
        return this.name;
    }

    public List<Condition> getConditions() {
        return this.conditions;
    }

    public RuleExpression getExpression() {
        return this.expression;
    }

    public String getAction() {
        return this.action;
    }

    public Map<String, Object> getParams() {
        return this.params;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setConditions(List<Condition> conditions) {
        this.conditions = conditions;
    }

    public void setExpression(RuleExpression expression) {
        this.expression = expression;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public void setParams(Map<String, Object> params) {
        this.params = params;
    }

}