package Skufestivalback.skufestival.lostItem.service;

import Skufestivalback.skufestival.lostItem.domain.lostItemRepository;
import Skufestivalback.skufestival.lostItem.dto.lostItemResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FindlostItemService {

    private final lostItemRepository lostItemRepository;

    public List<lostItemResponse> doService(){
        return lostItemRepository.findAll()
                .stream()
                .map(lostItemResponse::build)
                .collect(Collectors.toList());
    }
}
