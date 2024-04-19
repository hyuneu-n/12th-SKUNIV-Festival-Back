package Skufestivalback.skufestival.notice.service;

import Skufestivalback.skufestival.notice.domain.Notice;
import Skufestivalback.skufestival.notice.domain.NoticeRepository;
import Skufestivalback.skufestival.notice.dto.DeleteNoticeCommand;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class DeleteNoticeService {

    private final NoticeRepository noticeRepository;

    @Transactional
    public void doService(DeleteNoticeCommand command) {
        Notice notice = noticeRepository.findByIdOrElseThrow(command.getId());
        noticeRepository.delete(notice);
    }
}
