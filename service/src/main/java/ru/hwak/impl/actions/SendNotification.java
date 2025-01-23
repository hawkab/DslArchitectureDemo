package ru.hwak.impl.actions;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import ru.hwak.entity.Context;
import ru.hwak.entity.Decision;
import ru.hwak.entity.RuleAction;

/**
 * Функция по отправке уведомления
 */
@Service
public class SendNotification implements RuleAction {

    /**
     * Формирует решение по отправке уведомления
     * @param context контекст запроса
     * @param params параметры правила
     * @return решения по отправке уведомления
     */
    @Override
    public List<Decision> calculateDecisions(Context context, Map<String, Object> params) {
        context.add("notificationType", "email");
        context.add("notificationTarget", params.get("customerEmail"));
        return Collections.emptyList();
    }
}
