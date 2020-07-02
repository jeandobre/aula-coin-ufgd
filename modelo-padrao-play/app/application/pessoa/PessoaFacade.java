package application.pessoa;

import domain.processoseletivo.pessoa.CPF;
import domain.processoseletivo.pessoa.Endereco;
import domain.processoseletivo.pessoa.Pessoa;
import domain.processoseletivo.pessoa.PessoaRepository;

public class PessoaFacade {

	private PessoaRepository repositorio;

	public PessoaFacade(PessoaRepository repositorio) {
		this.repositorio = repositorio;
	}

	public void registrarPessoa(NovaPessoaDTO dto){

		CPF cpf = new CPF(dto.cpf);

		Endereco endereco = new Endereco(dto.cep);

		Pessoa pessoa = new Pessoa(dto.nome, cpf, endereco);

		repositorio.save(pessoa);
	}
}
