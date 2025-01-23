package ru.hwak.impl.actions;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Service;

import ru.hwak.entity.Context;
import ru.hwak.entity.Decision;
import ru.hwak.entity.RuleAction;

/**
 * Функция применения скидки
 *
 * @author olshansky
 * @since 23.01.2025
 */
@Service
public class ApplyDiscount implements RuleAction {

    /**
     * Осуществляет применение скидки по вынесенному решению
     * @param context контекст запроса
     * @param params параметры правила
     * @return решение по применению скидки
     */
    @Override
    public List<Decision> calculateDecisions(Context context, Map<String, Object> params) {
        var decisions = new ArrayList<Decision>();
        Optional.ofNullable((Integer) context.get("orderAmount"))
                .ifPresent(amount -> {
                    var discountedAmount = amount - (amount * Double.parseDouble(String.valueOf(params.get("discount"))) / 100);
                    context.add("discount", params.get("discount"));
                    context.add("discountedAmount", discountedAmount);
                    decisions.add(new Decision("applyDiscount", "orderAmount", context));
                });
        return decisions;
    }
}
