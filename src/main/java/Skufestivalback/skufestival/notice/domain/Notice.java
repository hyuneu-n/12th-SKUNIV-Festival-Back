package Skufestivalback.skufestival.notice.domain;

import Skufestivalback.skufestival.BaseTimeEntity;
import Skufestivalback.skufestival.common.util.TsidUtil;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Notice extends BaseTimeEntity {

    @Id
    private Long id;

    @Lob
    private String title;
    private String content;

    public Notice(String title, String content) {
        this.id = TsidUtil.createLong();
        this.title = title;
        this.content = content;
    }

    public void updateTitle(String title){
        this.title = title;
    }
    public void updateContent(String content) {
        this.content = content;
    }
}
