package Skufestivalback.skufestival.lostItem.service;

import Skufestivalback.skufestival.lostItem.domain.lostItemRepository;
import Skufestivalback.skufestival.lostItem.dto.FindlostItemCommand;
import Skufestivalback.skufestival.lostItem.dto.lostItemResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FindlostItemService {

    private final lostItemRepository lostitemRepository;

    public List<lostItemResponse> doService(FindlostItemCommand command){
        return lostitemRepository.find(command.getLastId(), command.getPageSize())
                .stream()
                .map(lostItemResponse::build)
                .collect(Collectors.toList());
    }
}
