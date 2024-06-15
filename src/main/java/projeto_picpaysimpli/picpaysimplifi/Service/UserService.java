package projeto_picpaysimpli.picpaysimplifi.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import projeto_picpaysimpli.picpaysimplifi.Entities.Usuario;
import projeto_picpaysimpli.picpaysimplifi.Repository.UserRepositori;

@Service
public class UserService {
    @Autowired
    UserRepositori userRepositori;

    public void registraUser(Usuario usuario) {
        userRepositori.save(usuario);
    }

    public List<Usuario> listaUser() {
        return userRepositori.findAll();
    }

    public void upateUser(Usuario usuario){
        this.userRepositori.save(usuario);
    }

}
