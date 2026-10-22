package com.example.employeecrud.employee;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/** Stores the skills list as one comma-separated column. */
@Converter
public class SkillsConverter implements AttributeConverter<List<String>, String> {

    @Override
    public String convertToDatabaseColumn(List<String> skills) {
        if (skills == null || skills.isEmpty()) return null;
        return skills.stream().map(String::trim).filter(s -> !s.isEmpty()).collect(Collectors.joining(","));
    }

    @Override
    public List<String> convertToEntityAttribute(String db) {
        if (db == null || db.isBlank()) return new ArrayList<>();
        return Arrays.stream(db.split(",")).map(String::trim).filter(s -> !s.isEmpty())
                .collect(Collectors.toCollection(ArrayList::new));
    }
}
