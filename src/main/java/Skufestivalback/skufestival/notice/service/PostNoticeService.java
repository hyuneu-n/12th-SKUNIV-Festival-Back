package Skufestivalback.skufestival.notice.service;

import Skufestivalback.skufestival.notice.domain.Notice;
import Skufestivalback.skufestival.notice.domain.NoticeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class PostNoticeService {

    private final NoticeRepository noticeRepository;

    @Transactional
    public void doService(String title, String content) {
        Notice notice = new Notice(title, content);
        noticeRepository.save(notice);
    }
}