package hei.devweb.trophy.services;

import java.util.List;

import hei.devweb.trophy.daos.MessageDao;
import hei.devweb.trophy.pojos.Message;

public class MessageService {
	
	private MessageDao messageDao = new MessageDao();
	
	private static class MessageerviceHolder {
		private static MessageService instance = new MessageService();
	}
	
	public static MessageService getInstance() {
		return MessageerviceHolder.instance;
	}

	private MessageService() {
	}
	
	public List<Message> listMessage() {
		return messageDao.listMessage();
	}
	
	public void addMessage(Integer idMessage, String texteMessage, String datePost, Integer idSujet){
		messageDao.addMessage(idMessage,texteMessage,datePost,idSujet);
	}
	
	public void deleteMessage(Integer idMessage){
		try {
			messageDao.deleteMessage(idMessage);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
