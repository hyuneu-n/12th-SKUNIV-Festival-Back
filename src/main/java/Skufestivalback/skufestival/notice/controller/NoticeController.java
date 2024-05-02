package Skufestivalback.skufestival.notice.controller;

import Skufestivalback.skufestival.notice.dto.*;
import Skufestivalback.skufestival.notice.service.DeleteNoticeService;
import Skufestivalback.skufestival.notice.service.FindNoticeService;
import Skufestivalback.skufestival.notice.service.PostNoticeService;
import Skufestivalback.skufestival.notice.service.UpdateNoticeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/notice")
public class NoticeController {

    private final FindNoticeService findNoticeService;
    private final PostNoticeService postNoticeService;
    private final UpdateNoticeService updateNoticeService;
    private final DeleteNoticeService deleteNoticeService;

    //공지사항 조회 API
    @Operation(summary = "getNotice", description = "공지사항 조회", tags = { "Notice" })
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK",
                    content = @Content(schema = @Schema(implementation = NoticeResponse.class))),
            @ApiResponse(responseCode = "400", description = "BAD REQUEST"),
            @ApiResponse(responseCode = "404", description = "NOT FOUND"),
            @ApiResponse(responseCode = "500", description = "INTERNAL SERVER ERROR")
    })

    @GetMapping("/posts")
    public ResponseEntity<List<NoticeResponse>> find(
            @RequestParam(name = "lastId", defaultValue = "0") String lastNoticeId,
            @RequestParam(name = "size", defaultValue = "8") Integer pageSize
    ) {
        FindNoticeCommand command = new FindNoticeCommand(lastNoticeId, pageSize);
        List<NoticeResponse> noticeResponses = findNoticeService.doService(command);
        return ResponseEntity.ok(noticeResponses); //조회 결과 반환
    }

    //공지사항 등록 API
    @Operation(summary = "postNotice", description = "공지사항 등록", tags = { "Notice" })
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK",
                    content = @Content(schema = @Schema(implementation = NoticeResponse.class))),
            @ApiResponse(responseCode = "400", description = "BAD REQUEST"),
            @ApiResponse(responseCode = "404", description = "NOT FOUND"),
            @ApiResponse(responseCode = "500", description = "INTERNAL SERVER ERROR")
    })

    @PostMapping("/post")
    public ResponseEntity<Void> register(@RequestBody NoticeRequest noticeRequest) {
        postNoticeService.doService(noticeRequest.getTitle(), noticeRequest.getContent());
        return ResponseEntity.ok().build();
    }

    //공지사항 수정 API
    @Operation(summary = "updateNotice", description = "공지사항 수정", tags = { "Notice" })
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK",
                    content = @Content(schema = @Schema(implementation = NoticeResponse.class))),
            @ApiResponse(responseCode = "400", description = "BAD REQUEST"),
            @ApiResponse(responseCode = "404", description = "NOT FOUND"),
            @ApiResponse(responseCode = "500", description = "INTERNAL SERVER ERROR")
    })

    @PutMapping("/edit")
    public ResponseEntity<Void> update(@RequestParam("id") String noticeId, @RequestBody NoticeUpdateRequest updateRequest) {
        UpdateNoticeCommand command = new UpdateNoticeCommand(noticeId, updateRequest.getTitle(), updateRequest.getContent());
        updateNoticeService.doService(command);
        return ResponseEntity.ok().build();
    }

    //공지사항 삭제 API
    @Operation(summary = "deleteNotice", description = "공지사항 삭제", tags = { "Notice" })
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK",
                    content = @Content(schema = @Schema(implementation = NoticeResponse.class))),
            @ApiResponse(responseCode = "400", description = "BAD REQUEST"),
            @ApiResponse(responseCode = "404", description = "NOT FOUND"),
            @ApiResponse(responseCode = "500", description = "INTERNAL SERVER ERROR")
    })

    @DeleteMapping("/delete")
    public ResponseEntity<Void> delete(@RequestParam("id") String noticeId) {
        DeleteNoticeCommand command = new DeleteNoticeCommand(noticeId);
        deleteNoticeService.doService(command);
        return ResponseEntity.ok().build(); //삭제 성공 응답
    }
    
}
