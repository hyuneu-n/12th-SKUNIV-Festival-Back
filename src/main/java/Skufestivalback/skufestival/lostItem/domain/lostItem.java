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

    @Column(name = "lost_item_name")
    private String lostItemName;

    @Column(name = "lost_item_image_path")
    private String lostItemImagePath; // 이미지 경로

    @Column(name = "lost_date")
    private String lostDate;

    @Column(name = "lost_location")
    private String lostLocation;

    @Column(name = "lost")
    private Boolean lost=false;;

    // 파일 저장 경로 수정
    private static final String FILE_UPLOAD_PATH = "C:\\Users\\hyune\\Desktop\\12th-SKUNIV-Festival-Back\\src\\main\\resources\\static";

    public lostItem(String lostItemName, String lostItemImagePath, String lostDate, String lostLocation, Boolean lost) {
        this.lostItemName = lostItemName;
        this.lostItemImagePath = lostItemImagePath;
        this.lostDate = lostDate;
        this.lostLocation = lostLocation;
        this.lost = lost;
    }
    //업데이트 메서드
    public void updateDetails(String name, String date, String location) {
        this.lostItemName = name;
        this.lostDate = date;
        this.lostLocation = location;
    }

    // 파일 저장 경로 반환 메서드
    public static String getFileUploadPath() {
        return FILE_UPLOAD_PATH;
    }
}
