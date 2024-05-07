package Skufestivalback.skufestival.lostItem.controller;

import Skufestivalback.skufestival.S3.S3Uploader;
import Skufestivalback.skufestival.lostItem.dto.DeletelostItemCommand;
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
@CrossOrigin(origins = "https://2024skufestival.site")
@RequiredArgsConstructor
@RequestMapping("/api/lostitem")
public class lostItemController {

    private final FindlostItemService findlostItemService;
    private final PostlostItemService postlostItemService;
    private final UpdatelostItemService updatelostItemService;
    private final DeletelostItemService deletelostItemService;
    private final S3Uploader s3Uploader;

    // 분실물 조회 API
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
            @RequestParam(value = "lost", required = false) Boolean lost
    ) {
        List<lostItemResponse> lostItemResponses;
        if (lost != null) {
            lostItemResponses = findlostItemService.findByLost(lost);
        } else {
            lostItemResponses = findlostItemService.findAll();
        }
        return ResponseEntity.ok(lostItemResponses);
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
            @RequestParam(value = "lostLocation") String lostLocation,
            @RequestParam(value = "lost", required = false) Boolean lost
    ) throws IOException {
        String dirName = "lostItems";
        String fileUrl = s3Uploader.upload(file, dirName);  // 파일 업로드 후 URL 반환
        // lost 값이 null인 경우 기본값으로 false 설정
        boolean isLost = lost != null ? lost : false;
        postlostItemService.doService(lostItemName, fileUrl, lostDate, lostLocation, lost);  // doService
        return ResponseEntity.ok().build();
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
