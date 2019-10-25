package com.anvesh.caam;

import java.util.ArrayList;
import java.util.List;

import javafx.util.Pair;

public class ExtractandFormatDatafForEmail {
	
	public static List<Pair<String, String>> contacts = new ArrayList<Pair<String, String>>();
	
	public static List<Pair<String, String>> getContactInfoFromDB() {
		//get the contact info form database and populate the contacts object.
		
		List<UserInfo> userInfoList = populateUserInfoForTesting();
		
		for(UserInfo userInfo : userInfoList) {
			contacts.add(new Pair<String, String>(userInfo.getEmail(), "{ \"user\": " + userInfo.getFirstName() + "}"));
		}
		
		return contacts;
	}
	
	private static List<UserInfo> populateUserInfoForTesting() {
		List<UserInfo> userInfoList = new ArrayList<UserInfo>();
		
		UserInfo userInfo1 = new UserInfo("anveshpmakey@yahoo.com", "Anvesh", "Makey");
		UserInfo userInfo2 = new UserInfo("uh@caam.pk", "Umer", "");
		
		userInfoList.add(userInfo1);
		userInfoList.add(userInfo2);
		
		return userInfoList;
		
		
	}

}
