package com.aws.s3.uploadExample;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.SdkClientException;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.Bucket;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.CreateBucketRequest;
import com.amazonaws.services.s3.model.GetBucketLocationRequest;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;

@SpringBootApplication
public class UploadExampleApplication {

	private static final String SUFFIX = "/";
	public static void main(String[] args) {


		try {
			AWSCredentials awsCredentials = new BasicAWSCredentials("AKIA6ADJ6DOU4WJ7PAOG", "yc0UKQ8h9ZhvC5pyMpOP1kEj+0LVlUDgiRYqTGOj");

			AmazonS3 s3Client = AmazonS3ClientBuilder.standard().
					withCredentials(new AWSStaticCredentialsProvider(awsCredentials))
					.withRegion(Regions.US_EAST_2)
					.build();
			
			// to demonstrate delete this bucket first.
			String bktName = "navi7971-test-upload-files"; // unique for region
			
			//	if(!s3Client.doesBucketExistV2(bktName)) {

			s3Client.createBucket(new CreateBucketRequest(bktName));

			for (Bucket bucket : s3Client.listBuckets()) {
				System.out.println("Existing bucket  = = = = ==  >  "+ bucket.getName());
			}
			String bucketLocation = s3Client.getBucketLocation(new GetBucketLocationRequest(bktName));
			System.out.println("Bucket location = = = = = >  " + bucketLocation);

			String folderName = "testfolder";
			createFolder(bktName, folderName, s3Client);

			String fileName = folderName + SUFFIX + "getProfileImage.jpg";
			s3Client.putObject(new PutObjectRequest(bktName, fileName, 
					new File("C:\\Users\\Leo\\Documents\\getProfileImage.jpg"))
			.withCannedAcl(CannedAccessControlList.PublicRead));

		} catch (AmazonServiceException e) {
			System.out.println(e.getMessage());
		} catch (SdkClientException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		SpringApplication.run(UploadExampleApplication.class, args);
	}

	public static void createFolder(String bucketName, String folderName, AmazonS3 client) {
		// create meta-data for your folder and set content-length to 0
		ObjectMetadata metadata = new ObjectMetadata();
		metadata.setContentLength(0);
		// create empty content
		InputStream emptyContent = new ByteArrayInputStream(new byte[0]);
		// create a PutObjectRequest passing the folder name suffixed by /
		PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName,
				folderName + SUFFIX, emptyContent, metadata);
		// send request to S3 to create folder
		client.putObject(putObjectRequest);
	}


}
