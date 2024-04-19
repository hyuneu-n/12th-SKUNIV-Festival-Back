package Skufestivalback.skufestival.lostItem.dto;

import java.time.LocalDateTime;

import Skufestivalback.skufestival.lostItem.domain.lostItem;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class lostItemResponse {

    private LocalDateTime createdDate;
    private final String content;

    private final String lostItemName;
    private final String lostItemImage;
    private final String lostDate;
    private final String lostLocation;


    // 전체 필드를 포함하는 생성자
    public lostItemResponse(LocalDateTime createdDate, String content, String lostItemName, String lostItemImage, String lostDate, String lostLocation) {
        this.createdDate = createdDate;
        this.content = content;
        this.lostItemName = lostItemName;
        this.lostItemImage = lostItemImage;
        this.lostDate = lostDate;
        this.lostLocation = lostLocation;
    }

    // lostItem 엔티티에서 lostItemResponse 객체를 생성하는 팩토리 메소드
    public static lostItemResponse build(lostItem lostItem) {
        return new lostItemResponse(
                lostItem.getCreatedDate(),
                lostItem.getContent(),
                lostItem.getLostItemName(),
                lostItem.getLostItemImage(),
                lostItem.getLostDate(),
                lostItem.getLostLocation()
        );
    }
}
