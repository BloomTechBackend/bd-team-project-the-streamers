package dynamoDB;

import com.amazonaws.auth.DefaultAWSCredentialsProviderChain;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;

public class DynamoDBClientProvider {
    public DynamoDBClientProvider() {
    }

    public static AmazonDynamoDB getDynamoDBClient() {
        return getDynamoDBClient(Regions.US_WEST_2);
    }

    public static AmazonDynamoDB getDynamoDBClient(Regions region) {
        if (null == region) {
            throw new IllegalArgumentException("region cannot be null");
        } else {
            return (AmazonDynamoDB)((AmazonDynamoDBClientBuilder)((AmazonDynamoDBClientBuilder)AmazonDynamoDBClientBuilder
                    .standard()
                    .withCredentials(DefaultAWSCredentialsProviderChain.getInstance()))
                    .withRegion(region))
                    .build();
        }
    }
}
