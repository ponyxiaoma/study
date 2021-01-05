package com.mjq.common.web.config;

import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.boot.jackson.JsonComponent;
import org.springframework.context.annotation.Bean;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.TimeZone;

@JsonComponent
public class DateFormatConfig {

    @Value("${spring.jackson.date-format:yyyy-MM-dd HH:mm:ss}")
    private String pattern;


    @Bean
    public Jackson2ObjectMapperBuilderCustomizer jackson2ObjectMapperBuilder() {
        return builder -> {
            TimeZone tz = TimeZone.getTimeZone("GMT+8");
            DateFormat df = new SimpleDateFormat(pattern);
            df.setTimeZone(tz);
            builder.failOnEmptyBeans(false)
                    .failOnUnknownProperties(false)
                    .featuresToDisable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)
                    .dateFormat(df);

        };
    }

    @Bean
    public LocalDateTimeSerializer localDateTimeDeserializer() {
        return new LocalDateTimeSerializer(DateTimeFormatter.ofPattern(pattern));
    }

    @Bean
    @ConditionalOnBean(LocalDateTimeSerializer.class)
    public Jackson2ObjectMapperBuilderCustomizer jackson2ObjectMapperBuilderCustomizer(@Qualifier("localDateTimeDeserializer") LocalDateTimeSerializer localDateTimeSerializer) {
        return builder -> builder.serializerByType(LocalDateTime.class, localDateTimeSerializer);
    }
}