package Skufestivalback.skufestival.notice;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class NoticeController {

    private final NoticeService service;

    public NoticeController(NoticeService service) {
        this.service = service;
    }

    //read(findNotice)만들기

    //create만들기
}
