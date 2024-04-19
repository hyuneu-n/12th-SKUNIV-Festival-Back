package Skufestivalback.skufestival.lostItem.domain;

import Skufestivalback.skufestival.BaseTimeEntity;
import Skufestivalback.skufestival.common.util.TsidUtil;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

//지금 여기서는 아이디와 내용만 존재. (공지는)
//분실물에서 필요한 것은 (분실물명, 분실물 사진, 분실시간, 분실날짜, 분실위치)
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class lostItem extends BaseTimeEntity {
    
    @Id
    private Long id;
    
    @Lob
    private String content;

    public lostItem(String content){
        this.id = TsidUtil.createLong();
        this.content = content;
    }

    //내용만 업데이트하면 되니까 내용에 대한 업데이트 코드만 있음
    //수정 필요
    public void updateContent(String content) {
        this.content = content;
    }
}
