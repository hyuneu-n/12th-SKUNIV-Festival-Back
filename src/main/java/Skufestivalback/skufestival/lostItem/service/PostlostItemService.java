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
    public void doService(String lostItemName, String fileUrl, String lostDate, String lostLocation) {
        lostItem lostitem = new lostItem(lostItemName, fileUrl, lostDate, lostLocation);
        lostItemRepository.save(lostitem);
}
}
