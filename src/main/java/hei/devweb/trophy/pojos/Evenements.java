package hei.devweb.trophy.pojos;

/* Classe représentant l'objet Evenements - correspond à la table evenements de notre base de données */

public class Evenements {

	// On défini les 3 paramètres d'un événement
	
	private Integer idEvent;
	private String dateEvent;
	private String event;
	
	// constructeur d'événement

	public Evenements(Integer idEvent, String dateEvent, String event) {
		super();
		this.idEvent = idEvent;
		this.dateEvent = dateEvent;
		this.event = event;
	}
	
	/* getter et setters auto-générés indispensables */

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
