package Config.Controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Config.Exception.CadastroNotFoundException;
import Config.Model.Cadastro;
import Config.Service.CadastroService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/api")
public class Controller {

	@Autowired
	private CadastroService cadastroService;

	@GetMapping(path = "/health")
	public String health() {
		LocalDateTime agora = LocalDateTime.now();
		DateTimeFormatter formatado = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
		return agora.format(formatado);
	}

	@GetMapping(path = "/cadastro/list")
	public List<Cadastro> buscarTodosCadastros() {
		return cadastroService.buscarTodosOscadastro();
	}

	@GetMapping(path = "/cadastro/id/{cpf}")
	public Cadastro buscarCadastroPorCpf(@PathVariable(name = "cpf", required = true) Long cpf)
			throws CadastroNotFoundException {
		return cadastroService.buscarPorId(cpf);
	}

	@PostMapping(path = "/cadastro/save")
	public Cadastro salvarCadastro(@RequestBody Cadastro cadastro) throws CadastroNotFoundException {
		cadastroService.cadastroNovo(cadastro);
		return cadastro;
	}

	@DeleteMapping(path = "/cadastro/delete/{cpf}")
	public void deleteCadastro(@PathVariable(name = "cpf", required = true) Long cpf) throws CadastroNotFoundException {
		cadastroService.deletarPorId(cpf);
	}

	@PutMapping(path = "/cadastro/put/{cpf}")
	public Cadastro putNutricionista(@PathVariable(name = "cpf", required = true) Long cpf,
			@Valid @RequestBody Cadastro cadastro) throws CadastroNotFoundException {
		cadastroService.atualizaPorId(cpf, cadastro);
		return cadastroService.buscarPorId(cpf);
	}

}