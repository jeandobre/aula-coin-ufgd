package command;

import java.util.LinkedList;
import java.util.Queue;

public class ExecutorComandos {
	private Queue<Comando> feitas;
	private Queue<Comando> desfeitas;

	public ExecutorComandos() {
		feitas = new LinkedList<>();
		desfeitas = new LinkedList<>();
	}

	public void executarComando(Comando c){
		c.fazer();
		feitas.offer(c);
		desfeitas.clear();
	}

	public void desfazer(){
		if(!feitas.isEmpty()){
			Comando c = feitas.poll();
			c.desfazer();
			desfeitas.offer(c);
		}
	}

	public void refazer(){
		if(!desfeitas.isEmpty()){
			Comando c = desfeitas.poll();
			c.fazer();
			feitas.offer(c);
		}
	}
}
