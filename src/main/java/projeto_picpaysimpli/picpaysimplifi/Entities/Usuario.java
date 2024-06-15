package projeto_picpaysimpli.picpaysimplifi.Entities;

import java.math.BigDecimal;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import projeto_picpaysimpli.picpaysimplifi.Dtos.UserDto;

@Entity
@Table(name = "Usuarios")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String nome;

    @Column(unique = true)
    private String email;

    @Column(unique = true)
    private String senha;

    @Column(unique = true)
    private String documneto;

    private TipoUser usertipo;

    private BigDecimal saldo;

    public Usuario(UserDto userDto) {
        this.nome = userDto.nome();
        this.email = userDto.email();
        this.senha = userDto.senha();
        this.documneto = userDto.documneto();
        this.usertipo = userDto.tipoUser();
        this.saldo = userDto.saldo();
    }

}
