package com.anvesh.ses;

import java.util.ArrayList;
import java.util.List;

import javafx.util.Pair;


import utils.CreateAWSClient;

import com.amazonaws.services.simpleemail.AmazonSimpleEmailService;
import com.amazonaws.services.simpleemail.model.BulkEmailDestination;
import com.amazonaws.services.simpleemail.model.Destination;
import com.amazonaws.services.simpleemail.model.SendBulkTemplatedEmailRequest;
import com.amazonaws.services.simpleemail.model.SendBulkTemplatedEmailResult;
import com.amazonaws.services.simpleemail.model.SendTemplatedEmailRequest;
import com.amazonaws.services.simpleemail.model.SendTemplatedEmailResult;

public class AmazonSESSendBulkEmail {
	
	 private static String templateName = "CaamWelcomeTemplate";
	 private static String senderEmail = "anveshpmakey@gmail.com";
	 
	 private static String dataFormat = "{ \"user\":\"%s\" }";
	 private static List<Pair<String, String>> contacts = new ArrayList<Pair<String, String>>();
	
	private static void sendBulkEmail() {
		
		System.out.println("Sending bulk email");
		AmazonSimpleEmailService client = CreateAWSClient.createAWSClient();
		
		List<BulkEmailDestination> bulkEmailDestinations = new ArrayList<BulkEmailDestination>();
		
        for(Pair<String, String> contact :contacts) {
        	Destination destination = new Destination();
            List<String> toAddresses = new ArrayList<String>();
            toAddresses.add(contact.getKey());
            destination.setToAddresses(toAddresses);
            
            BulkEmailDestination bulkEmailDestination = new BulkEmailDestination();
            bulkEmailDestination.setDestination(destination);
            bulkEmailDestination.setReplacementTemplateData(String.format(dataFormat, contact.getValue()));
            bulkEmailDestinations.add(bulkEmailDestination);
        }
        
        SendBulkTemplatedEmailRequest bulkTemplatedEmailRequest = new SendBulkTemplatedEmailRequest();
        bulkTemplatedEmailRequest.withDestinations(bulkEmailDestinations);
        bulkTemplatedEmailRequest.withTemplate(templateName);
        bulkTemplatedEmailRequest.withDefaultTemplateData(String.format(dataFormat, "UserNameNotAvailable"));
        bulkTemplatedEmailRequest.withSource(senderEmail);
        SendBulkTemplatedEmailResult bulkTemplatedEmailResult = client.sendBulkTemplatedEmail(bulkTemplatedEmailRequest);
        System.out.println("Bulk email status - " + bulkTemplatedEmailResult.getStatus());
    }
	
	private static void populateContacts() {
		contacts.add(new Pair<String, String>("anveshpmakey@yahoo.com", "{ \"user\":\"Anvesh\" }"));
		contacts.add(new Pair<String, String>("uh@caam.pk", "{ \"user\":\"Umer\" }"));
	}
	
	public static void main(String[] args) throws Exception {
        AmazonSESCreateTemplate.createEmailTemplate();
        try {
        	populateContacts();
            sendBulkEmail();
        } catch(Exception e) {
        	System.out.println("*****************************************************");
        	System.out.println("Exception");
        	e.printStackTrace();
        }
        finally {
        	AmazonSESCreateTemplate.deleteTemplate();
        }
    }

}
