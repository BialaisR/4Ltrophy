package hei.devweb.trophy.pojos;

public class Evenements {

	private Integer idEvent;
	private String dateEvent;
	private String event;

	public Evenements(Integer idEvent, String dateEvent, String event) {
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

	public String getDateEvent() {
		return dateEvent;
	}

	public void setDateEvent(String dateEvent) {
		this.dateEvent = dateEvent;
	}

	public String getEvent() {
		return event;
	}

	public void setEvent(String event) {
		this.event = event;
	}

}
