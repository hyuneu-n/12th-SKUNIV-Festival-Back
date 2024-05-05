package Skufestivalback.skufestival.notice.dto;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import Skufestivalback.skufestival.notice.domain.Notice;

@Getter
@RequiredArgsConstructor
public class NoticeResponse {

    private final Long id; // 공지사항의 고유 ID 필드 추가
    private final String date; // LocalDateTime 대신 String 사용
    private final String title;
    private final String content;

    // 날짜 포맷터 정의
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");

    public NoticeResponse(Long id, LocalDateTime date, String title, String content) {
        this.id = id;
        // 서울 시간대로 변환 후 포맷 적용
        this.date = date.atZone(ZoneId.of("Asia/Seoul")).format(formatter);
        this.title = title;
        this.content = content;
    }

    // Notice 엔티티로부터 NoticeResponse 객체를 생성하는 메서드
    public static NoticeResponse build(Notice notice) {
        return new NoticeResponse(
                notice.getId(), // ID 필드 설정
                notice.getCreatedDate(),
                notice.getTitle(),
                notice.getContent()
        );
    }
}