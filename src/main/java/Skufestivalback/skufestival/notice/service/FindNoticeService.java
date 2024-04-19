package Skufestivalback.skufestival.notice.service;

import java.util.List;
import java.util.stream.Collectors;

import Skufestivalback.skufestival.notice.domain.NoticeRepository;
import Skufestivalback.skufestival.notice.dto.FindNoticeCommand;
import Skufestivalback.skufestival.notice.dto.NoticeResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FindNoticeService {

    private final NoticeRepository noticeRepository;

    public List<NoticeResponse> doService(FindNoticeCommand command) {
        return noticeRepository.find(command.getLastId(), command.getPageSize())
                .stream()
                .map(NoticeResponse::build)
                .collect(Collectors.toList());
    }
}
