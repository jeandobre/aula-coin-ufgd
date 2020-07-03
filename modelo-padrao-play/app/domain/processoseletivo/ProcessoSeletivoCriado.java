package domain.processoseletivo;

import infra.DomainEvent;

import java.util.Date;

public class ProcessoSeletivoCriado implements DomainEvent {

	private Integer id;

	private String titulo;
	private int eventVersion;
	private Date occurredOn;

	public ProcessoSeletivoCriado(Integer id, String titulo) {
		this.id = id;
		this.titulo = titulo;
	}

	@Override
	public int eventVersion() {
		return this.eventVersion;
	}

	@Override
	public Date occurredOn() {
		return this.occurredOn;
	}
}
