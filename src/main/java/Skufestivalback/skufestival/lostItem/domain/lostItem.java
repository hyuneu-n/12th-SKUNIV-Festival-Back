package Skufestivalback.skufestival.lostItem.domain;

import Skufestivalback.skufestival.BaseTimeEntity;
import Skufestivalback.skufestival.common.util.TsidUtil;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class lostItem extends BaseTimeEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String lostItemName;
    private String lostItemImagePath; //이미지 경로
    private String lostDate;
    private String lostLocation;

    public lostItem(String lostItemName, String lostItemImagePath, String lostDate, String lostLocation){
        this.id = TsidUtil.createLong();
        this.lostItemName = lostItemName;
        this.lostItemImagePath = lostItemImagePath;
        this.lostDate = lostDate;
        this.lostLocation = lostLocation;
    }
}
