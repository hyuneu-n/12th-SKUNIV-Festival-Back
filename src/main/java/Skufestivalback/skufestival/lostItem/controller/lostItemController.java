package Skufestivalback.skufestival.lostItem.controller;

import Skufestivalback.skufestival.lostItem.dto.FindlostItemCommand;
import Skufestivalback.skufestival.lostItem.dto.lostItemResponse;
import Skufestivalback.skufestival.lostItem.service.FindlostItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/lostitem")
public class lostItemController {

    //서비스 의존성 주입
    private final FindlostItemService findlostItemService;

    //분실물 조회 API
    @GetMapping
    public ResponseEntity<List<lostItemResponse>> find(
            @RequestParam(name = "lastId", defaultValue = "HaPpy508") String lastlostItemId,
            @RequestParam(name = "size", defaultValue = "8") Integer pageSize
    ){
        FindlostItemCommand command = new FindlostItemCommand(lastlostItemId, pageSize);
        List<lostItemResponse> lostitemResponses = findlostItemService.doService(command);
        return ResponseEntity.ok(lostitemResponses); //조회 결과 반환
    }


}
