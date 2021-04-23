package Config.Service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Config.Exception.CadastroNotFoundException;
import Config.Model.Cadastro;
import Config.Repository.CadastroRepository;

@Service
public class CadastroService {

	@Autowired
	private CadastroRepository cadastroRepository;

	public List<Cadastro> buscarTodosOscadastro() {
		List<Cadastro> listcadastro = cadastroRepository.findAll();
		Collections.sort(listcadastro, Comparator.comparing(Cadastro::getCpf));
		return listcadastro;
	}

	public Cadastro cadastroNovo(Cadastro cadastro)throws CadastroNotFoundException  {
		Long cpf = cadastro.getCpf();
		Optional<Cadastro> result = cadastroRepository.findById(cpf);
		if(!result.isEmpty()) {
			throw new CadastroNotFoundException("Cadastro já encontrado no sistemas com o CPF: " + cpf);
		} else {
		cadastroRepository.saveAndFlush(cadastro);
		return cadastro;
		}
	}

	public void deletarPorId(Long cpf) throws CadastroNotFoundException {
		Optional<Cadastro> optionalCadastro = getOptional(cpf);
		if (!optionalCadastro.isPresent()) {
			throw new CadastroNotFoundException("cadastro nao encontrado atraves do ID: " + cpf);
		} else {
			cadastroRepository.delete(optionalCadastro.get());
		}
	}

	public Cadastro buscarPorId(Long cpf) throws CadastroNotFoundException {
		Optional<Cadastro> optionalCadastro = getOptional(cpf);
		Cadastro cadastro = null;
		if (!optionalCadastro.isPresent()) {
			throw new CadastroNotFoundException("cadastro nao encontrado atraves do ID: " + cpf);
		} else {
			cadastro = optionalCadastro.get();
		}
		return cadastro;
	}

	private Optional<Cadastro> getOptional(Long cpf) {
		Optional<Cadastro> optionalCadastro = cadastroRepository.findById(cpf);
		return optionalCadastro;
	}

	public Cadastro atualizaPorId(Long cpf, Cadastro cadastro)
			throws CadastroNotFoundException {

		Cadastro cadastroNew = cadastroRepository.findById(cpf)
				.orElseThrow(() -> new CadastroNotFoundException(" cadastro não encontrado em :: " + cpf));

		cadastroNew.setName(cadastro.getName());
		cadastroNew.setEmail(cadastro.getEmail());
		cadastroNew.setJob(cadastro.getJob());
		
		Cadastro updatedcadastro = cadastroRepository.save(cadastroNew);
		return updatedcadastro;
	}
	

}