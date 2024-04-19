package Skufestivalback.skufestival.lostItem.domain;

import Skufestivalback.skufestival.BaseTimeEntity;
import Skufestivalback.skufestival.common.util.TsidUtil;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

//지금 여기서는 아이디와 내용만 존재. (공지는)
//분실물에서 필요한 것은 (분실물명, 분실물 사진, 분실시간, 분실날짜, 분실위치)
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class lostItem extends BaseTimeEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String lostItemName;
    private String lostItemImage; //이미지 경로
    private String lostDate;
    private String lostLocation;
    
    @Lob
    private String content; //설명이나 추가정보 적는건데 필요없을랑가

    public lostItem(String lostItemName, String lostItemImage, String lostDate, String lostLocation, String content){
        this.id = TsidUtil.createLong();
        this.lostItemName = lostItemName;
        this.lostItemImage = lostItemImage;
        this.lostDate = lostDate;
        this.lostLocation = lostLocation;
        this.content = content;
    }
}
