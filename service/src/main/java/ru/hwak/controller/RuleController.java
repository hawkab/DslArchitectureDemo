package ru.hwak.controller;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import ru.hwak.entity.Context;
import ru.hwak.entity.Decision;
import ru.hwak.impl.RuleService;

/**
 * Контроллер обработки запросов, связанных с правилами.
 *
 * @author olshansky
 * @since 23.01.2025
 */
@RestController
@RequestMapping("/rules")
@RequiredArgsConstructor
public class RuleController {
    private final RuleService ruleService;

    @PostMapping("/apply")
    public List<Decision> applyRules(@RequestBody Map<String, Object> input) {
        return ruleService.execute(new Context(input));
    }
}