package com.anvesh.ses;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailService;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailServiceClientBuilder;
import com.amazonaws.services.simpleemail.model.Body;
import com.amazonaws.services.simpleemail.model.Content;
import com.amazonaws.services.simpleemail.model.Destination;
import com.amazonaws.services.simpleemail.model.Message;
import com.amazonaws.services.simpleemail.model.SendEmailRequest;

import utils.CreateAWSClient;


public class AmazonSES {

    // This address must be verified with Amazon SES.
    final String FROMADDRESS = "anveshpmakey@gmail.com";

    final String TOADDRESS = "uh@caam.pk";

    // The subject line for the email.
    final String SUBJECT = "One last step to complete your registration with PhotoApp";

    // The HTML body for the email.
    final String HTMLBODY = "<h1>Please verify your email address</h1>"
            + "<p>Thank you for registering with our mobile app. To complete registration process and be able to log in,"
            + " click on the following link: "
            + "<a href='http://localhost:8080/MOBILE-APP-WS-DEV/verify-email.jsp?token=$tokenValue'>"
            + "Final step to complete your registration"
            + "</a><br/><br/>"
            + "Thank you! And we are waiting for you inside!";
    // The email body for recipients with non-HTML email clients.
    final String TEXTBODY = "Please verify your email address. "
            + "Thank you for registering with our mobile app. To complete registration process and be able to log in,"
            + " open then the following URL in your browser window: "
            + " http://localhost:8080/MOBILE-APP-WS-DEV/verify-email.jsp?token=$tokenValue"
            + " Thank you! And we are waiting for you inside!";

    public void verifyEmail()
    {
        try {
			/*
			 * BasicAWSCredentials awsCreds = new
			 * BasicAWSCredentials("AKIAQ2RG3Z63IFDPGCT7",
			 * "Rm9U762OWcbCB+DXiX3gqC+nmPBN4AVAqAIXZ910"); AmazonSimpleEmailService client
			 * = AmazonSimpleEmailServiceClientBuilder.standard() .withCredentials(new
			 * AWSStaticCredentialsProvider(awsCreds))
			 * .withRegion(Regions.US_EAST_1).build();
			 */
        	
        	AmazonSimpleEmailService client = CreateAWSClient.createAWSClient();

            SendEmailRequest request = new SendEmailRequest()
                    .withDestination(
                            new Destination().withToAddresses(TOADDRESS) )
                    .withMessage(new Message()
                            .withBody(new Body()
                                    .withHtml(new Content()
                                            .withCharset("UTF-8").withData(HTMLBODY))
                                    .withText(new Content()
                                            .withCharset("UTF-8").withData(TEXTBODY)))
                            .withSubject(new Content()
                                    .withCharset("UTF-8").withData(SUBJECT)))
                    .withSource(FROMADDRESS);
            client.sendEmail(request);

            System.out.println("Email sent!");

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }


    public static void main(String[] args)
    {
        new AmazonSES().verifyEmail();
    }

}
