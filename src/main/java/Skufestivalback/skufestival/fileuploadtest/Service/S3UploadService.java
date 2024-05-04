package Skufestivalback.skufestival.fileuploadtest.Service;

import Skufestivalback.skufestival.fileuploadtest.component.StoreFilenameGenerator;
import Skufestivalback.skufestival.fileuploadtest.vo.UploadFile;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.ObjectMetadata;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class S3UploadService {

    private final AmazonS3 amazonS3;
    private final StoreFilenameGenerator storeFilenameGen;

    @Value("${cloud.aws.s3.bucket}")
    private String bucketName;

    public String saveFile(MultipartFile multipartFile) throws IOException {
        String originalFilename = multipartFile.getOriginalFilename();

        ObjectMetadata metadata = new ObjectMetadata();
        metadata.setContentLength(multipartFile.getSize());
        metadata.setContentType(multipartFile.getContentType());

        UploadFile uploadFile = storeFilenameGen.generate(multipartFile);
        String storeFilename = uploadFile.getStoreFilename();

        amazonS3.putObject(bucketName, storeFilename, multipartFile.getInputStream(), metadata);
        return amazonS3.getUrl(bucketName, storeFilename).toString();
    }
}