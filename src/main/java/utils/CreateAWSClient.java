package utils;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailService;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailServiceClientBuilder;

public class CreateAWSClient {
	
	static AmazonSimpleEmailService client = null;
	
	public static AmazonSimpleEmailService createAWSClient() {
		BasicAWSCredentials awsCreds = new BasicAWSCredentials("AKIAQ2RG3Z63IFDPGCT7", "Rm9U762OWcbCB+DXiX3gqC+nmPBN4AVAqAIXZ910");
        
		if (client == null) {
			AmazonSimpleEmailService client =
	                AmazonSimpleEmailServiceClientBuilder.standard()
	                        .withCredentials(new AWSStaticCredentialsProvider(awsCreds))
	                        .withRegion(Regions.US_EAST_1).build();
	        
	        return client;
		} else {
			return client;
		}
		
	}

}
