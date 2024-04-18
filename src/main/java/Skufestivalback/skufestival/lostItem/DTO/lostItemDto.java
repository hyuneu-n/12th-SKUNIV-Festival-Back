package Skufestivalback.skufestival.lostItem.DTO;

import Skufestivalback.skufestival.lostItem.Domain.Entity.lostItemBoard;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class lostItemDto {
    private Long id;
    private String lostItemName;
    private String lostTime;
    private String lostDate;
    private String location;
    private String filename;
    private String filepath;
    private String fileName; // 파일 이름을 저장할 필드
    private String filePath; // 파일 경로를 저장할 필드
    //private LocalDateTime createdDate;
    //private LocalDateTime modifiedDate;

    public lostItemBoard toEntity(){
        lostItemBoard build = lostItemBoard.builder()
                .id(id)
                .lostItemName(lostItemName)
                .lostTime(lostTime)
                .lostDate(lostDate)
                .location(location)
                .filename(filename)
                .filepath(filepath)
                .build();
        return build;
    }

    @Builder
    public lostItemDto(Long id, String lostItemName, String lostTime, String lostDate, String location, String filename, String filepath){
        this.id=id;
        this.lostItemName=lostItemName;
        this.lostTime=lostTime;
        this.lostDate=lostDate;
        this.location=location;
        this.filename=filename;
        this.filepath= filepath;
    }
}
