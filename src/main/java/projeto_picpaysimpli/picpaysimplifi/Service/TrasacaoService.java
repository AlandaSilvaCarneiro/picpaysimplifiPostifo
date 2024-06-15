package projeto_picpaysimpli.picpaysimplifi.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import projeto_picpaysimpli.picpaysimplifi.Dtos.NotificatioDto;
import projeto_picpaysimpli.picpaysimplifi.Dtos.TransacaoDto;
import projeto_picpaysimpli.picpaysimplifi.Entities.TipoUser;
import projeto_picpaysimpli.picpaysimplifi.Entities.Transacao;
import projeto_picpaysimpli.picpaysimplifi.Entities.Usuario;
import projeto_picpaysimpli.picpaysimplifi.Repository.TransacaoRepositori;
import projeto_picpaysimpli.picpaysimplifi.Repository.UserRepositori;

@Service
public class TrasacaoService {
    @Autowired
    private UserRepositori UserRepositori;
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private TransacaoRepositori transacaoRepositori;

    public void criaTrasacao(TransacaoDto dTransacaoDto) throws Exception {
        Optional<Usuario> enviaUser = UserRepositori.getByEmail(dTransacaoDto.emailEnvia());
        Optional<Usuario> receberUser = UserRepositori.getByEmail(dTransacaoDto.emaailRecebe());
        validaTrasacao(dTransacaoDto, enviaUser, receberUser);

        Transacao novaTransacao = new Transacao(enviaUser.get(), receberUser.get(), 20.0);
        enviaUser.get().setSaldo(enviaUser.get().getSaldo().subtract(novaTransacao.getSaldoTrasfe()));
        receberUser.get().setSaldo(receberUser.get().getSaldo().add(novaTransacao.getSaldoTrasfe()));
        UserRepositori.save(enviaUser.get());
        UserRepositori.save(receberUser.get());
        transacaoRepositori.save(novaTransacao);
        // notificaService(receberUser.get(), "valor recebido");

    }

    public void validaTrasacao(TransacaoDto transacaoDto, Optional<Usuario> enviaUser, Optional<Usuario> recebeUser)
            throws Exception {

        if (!enviaUser.isPresent()) {
            throw new Exception("enviaUser  não encontrado");

        }
        if (!recebeUser.isPresent()) {
            throw new Exception("recebeUser  não encontrado");

        }
        if (enviaUser.get().getUsertipo() != TipoUser.User || recebeUser.get().getUsertipo() != TipoUser.Lojista) {
            throw new Exception("Tipo de usurio não esta autorizado a realezar transação");

        }
        if (enviaUser.get().getSaldo().compareTo(transacaoDto.saldoTransa()) < 0) {
            throw new Exception("saldo induficiente para realizar a transaçõa");

        }

    }

    public List<Transacao> listTran() {
        return transacaoRepositori.findAll();
    }

   
}
