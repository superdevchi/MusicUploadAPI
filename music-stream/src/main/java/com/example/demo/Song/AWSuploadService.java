package com.example.demo.Song;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.PutObjectRequest;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

@Repository
public class AWSuploadService {


    public String URL;

    public String getFileName;

    public String getFileImageName;

    public String BucketName = "9music";


    AWSCredentials credentials = new BasicAWSCredentials("AKIARAQEMD63IEOP7S4R","WaV1iLHwLCqyAsKrjCElyZ1cSVYjF8wteU0LMcg8");


    AmazonS3 s3client = AmazonS3ClientBuilder
            .standard()
            .withCredentials(new AWSStaticCredentialsProvider(credentials))
            .withRegion(Regions.EU_NORTH_1)
            .build();


    public void uploadFile(MultipartFile file){
        File FileObj = convertMultiPartFileToFile(file);
        String FileName = System.currentTimeMillis() + "" + file.getOriginalFilename();
        getFileName = FileName;
    s3client.putObject( new PutObjectRequest("9music",FileName,FileObj).withCannedAcl(CannedAccessControlList.PublicRead));

     URL = String.valueOf(s3client.getUrl("9music", FileName));

        System.out.println("uploaded check mazon" + "url" + URL);


    }

    public void uploadFileImage(MultipartFile file){
        File FileObj = convertMultiPartFileToFile(file);
        String FileName = System.currentTimeMillis() + "" + file.getOriginalFilename();
        getFileImageName = FileName;
        s3client.putObject( new PutObjectRequest("9music",FileName,FileObj).withCannedAcl(CannedAccessControlList.PublicRead));

        URL = String.valueOf(s3client.getUrl("9music", FileName));

        System.out.println("uploaded check mazon" + "url" + URL);


    }

    // convert file for upload
    private File convertMultiPartFileToFile(MultipartFile file) {
        File convertedFile = new File(file.getOriginalFilename());
        try (FileOutputStream fos = new FileOutputStream(convertedFile)) {
            fos.write(file.getBytes());
        } catch (IOException e) {
            System.out.println("Error converting multipartFile to file");
        }
        return convertedFile;
    }

    public String GETURL(){
        return String.valueOf(s3client.getUrl(BucketName, getFileName));
    }

    public String GETURLIMAGE(){
        return String.valueOf(s3client.getUrl(BucketName, getFileImageName));
    }
}
