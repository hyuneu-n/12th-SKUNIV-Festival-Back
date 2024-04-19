package Skufestivalback.skufestival.lostItem.dto;

import java.time.LocalDateTime;

import Skufestivalback.skufestival.lostItem.domain.lostItem;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class lostItemResponse {

    private final LocalDateTime date;
    private final String content;

    public static lostItemResponse build(lostItem lostItem) {
        return new lostItemResponse(lostItem.getCreatedDate(), lostItem.getContent());
    }
}
