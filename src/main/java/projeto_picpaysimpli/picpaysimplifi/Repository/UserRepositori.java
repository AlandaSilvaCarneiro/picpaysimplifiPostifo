package projeto_picpaysimpli.picpaysimplifi.Repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import projeto_picpaysimpli.picpaysimplifi.Entities.Usuario;
import java.util.Optional;


public interface UserRepositori extends JpaRepository<Usuario,UUID>{
   Optional<Usuario> getByEmail(String email);
}
