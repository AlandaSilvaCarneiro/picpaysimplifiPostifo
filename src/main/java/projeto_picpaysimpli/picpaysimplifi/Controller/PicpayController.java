package projeto_picpaysimpli.picpaysimplifi.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import projeto_picpaysimpli.picpaysimplifi.Dtos.TransacaoDto;
import projeto_picpaysimpli.picpaysimplifi.Dtos.UserDto;
import projeto_picpaysimpli.picpaysimplifi.Entities.Transacao;
import projeto_picpaysimpli.picpaysimplifi.Entities.Usuario;
import projeto_picpaysimpli.picpaysimplifi.Service.TrasacaoService;
import projeto_picpaysimpli.picpaysimplifi.Service.UserService;
import projeto_picpaysimpli.picpaysimplifi.Service.ValidaSenhaService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping(value = "/Picpay")

public class PicpayController {
    @Autowired
    private UserService userService;

    @Autowired
    private ValidaSenhaService validaSenhaService;

    @Autowired
    private TrasacaoService trasacaoService;

    @PostMapping("/registro")
    public ResponseEntity<?> RegistraUsuario(@Validated @RequestBody UserDto userDto) {
        var senhafalhas = validaSenhaService.validaSenha(userDto.senha());
        System.out.println(senhafalhas);
        if (!senhafalhas.isEmpty()) {
            return ResponseEntity.ok(senhafalhas.toString());
        }
        var user = new Usuario(userDto);
        userService.registraUser(user);
        return ResponseEntity.ok("Deu certo");

    }

    @PostMapping("/transacao")
    public ResponseEntity<?> CriarTransacao(@Validated @RequestBody TransacaoDto transacaoDto) throws Exception {
        trasacaoService.criaTrasacao(transacaoDto);
        return ResponseEntity.ok().body("Transação feita");

    }

    @GetMapping("/allUser")
    public ResponseEntity<List<Usuario>> listatUsusario() {
        List<Usuario> useList = this.userService.listaUser();
        return new ResponseEntity<>(useList, HttpStatus.OK);
    }

    @GetMapping("/allTransacao")
    public ResponseEntity<List<Transacao>> listaTran() {

        return new ResponseEntity<>(this.trasacaoService.listTran(), HttpStatus.OK);
    }

}
