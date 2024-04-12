package Skufestivalback.skufestival.notice;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class NoticeService {
    private final NoticeRepository repository;
    // 현재 시간 가져오기
    LocalDateTime currentTime = LocalDateTime.now();

    public NoticeService(NoticeRepository repository) {
        this.repository = repository;
    }

    //공지 게시글 생성
    public Notice create(String title, String content){
        Notice notice = new Notice();

        notice.setTitle(title);
        notice.setContent(content);
        notice.setTime(String.valueOf(currentTime));
        this.repository.save(notice);
        return notice;
    }

    //id값으로 공지 게시글 조회
    public Notice getNotice(Integer id){
        Optional<Notice> notice = this.repository.findById(id);
        if(notice.isPresent()){
            return notice.get();
        } else {
            throw new DataNotFoundException("notice not found");
        }
    }
}
