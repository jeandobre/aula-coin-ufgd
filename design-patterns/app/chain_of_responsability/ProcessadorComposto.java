package chain_of_responsability;

import bridge.PosProcessador;

import java.util.List;

public class ProcessadorComposto implements PosProcessador {

	private List<PosProcessador> processadores;

	public ProcessadorComposto(List<PosProcessador> processadores) {
		this.processadores = processadores;
	}

	@Override
	public byte[] processar(byte[] bytes) {
		for(PosProcessador p : processadores)
			bytes = p.processar(); //o livro estava com esse erro aki
		return bytes;
	}
}
