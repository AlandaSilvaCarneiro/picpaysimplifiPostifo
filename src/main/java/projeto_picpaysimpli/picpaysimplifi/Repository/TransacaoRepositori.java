package projeto_picpaysimpli.picpaysimplifi.Repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import projeto_picpaysimpli.picpaysimplifi.Entities.Transacao;

@Repository
public interface TransacaoRepositori extends JpaRepository<Transacao,UUID> {

}
