package Skufestivalback.skufestival.lostItem.service;

import Skufestivalback.skufestival.lostItem.domain.lostItem;
import Skufestivalback.skufestival.lostItem.domain.lostItemRepository;
import Skufestivalback.skufestival.lostItem.dto.DeletelostItemCommand;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class DeletelostItemService {

    private final lostItemRepository lostitemRepository;

    @Transactional
    public void doService(DeletelostItemCommand command) {
        lostItem lostitem = lostitemRepository.findByIdOrElseThrow(command.getId());
        lostitemRepository.delete(lostitem);
    }
}
