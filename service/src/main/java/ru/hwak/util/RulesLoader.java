package ru.hwak.util;

import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import ru.hwak.entity.RuleDefinition;

/**
 * Загрузчик правил.
 *
 * @author olshansky
 * @since 23.01.2025
 */
public class RulesLoader {
    public static List<RuleDefinition> loadRules(final String filePath) throws IOException {
        var mapper = new ObjectMapper(new YAMLFactory());
        return mapper.readValue(RulesLoader.class.getClassLoader().getResourceAsStream(filePath),
                mapper.getTypeFactory().constructCollectionType(List.class, RuleDefinition.class));
    }
}