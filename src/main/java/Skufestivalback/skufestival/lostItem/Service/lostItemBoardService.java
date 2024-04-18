package Skufestivalback.skufestival.lostItem.Service;

import Skufestivalback.skufestival.lostItem.DTO.lostItemDto;
import Skufestivalback.skufestival.lostItem.Domain.Entity.lostItemBoard;
import Skufestivalback.skufestival.lostItem.Domain.Repository.lostItemBoardRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Service
public class lostItemBoardService {

    @Autowired
    private lostItemBoardRepository lostitemBoardRepository;

    public lostItemBoardService(lostItemBoardRepository lostitemBoardRepository){
        this.lostitemBoardRepository = lostitemBoardRepository;
    }

    //save?
    /*
    @Transactional
    public Long savePost(lostItemDto lostitemDto){
        return lostitemBoardRepository.save(lostitemDto.toEntity()).getId();
    }
     */
    public Long savePost(lostItemDto lostitemDto, MultipartFile file) {
        if (file != null && !file.isEmpty()) {
            // 파일 저장 로직
            String fileName = file.getOriginalFilename();
            String fileExtension = fileName.substring(fileName.lastIndexOf("."));
            String savedFileName = UUID.randomUUID().toString() + fileExtension;
            String fileSaveDirectory = "C:/Users/hyune/OneDrive/바탕 화면/2024-SKU-Festival/12th-SKUNIV-Festival-Back/src/main/resources/statics/files/";

            try {
                // 파일 시스템에 파일 저장 (실제 경로는 환경에 따라 다를 수 있음)
                File saveFile = new File(fileSaveDirectory + savedFileName);
                file.transferTo(saveFile);

                // DTO에 파일 정보 설정
                lostitemDto.setFilename(savedFileName);
                lostitemDto.setFilepath("/" + fileSaveDirectory + savedFileName);
            } catch (IOException e) {
                throw new RuntimeException("File upload failed", e);
            }
        }

        return lostitemBoardRepository.save(lostitemDto.toEntity()).getId();
    }

}
