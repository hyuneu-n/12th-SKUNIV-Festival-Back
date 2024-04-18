package Skufestivalback.skufestival.lostItem.Domain.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class lostItemBoard extends lostItemTimeEntity{

    @jakarta.persistence.Id
    @Id
    @GeneratedValue
    private Long id;

    @Column(length=10, nullable=true)
    private String lostItemName;

    @Column(length=100, nullable=true)
    private String lostTime;

    @Column(length=100, nullable=true)
    private String lostDate;

    @Column(length=100, nullable=true)
    private String location;

    @Column(length=150, nullable=true)
    private String filename;

    @Column(length = 300, nullable = true)
    private String filepath;

    @Builder
    public lostItemBoard(Long id, String lostItemName, String lostTime, String lostDate, String location, String filename, String filepath){
        this.id=id;
        this.lostItemName=lostItemName;
        this.lostTime=lostTime;
        this.lostDate=lostDate;
        this.location=location;
        this.filename=filename;
        this.filepath= filepath;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
