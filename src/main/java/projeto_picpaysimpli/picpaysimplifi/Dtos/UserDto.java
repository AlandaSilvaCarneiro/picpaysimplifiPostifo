package projeto_picpaysimpli.picpaysimplifi.Dtos;

import java.math.BigDecimal;

import projeto_picpaysimpli.picpaysimplifi.Entities.TipoUser;

public record UserDto(
        String nome,
        String documneto,
        String email,
        TipoUser tipoUser,
        String senha,
        BigDecimal saldo
        
        ) {

}
