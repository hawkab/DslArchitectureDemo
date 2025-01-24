package ru.hwak.impl.actions;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import ru.hwak.entity.Context;
import ru.hwak.entity.Decision;
import ru.hwak.entity.RuleAction;

/**
 * Функция по отправке уведомления.
 *
 * @author olshansky
 * @since 24.01.2025
 */
@Service
public class SendNotification implements RuleAction {

    /**
     * Формирует решение по отправке уведомления
     * @param context контекст запроса
     * @param params параметры правила
     * @param ruleName имя сработавшего правила
     * @return решения по отправке уведомления
     */
    @Override
    public List<Decision> calculateDecisions(final Context context, final Map<String, Object> params, final String ruleName) {
        context.add("notificationType", "email");
        context.add("notificationTarget", params.get("customerEmail"));
        return Collections.singletonList(
                new Decision("notification",
                        "customerEmail",
                        new Context(Map.copyOf(context.variables())),
                        ruleName));
    }
}
