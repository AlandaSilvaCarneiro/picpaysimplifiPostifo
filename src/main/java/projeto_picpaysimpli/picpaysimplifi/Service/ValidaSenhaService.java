package projeto_picpaysimpli.picpaysimplifi.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import org.springframework.stereotype.Service;

@Service
public class ValidaSenhaService {

    public List<String> validaSenha(String senha){
        List falhasenha = new ArrayList<>();
        verifTamanho(falhasenha,senha);
        verifMaisusculo(falhasenha,senha);
        verifMinusnculo(falhasenha,senha);
        verifNumero(falhasenha, senha);
        verifEspecialCaract(falhasenha,senha);

        return falhasenha;
    }

     public List<String> verifTamanho(List<String> falhasenha, String senha){
        if(senha != null && senha.length() < 8){
            falhasenha.add("senha precisa de pelo menos 8 caracteres");
        } 
        
        return falhasenha;
     }
     public List<String> verifMaisusculo(List<String> falhasenha, String senha){
        if(!Pattern.matches(".*[A-Z].*", senha)){
            falhasenha.add("senha precisa de pelo menos uma letra maiscula");
        } 
        return falhasenha;
     }

     public List<String> verifMinusnculo(List<String> falhasenha, String senha){
        if(!Pattern.matches(".*[a-z].*", senha)){
            falhasenha.add("senha precisa de pelo menos uma letra minuscula");
        } 
        return falhasenha;
     
    }

    public List<String> verifNumero(List<String> falhasenha, String senha){
        if(!Pattern.matches(".*[0-9].*", senha)){
            falhasenha.add("senha precisa de pelo menos um numero");
        } 
        return falhasenha;
    }

    public List<String> verifEspecialCaract(List<String> falhasenha, String senha){
        if(!Pattern.matches(".*[\\W].*", senha)){
            falhasenha.add("senha precisa de pelo menos um caracter especial");
        } 
        return falhasenha;
    }

    

}
