package br.com.guilherme.fiap.car_service.config;

import br.com.guilherme.fiap.car_service.api.converter.PerfilEnumToStringConverter;
import br.com.guilherme.fiap.car_service.api.converter.StringToPerfilEnumConverter;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;
import org.springframework.data.mongodb.core.convert.MongoCustomConversions;

import java.util.Arrays;

@Configuration
public class MongoConfig extends AbstractMongoClientConfiguration {

    @Override
    protected String getDatabaseName() {
        return "fiap-veiculos";
    }

    @Override
    public MongoCustomConversions customConversions() {
        return new MongoCustomConversions(Arrays.asList(
                new PerfilEnumToStringConverter(),
                new StringToPerfilEnumConverter()
        ));
    }
}

