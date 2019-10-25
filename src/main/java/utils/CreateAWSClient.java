package utils;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.auth.EnvironmentVariableCredentialsProvider;
import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailService;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailServiceClient;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailServiceClientBuilder;

public class CreateAWSClient {
	
	static AmazonSimpleEmailService client = null;
	
	public static AmazonSimpleEmailService createAWSClient() {
        
		if (client == null) {
			
			AWSCredentialsProvider credentialsProvider = new ProfileCredentialsProvider("aws-email");
			
			/*
			 * client = AmazonSimpleEmailServiceClientBuilder.standard()
			 * .withCredentials(new AWSStaticCredentialsProvider(awsCreds))
			 * .withRegion(Regions.US_EAST_1).build();
			 */
			
			/*
			 * client = AmazonSimpleEmailServiceClientBuilder.standard()
			 * .withCredentials(new DefaultAwsCredentialsProviderChain())
			 * .withRegion(Regions.US_EAST_1) .build();
			 */
			
			/*
			 * client = AmazonSimpleEmailServiceClientBuilder.standard()
			 * .withRegion(Regions.US_EAST_1) .build();
			 */
			
			client = AmazonSimpleEmailServiceClientBuilder.standard()
					.withCredentials(credentialsProvider)
					.withRegion(Regions.US_EAST_1)
					.build();
	        
	        return client;
		} else {
			return client;
		}
		
	}

}
