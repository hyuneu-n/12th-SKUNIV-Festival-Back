package Skufestivalback.skufestival.lostItem.domain;

import Skufestivalback.skufestival.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

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
        this.lostItemName = lostItemName;
        this.lostItemImagePath = lostItemImagePath;
        this.lostDate = lostDate;
        this.lostLocation = lostLocation;
    }
    //업데이트 메서드
    public void updateDetails(String name, String date, String location) {
        this.lostItemName = name;
        this.lostDate = date;
        this.lostLocation = location;
    }
}
