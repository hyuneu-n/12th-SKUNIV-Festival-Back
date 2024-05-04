package Skufestivalback.skufestival.lostItem.controller;

import Skufestivalback.skufestival.lostItem.dto.DeletelostItemCommand;
import Skufestivalback.skufestival.lostItem.dto.FindlostItemCommand;
import Skufestivalback.skufestival.lostItem.dto.UpdatelostItemCommand;
import Skufestivalback.skufestival.lostItem.dto.lostItemResponse;
import Skufestivalback.skufestival.lostItem.service.DeletelostItemService;
import Skufestivalback.skufestival.lostItem.service.FindlostItemService;
import Skufestivalback.skufestival.lostItem.service.PostlostItemService;
import Skufestivalback.skufestival.lostItem.service.UpdatelostItemService;
import org.springframework.web.multipart.MultipartFile;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/lostitem")
public class lostItemController {

    private final FindlostItemService findlostItemService;
    private final PostlostItemService postlostItemService;
    private final UpdatelostItemService updatelostItemService;
    private final DeletelostItemService deletelostItemService;

    //분실물 조회 API
    @Operation(summary = "getLostItem", description = "분실물 조회", tags = { "LostItem" })
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK",
                    content = @Content(schema = @Schema(implementation = lostItemResponse.class))),
            @ApiResponse(responseCode = "400", description = "BAD REQUEST"),
            @ApiResponse(responseCode = "404", description = "NOT FOUND"),
            @ApiResponse(responseCode = "500", description = "INTERNAL SERVER ERROR")
    })
    @GetMapping("/posts")
    public ResponseEntity<List<lostItemResponse>> find(
            @RequestParam(name = "lastId", defaultValue = "0") Long lastlostItemId,
            @RequestParam(name = "size", defaultValue = "8") Integer pageSize //한 페이지에 8개 게시글
    ){
        FindlostItemCommand command = new FindlostItemCommand(lastlostItemId, pageSize);
        List<lostItemResponse> lostitemResponses = findlostItemService.doService(command);
        return ResponseEntity.ok(lostitemResponses); //조회 결과 반환
    }

    //분실물 등록 API
    @Operation(summary = "postLostItem", description = "분실물 작성", tags = { "LostItem" })
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK",
                    content = @Content(schema = @Schema(implementation = lostItemResponse.class))),
            @ApiResponse(responseCode = "400", description = "BAD REQUEST"),
            @ApiResponse(responseCode = "404", description = "NOT FOUND"),
            @ApiResponse(responseCode = "500", description = "INTERNAL SERVER ERROR")
    })

    @PostMapping(value = "/post", consumes = "multipart/form-data")
    public ResponseEntity<Object> register(
            @RequestPart(value = "file", required = true) MultipartFile file,
            @RequestParam(value = "lostItemName") String lostItemName,
            @RequestParam(value = "lostDate") String lostDate,
            @RequestParam(value = "lostLocation") String lostLocation
    ) throws IOException {
        postlostItemService.doService(lostItemName, file, lostDate, lostLocation);
        return ResponseEntity.ok().build();
    }

    @ExceptionHandler(IOException.class)
    public ResponseEntity<String> handleIOException(IOException ex) {
        //로그 남기기, 에러 처리 로직
        return ResponseEntity.status(500).body("File processing failed: " + ex.getMessage());
    }

    // 분실물 수정 API (사진은 수정불가)
    @Operation(summary = "updateLostItem", description = "분실물 수정", tags = { "LostItem" })
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK",
                    content = @Content(schema = @Schema(implementation = lostItemResponse.class))),
            @ApiResponse(responseCode = "400", description = "BAD REQUEST"),
            @ApiResponse(responseCode = "404", description = "NOT FOUND"),
            @ApiResponse(responseCode = "500", description = "INTERNAL SERVER ERROR")
    })
    @PatchMapping("/edit/{id}")
    public ResponseEntity<Void> update(
            @PathVariable Long id,
            @RequestParam String name,
            @RequestParam String date,
            @RequestParam String location
    ) {
        UpdatelostItemCommand command = new UpdatelostItemCommand(id, name, date, location);
        updatelostItemService.doService(command);
        return ResponseEntity.ok().build(); //업데이트 성공 응답
    }

    //분실물 삭제 API
    @Operation(summary = "deleteLostItem", description = "분실물 삭제", tags = { "LostItem" })
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK",
                    content = @Content(schema = @Schema(implementation = lostItemResponse.class))),
            @ApiResponse(responseCode = "400", description = "BAD REQUEST"),
            @ApiResponse(responseCode = "404", description = "NOT FOUND"),
            @ApiResponse(responseCode = "500", description = "INTERNAL SERVER ERROR")
    })
    @DeleteMapping("/delete")
    public ResponseEntity<Void> delete(@RequestParam("id") String noticeId) {
        DeletelostItemCommand command = new DeletelostItemCommand(noticeId);
        deletelostItemService.doService(command);
        return ResponseEntity.ok().build(); //삭제 성공 응답
    }
}
