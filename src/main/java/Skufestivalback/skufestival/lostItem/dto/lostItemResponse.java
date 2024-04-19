package Skufestivalback.skufestival.lostItem.dto;

import java.time.LocalDateTime;

import Skufestivalback.skufestival.lostItem.domain.lostItem;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class lostItemResponse {

    private LocalDateTime createdDate;

    private final String lostItemName;
    private final String lostItemImagePath;
    private final String lostDate;
    private final String lostLocation;

    public lostItemResponse(LocalDateTime createdDate, String lostItemName, String lostItemImagePath, String lostDate, String lostLocation) {
        this.createdDate = createdDate;
        this.lostItemName = lostItemName;
        this.lostItemImagePath = lostItemImagePath;
        this.lostDate = lostDate;
        this.lostLocation = lostLocation;
    }

    // lostItem 엔티티에서 lostItemResponse 객체를 생성하는 팩토리 메소드
    public static lostItemResponse build(lostItem lostItem) {
        return new lostItemResponse(
                lostItem.getCreatedDate(),
                lostItem.getLostItemName(),
                lostItem.getLostItemImagePath(),
                lostItem.getLostDate(),
                lostItem.getLostLocation()
        );
    }
}
