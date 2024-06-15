package projeto_picpaysimpli.picpaysimplifi.Entities;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.ManyToAny;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Transacao ")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Transacao {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "id_enviaUser")
    private Usuario envioUser;

    @ManyToOne
    @JoinColumn(name = "id_recebeUser")
    private Usuario receberUser;

    private BigDecimal saldoTrasfe;

    private LocalDateTime data;

    public Transacao(Usuario envioUser, Usuario receberUser, double saldoTrasfe) {
        this.envioUser = envioUser;
        this.receberUser = receberUser;
        this.saldoTrasfe = BigDecimal.valueOf(saldoTrasfe);
        this.data = LocalDateTime.now();
    }

}
