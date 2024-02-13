package com.dooribun.util;

import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.PutObjectRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.File;

@Slf4j
@RequiredArgsConstructor
@Component
public class S3Management {
    private final AmazonS3Client amazonS3Client;
    private static final String DEFAULT_PROFILE_DIR = "static/profile/";
    private static final String DEFAULT_POST_DIR = "static/post/";

    @Value("${cloud.aws.s3.bucket}")
    private String bucket;

    public String uploadProfileImage(Long memberId, File uploadFile) {
        String PATH = DEFAULT_PROFILE_DIR + memberId + "/";
        return putS3(uploadFile, PATH + uploadFile.getName());
    }

    public String uploadPostImage(Long postId, File uploadFile) {
            String PATH = DEFAULT_POST_DIR + postId + "/";
            return putS3(uploadFile, PATH + uploadFile.getName());
    }

    public boolean hasProfileImage(Long memberId, String fileName) {
        String PATH = DEFAULT_PROFILE_DIR + memberId + "/" + fileName;
        return amazonS3Client.doesObjectExist(bucket, PATH);
    }

    public boolean hasPostImage(Long postId, String fileName) {
        String PATH = DEFAULT_POST_DIR + postId + "/" + fileName;
        return amazonS3Client.doesObjectExist(bucket, PATH);
    }

    public void deleteObject(Long postId, String fileName) {
        String PATH = DEFAULT_POST_DIR + postId + "/" + fileName;
        amazonS3Client.deleteObject(bucket, PATH);
    }

    private String putS3(File uploadFile, String fileName) {
        amazonS3Client.putObject(
                new PutObjectRequest(bucket, fileName, uploadFile)
                        .withCannedAcl(CannedAccessControlList.PublicRead)
        );

        return amazonS3Client.getUrl(bucket, fileName).toString();
    }
}
