package Skufestivalback.skufestival.lostItem.service;

import Skufestivalback.skufestival.lostItem.domain.lostItem;
import Skufestivalback.skufestival.lostItem.domain.lostItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
@RequiredArgsConstructor
public class PostlostItemService {

    private final lostItemRepository lostItemRepository;

    @Transactional
    public void doService(String lostItemName, MultipartFile file, String lostDate, String lostLocation) throws IOException {

        String directory = "/resources/statics/files";
        String filename = file.getOriginalFilename();
        Path filePath = Paths.get(directory, filename);
        Files.copy(file.getInputStream(), filePath);

        lostItem lostitem = new lostItem(lostItemName, filePath.toString(), lostDate, lostLocation);
        lostItemRepository.save(lostitem);
    }

    public void saveFile(InputStream fileStream, String filename, String directory) {
        try {
            Path filePath = Paths.get(directory, filename);
            Files.copy(fileStream, filePath);
        } catch (IOException e) {
            System.out.println("ERROR: " + e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("General ERROR: " + e.getMessage());
            e.printStackTrace();  // 상세한 오류 추적 정보를 콘솔에 출력
        }
    }
}