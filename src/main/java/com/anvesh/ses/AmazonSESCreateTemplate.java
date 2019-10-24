package com.anvesh.ses;

import com.amazonaws.services.simpleemail.AmazonSimpleEmailService;
import com.amazonaws.services.simpleemail.model.CreateTemplateRequest;
import com.amazonaws.services.simpleemail.model.CreateTemplateResult;
import com.amazonaws.services.simpleemail.model.DeleteTemplateRequest;
import com.amazonaws.services.simpleemail.model.DeleteTemplateResult;
import com.amazonaws.services.simpleemail.model.Template;

import utils.CreateAWSClient;

public class AmazonSESCreateTemplate {
    
    private static String templateName = "CaamWelcomeTemplate";
    private static String emailText = "Welcome {{user}}.";
	/*
	 * private static String htmlPart = "\"<h1>Welcome {{user}}</h1>\n" +
	 * "                 <p>You have indicated that you are interested in receiving \n"
	 * + "                   information about Caam Solutions</p>\n" +
	 * "                 <p>You can change these settings at any time by visiting \n"
	 * + "                    the <a href=https://www.caam.pk \n "+
	 * "                    Preference Center</a>.</p>\"";
	 */
    public static AmazonSimpleEmailService client = CreateAWSClient.createAWSClient();
    
	public static void createEmailTemplate() {
		System.out.println("Creating Email Template");
		Template template = new Template();
        template.setTemplateName(templateName);
        template.setSubjectPart("Welcome mail");
        template.setTextPart(emailText);
        //template.setHtmlPart(htmlPart);
        CreateTemplateRequest createTemplateRequest = new CreateTemplateRequest();
        createTemplateRequest.setTemplate(template);
        CreateTemplateResult result = client.createTemplate(createTemplateRequest);
        System.out.println(result.getSdkResponseMetadata());
        System.out.println("Email Template created");
	}
	
	public static void deleteTemplate() {
		System.out.println("Deleting Email Template");
        DeleteTemplateRequest deleteTemplateRequest = new DeleteTemplateRequest();
        deleteTemplateRequest.setTemplateName(templateName);
        DeleteTemplateResult result = client.deleteTemplate(deleteTemplateRequest);
        System.out.println(result.getSdkResponseMetadata());
        System.out.println("Email Template deleted");
    }

}
