package hei.devweb.trophy.pojos;

/* Classe représentant l'objet Contact - correspond à la table contact de notre base de données */

public class Contact {
	
	/* On défini les quatres paramètres d'un Contact */
	
	private String prenomContact;
	private String nomContact;
	private String mailContact;
	private String messageContact;
	
	// constructeur de contact
	
	public Contact(String prenomContact, String nomContact, String mailContact, String messageContact) {
		super();
		this.prenomContact = prenomContact;
		this.nomContact = nomContact;
		this.mailContact = mailContact;
		this.messageContact = messageContact;
	}
	
	/* getter et setters auto-générés indispensables */

	public String getPrenomContact() {
		return prenomContact;
	}

	public void setPrenomContact(String prenomContact) {
		this.prenomContact = prenomContact;
	}

	public String getNomContact() {
		return nomContact;
	}

	public void setNomContact(String nomContact) {
		this.nomContact = nomContact;
	}

	public String getMailContact() {
		return mailContact;
	}

	public void setMailContact(String mailContact) {
		this.mailContact = mailContact;
	}

	public String getMessageContact() {
		return messageContact;
	}

	public void setMessageContact(String messageContact) {
		this.messageContact = messageContact;
	}

}
