package Config.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import Config.Model.Cadastro;

public interface CadastroRepository extends JpaRepository<Cadastro, Long> {

}
