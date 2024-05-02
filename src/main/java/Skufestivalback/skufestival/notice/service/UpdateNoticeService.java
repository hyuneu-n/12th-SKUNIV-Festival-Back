package Skufestivalback.skufestival.notice.service;

import Skufestivalback.skufestival.notice.domain.Notice;
import Skufestivalback.skufestival.notice.domain.NoticeRepository;
import Skufestivalback.skufestival.notice.dto.UpdateNoticeCommand;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UpdateNoticeService {

    private final NoticeRepository noticeRepository;

    @Transactional
    public void doService(UpdateNoticeCommand command) {
        Notice notice = noticeRepository.findByIdOrElseThrow(command.getId());
        notice.updateNotice(command.getTitle(), command.getContent());
    }
}