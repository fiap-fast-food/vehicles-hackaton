package br.com.guilherme.fiap.car_service.api.converter;

import br.com.guilherme.fiap.car_service.infrastructure.document.usuario.PerfilEnum;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.WritingConverter;

@WritingConverter
public class PerfilEnumToStringConverter implements Converter<PerfilEnum, String> {
    @Override
    public String convert(PerfilEnum perfilEnum) {
        return perfilEnum.getPerfil();
    }
}


