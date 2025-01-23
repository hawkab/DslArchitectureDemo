package ru.hwak.entity;

/**
 * Решение, выполняемая после завершения обработки правилом.
 *
 * @author olshansky
 * @since 23.01.2025
 *
 * @param action Код предпринимаемого действия
 * @param target Объект действия
 * @param context Контекст выполнения
 */
public record Decision(String action, Object target, Context context) { }