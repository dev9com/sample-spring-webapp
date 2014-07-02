package com.dev9.web.converter;

import org.joda.time.DateMidnight;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.core.convert.converter.Converter;

public class SimpleDateStringToDateTimeConverter implements Converter<String, DateMidnight> {
    private static final DateTimeFormatter FULL_DATE_FORMAT = DateTimeFormat.forPattern("MM/dd/yyyy");

    @Override
    public DateMidnight convert(String dateString) {
        DateMidnight converted;
        try {
            converted = new DateMidnight(FULL_DATE_FORMAT.parseDateTime(dateString));
        } catch (IllegalArgumentException ex) {
            // parse format error
            converted = null;
        }
        return converted;
    }
}
