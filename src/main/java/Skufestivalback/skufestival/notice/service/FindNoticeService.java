//package Skufestivalback.skufestival.notice.service;
//
//import java.util.List;
//import java.util.stream.Collectors;
//
//import Skufestivalback.skufestival.notice.domain.NoticeRepository;
//import Skufestivalback.skufestival.notice.dto.FindNoticeCommand;
//import Skufestivalback.skufestival.notice.dto.NoticeResponse;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Service;
//
//@Service
//@RequiredArgsConstructor
//public class FindNoticeService {
//
//    private final NoticeRepository noticeRepository;
//
//    public List<NoticeResponse> doService(FindNoticeCommand command) {
//        return noticeRepository.find(command.getLastId(), command.getPageSize())
//                .stream()
//                .map(NoticeResponse::build)
//                .collect(Collectors.toList());
//    }
//}

package Skufestivalback.skufestival.notice.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import Skufestivalback.skufestival.common.exception.CustomException;
import Skufestivalback.skufestival.notice.domain.Notice;
import Skufestivalback.skufestival.notice.domain.NoticeRepository;
import Skufestivalback.skufestival.notice.dto.NoticeResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class FindNoticeService {

    private final NoticeRepository noticeRepository;

    public List<NoticeResponse> doService() {
        return noticeRepository.findAllNotices()
                .stream()
                .map(NoticeResponse::build)
                .collect(Collectors.toList());
    }
    public NoticeResponse findById(String noticeId) {
        Optional<Notice> noticeOptional = noticeRepository.findById(Long.valueOf(noticeId));
        if (noticeOptional.isPresent()) {
            Notice notice = noticeOptional.get();
            return NoticeResponse.build(notice);
        } else {
            // 존재하지 않는 ID의 요청에 대해 적절한 예외 처리를 해야 합니다.
            // 예를 들어, CustomNotFoundException을 던질 수 있습니다.
            throw new CustomException(HttpStatus.NOT_FOUND, "Notice with id " + noticeId + " not found");
        }
    }

}