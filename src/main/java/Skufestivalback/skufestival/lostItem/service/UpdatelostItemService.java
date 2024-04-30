package Skufestivalback.skufestival.lostItem.service;

import Skufestivalback.skufestival.lostItem.domain.lostItem;
import Skufestivalback.skufestival.lostItem.domain.lostItemRepository;
import Skufestivalback.skufestival.lostItem.dto.UpdatelostItemCommand;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UpdatelostItemService {

    private final lostItemRepository lostItemRepository;

    @Transactional
    public void doService(UpdatelostItemCommand command) {
        lostItem lostitem = lostItemRepository.findById(command.getId())
                .orElseThrow(() -> new IllegalArgumentException("No lost item found with id: " + command.getId()));
        lostitem.updateDetails(command.getLostItemName(), command.getLostDate(), command.getLostLocation());
    }
}
