package com.anvesh.caam;

import java.util.ArrayList;
import java.util.List;

import javafx.util.Pair;

public class ExtractandFormatDatafForEmail {
	
	public static List<Pair<String, String>> contacts = new ArrayList<Pair<String, String>>();
	
	public static List<Pair<String, String>> getContactInfoFromDB() {
		//get the contact info form database and populate the contacts object.
		
		List<UserInfo> userInfoList = null;
		
		for(UserInfo userInfo : userInfoList) {
			contacts.add(new Pair<String, String>(userInfo.getEmail(), "{ \"user\": " + userInfo.getFirstName() + "}"));
		}
		
		return contacts;
	}

}
