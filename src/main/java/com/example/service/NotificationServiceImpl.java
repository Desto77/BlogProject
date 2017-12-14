package com.example.service;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NotificationServiceImpl implements NotificationService {

	public static final String NOTIFY_MSG_SESSION_KEY = "siteNotificationMessages";

	@Autowired
	private HttpSession httpSession;

	@Override
	public void addInfoMessage(String msg) {
		addNotificationMessage(NotificationMessageType.INFO, msg);
	}

	@Override
	public void addErrorMessage(String msg) {
		addNotificationMessage(NotificationMessageType.ERROR, msg);
	}

	private void addNotificationMessage(NotificationMessageType type, String msg) {
		List<NotificationMessage> notifyMessages = (List<NotificationMessage>) httpSession
				.getAttribute(NOTIFY_MSG_SESSION_KEY);
		if (notifyMessages == null) {
			notifyMessages = new ArrayList<NotificationMessage>();
		}
		notifyMessages.add(new NotificationMessage(type, msg));
		httpSession.setAttribute(NOTIFY_MSG_SESSION_KEY, notifyMessages);
	}

	public enum NotificationMessageType {
		INFO, ERROR
	}

	public class NotificationMessage {
		NotificationMessageType type;
		String text;

		public NotificationMessage(NotificationMessageType type, String text) {
			this.type = type;
			this.text = text;
		}

		public NotificationMessageType getType() {
			return type;
		}

		public String getText() {
			return text;
		}
	}

}
