package Skufestivalback.skufestival.lostItem.service;

import Skufestivalback.skufestival.lostItem.domain.lostItem;
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

    // 모든 분실물 조회
    public List<lostItemResponse> findAll() {
        return lostItemRepository.findAll()
                .stream()
                .map(lostItemResponse::build)
                .collect(Collectors.toList());
    }

    // 분실 여부에 따라 조회
    public List<lostItemResponse> findByLost(boolean lost) {
        return lostItemRepository.findByLost(lost)
                .stream()
                .map(lostItemResponse::build)
                .collect(Collectors.toList());
    }
}