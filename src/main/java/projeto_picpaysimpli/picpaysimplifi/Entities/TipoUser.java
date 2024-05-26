package projeto_picpaysimpli.picpaysimplifi.Entities;

import lombok.Getter;

@Getter
 public enum TipoUser{
    Lojista("lojista"),
    User("usuario");
    private TipoUser(String tipoUser) {
        this.tipoUser = tipoUser;
    }

    private String tipoUser;

 }