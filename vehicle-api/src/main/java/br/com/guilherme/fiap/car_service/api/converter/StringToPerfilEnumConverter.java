package br.com.guilherme.fiap.car_service.api.converter;

import br.com.guilherme.fiap.car_service.infrastructure.document.usuario.PerfilEnum;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.ReadingConverter;

@ReadingConverter
public class StringToPerfilEnumConverter implements Converter<String, PerfilEnum> {
    @Override
    public PerfilEnum convert(String source) {
        for (PerfilEnum perfilEnum : PerfilEnum.values()) {
            if (perfilEnum.getPerfil().equals(source)) {
                return perfilEnum;
            }
        }
        throw new IllegalArgumentException("Perfil desconhecido: " + source);
    }
}