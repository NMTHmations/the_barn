package com.sfm.thebarn.thebarn.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.BeanClassLoaderAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.support.GenericConversionService;
import org.springframework.core.serializer.Deserializer;
import org.springframework.core.serializer.Serializer;
import org.springframework.core.serializer.support.DeserializingConverter;
import org.springframework.core.serializer.support.SerializingConverter;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.security.jackson2.SecurityJackson2Modules;
import org.springframework.session.jdbc.config.annotation.web.http.EnableJdbcHttpSession;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

@Configuration
@EnableJdbcHttpSession
public class SessionConfig implements BeanClassLoaderAware {

    private ClassLoader classLoader;

    /*Save session attributes as JSON*/
    /*Customize how the attribute values are serialized*/
    @Bean("springSessionConversionService")
    public GenericConversionService springSessionConversionService(ObjectMapper objectMapper) {
        /*Create a copy of the ObjectMapper*/
        /*Changes are only applied to the copy of the ObjectMapper*/
        ObjectMapper copy = objectMapper.copy();
        copy.registerModules(SecurityJackson2Modules.getModules(this.classLoader));
        GenericConversionService converter = new GenericConversionService();
        /*Add the JsonSerializer and JsonDeserializer into the ConversionService*/
        converter.addConverter(Object.class, byte[].class, new SerializingConverter(new JsonSerializer(copy)));
        converter.addConverter(byte[].class, Object.class, new DeserializingConverter(new JsonDeserializer(copy)));
        return converter;
    }

    @Override
    public void setBeanClassLoader(ClassLoader classLoader) {
        this.classLoader = classLoader;
    }

    static class JsonSerializer implements Serializer<Object> {
        private final ObjectMapper objectMapper;

        JsonSerializer(ObjectMapper objectMapper) {
            this.objectMapper = objectMapper;
        }

        @Override
        public void serialize(Object object, OutputStream outputStream) throws IOException {
            this.objectMapper.writeValue(outputStream, object);
        }
    }

    static class JsonDeserializer implements Deserializer<Object> {

        private final ObjectMapper objectMapper;

        JsonDeserializer(ObjectMapper objectMapper) {
            this.objectMapper = objectMapper;
        }

        @Override
        public Object deserialize(InputStream inputStream) throws IOException {
            return this.objectMapper.readValue(inputStream, Object.class);
        }
    }

    /*WebSession integration with Redis*/
    @Bean
    public LettuceConnectionFactory redisConnectionFactory() {
        return new LettuceConnectionFactory();
    }
}