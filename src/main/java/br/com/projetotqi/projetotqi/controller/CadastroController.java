package br.com.projetotqi.projetotqi.controller;

import br.com.projetotqi.projetotqi.model.Usuario;
import br.com.projetotqi.projetotqi.repository.CadastroRepository;
//import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

//import org.slf4j.Logger;

@RestController /* Controlador */
@RequestMapping(value = "/service")
public class CadastroController {

   // private static final Logger LOGGER = LoggerFactory.getLogger(CadastroController.class);

    private final CadastroRepository cadastroRepository; /* Encapsulamento */
    @Autowired
    public CadastroController(CadastroRepository cadastroRepository) {
        this.cadastroRepository = cadastroRepository;
    }

    @PostMapping("/cadastro") /* Manda info pro sistema dizendo que vai postar algo */
    public Usuario cadastrarUsuario(@RequestBody Usuario usuario) { /*RequestBody = Tipo de info que está mandando*/
        return cadastroRepository.save(usuario);
    }

    @PostMapping("/login")
    public String login(@RequestBody Usuario usuario) {
        Usuario usuario1 = cadastroRepository.findByUsuarioAndSenha(usuario.getUsuario(), usuario.getSenha());

        if (usuario1 != null) {
            return "Bem-vindo!";
        } else {
            return "Falha no login.";
        }
    }

    @PostMapping("/solicitacaoEmprestimo")
    public String solicitacaoEmprestimo(@RequestBody Usuario usuario) {
        Usuario usuario1 = cadastroRepository.findByUsuario(usuario.getUsuario());

        try {
            if (usuario1.isElegivelParaEmprestimo() == true) {
                return "Elegivel para emprestimo";
            } else {
                return "Nao elegivel para emprestimo";
            }
        } catch (Exception e) {
            return "Usuario não encontrado";
        }
    }

    @PostMapping("/acompanhamentoDePropostas")
    public String acompanhamentoDePropostas(@RequestBody Usuario usuario){
        Usuario usuario1 = cadastroRepository.findByUsuario(usuario.getUsuario());
        try{
            if(usuario1.getPropostas() == null){
                return "Nao ha propostas atuais para esse usuario";
            } else{
                return "Numero de propostas: " + usuario1.getPropostas();
            }
        }catch(Exception e){
            return "Não ha propostas atuais para esse usuario ou usuario inexistente";
        }
    }
}
