package br.com.projetotqi.projetotqi.repository;

import br.com.projetotqi.projetotqi.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CadastroRepository extends JpaRepository<Usuario, Long> {
    Usuario findByUsuarioAndSenha(String usuario, String senha);
    Usuario findByUsuario(String usuario);
}
