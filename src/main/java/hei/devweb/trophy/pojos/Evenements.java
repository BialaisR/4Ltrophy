package hei.devweb.trophy.pojos;

import java.time.LocalDate;

public class Evenements {

	private Integer idEvent;
	private LocalDate dateEvent;
	private String event;

	public Evenements(Integer idEvent, LocalDate dateEvent, String event) {
		super();
		this.idEvent = idEvent;
		this.dateEvent = dateEvent;
		this.event = event;
	}

	public Integer getIdEvent() {
		return idEvent;
	}

	public void setIdEvent(Integer idEvent) {
		this.idEvent = idEvent;
	}

	public LocalDate getDateEvent() {
		return dateEvent;
	}

	public void setDateEvent(LocalDate dateEvent) {
		this.dateEvent = dateEvent;
	}

	public String getEvent() {
		return event;
	}

	public void setEvent(String event) {
		this.event = event;
	}

}
