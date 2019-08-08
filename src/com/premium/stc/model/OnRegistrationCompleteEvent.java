package com.premium.stc.model;

import java.util.Locale;


import com.premium.stc.model.User;

public class OnRegistrationCompleteEvent {
	
	private String appUrl;
	private Locale locale;
	private User user;
	
	private OnRegistrationCompleteEvent(User user, Locale locale, String appUrl) {
		this.appUrl = appUrl;
		this.locale = locale;
		this.user = user;
	}
	
	
	public String getAppUrl() {
		return appUrl;
	}


	public void setAppUrl(String appUrl) {
		this.appUrl = appUrl;
	}


	public Locale getLocale() {
		return locale;
	}


	public void setLocale(Locale locale) {
		this.locale = locale;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}

	
}
