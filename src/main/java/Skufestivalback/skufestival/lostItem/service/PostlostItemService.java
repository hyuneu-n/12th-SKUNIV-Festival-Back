package Skufestivalback.skufestival.lostItem.service;

import Skufestivalback.skufestival.lostItem.domain.lostItem;
import Skufestivalback.skufestival.lostItem.domain.lostItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class PostlostItemService {

    private final lostItemRepository lostItemRepository;

    @Transactional
    public void doService(String lostItemName, String lostItemImagePath, String lostDate, String lostLocation) {
        // 새로운 분실물 객체 생성
        lostItem lostitem = new lostItem(lostItemName, lostItemImagePath, lostDate, lostLocation);
        // 생성된 객체를 데이터베이스에 저장
        lostItemRepository.save(lostitem);
    }
}