package Skufestivalback.skufestival.S3;

import com.amazonaws.SdkClientException;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.S3ObjectInputStream;
import com.amazonaws.util.IOUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

//@Configuration
//public class S3Config {
//    @Value("${cloud.aws.credentials.access-key}")
//    private String accessKey;
//
//    @Value("${cloud.aws.credentials.secret-key}")
//    private String secretKey;
//
//    @Value("${cloud.aws.region.static}")
//    private String region;
//
//    @Bean
//    public AmazonS3 amazonS3() {
//        BasicAWSCredentials credentials = new BasicAWSCredentials(accessKey, secretKey);
//
//        return AmazonS3ClientBuilder
//                .standard()
//                .withRegion(region)
//                .withCredentials(new AWSStaticCredentialsProvider(credentials))
//                .build();
//    }
//
////    @RestController
////    @RequiredArgsConstructor
////    public class S3Controller {
////        private final AmazonS3 amazonS3;
////        private final String BUCKET_NAME = "skufestival";
////
////        @GetMapping("/download")
////        public ResponseEntity<byte[]> get(@RequestParam String fileName) throws IOException {
////            S3Object s3Object = amazonS3.getObject(BUCKET_NAME, fileName);
////            S3ObjectInputStream objectInputStream = s3Object.getObjectContent();
////            byte[] bytes = IOUtils.toByteArray(objectInputStream);
////            HttpHeaders httpHeaders = new HttpHeaders();
////            httpHeaders.setContentType(MediaType.APPLICATION_OCTET_STREAM);
////            httpHeaders.setContentDispositionFormData("attachment", fileName);
////
////            return new ResponseEntity<>(bytes, httpHeaders, HttpStatus.OK);
////        }
////
////        @PostMapping("/upload")
////        public ResponseEntity<Void> upload(@RequestParam MultipartFile file) {
////            File uploadFile = convert(file);
////            uploadToS3(uploadFile);
////            return ResponseEntity.ok(null);
////        }
////
////        private File convert(MultipartFile multipartFile) {
////            File file = new File(multipartFile.getOriginalFilename());
////            try (FileOutputStream fos = new FileOutputStream(file)) {
////                fos.write(multipartFile.getBytes());
////            } catch (IOException e) {
////                throw new RuntimeException();
////            }
////            return file;
////        }
////
////        private void uploadToS3(File uploadFile) {
////            try {
////                amazonS3.putObject(BUCKET_NAME, uploadFile.getName(), uploadFile);
////            } catch (SdkClientException e) {
////                throw e;
////            } finally {
////                removeNewFile(uploadFile);
////            }
////        }
////
////        private void removeNewFile(File uploadFile) {
////            uploadFile.delete();
////        }
////    }
//}

@Configuration
public class S3Config {

    @Value("${cloud.aws.credentials.access-key}")
    private String accessKey;

    @Value("${cloud.aws.credentials.secret-key}")
    private String secretKey;

    @Value("${cloud.aws.region.static}")
    private String region;

    @Bean
    public AmazonS3Client amazonS3Client() {
        BasicAWSCredentials credentials = new BasicAWSCredentials(accessKey, secretKey);

        return (AmazonS3Client) AmazonS3ClientBuilder
                .standard()
                .withRegion(region)
                .withCredentials(new AWSStaticCredentialsProvider(credentials))
                .build();
    }
}