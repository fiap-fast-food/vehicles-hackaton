package br.com.guilherme.fiap.car_service.infrastructure.document.usuario;

public enum PerfilEnum {

    ADMIN("admin"),
    COMPRADOR("comprador");

    private String perfil;

    PerfilEnum(String perfil) {
        this.perfil = perfil;
    }

    public String getPerfil() {
        return perfil;
    }
}
