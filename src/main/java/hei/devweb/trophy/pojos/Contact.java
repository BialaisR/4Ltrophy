package hei.devweb.trophy.pojos;

public class Contact {
	
	private String prenomContact;
	private String nomContact;
	private String mailContact;
	private String messageContact;
	
	public Contact(String prenomContact, String nomContact, String mailContact, String messageContact) {
		super();
		this.prenomContact = prenomContact;
		this.nomContact = nomContact;
		this.mailContact = mailContact;
		this.messageContact = messageContact;
	}

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
