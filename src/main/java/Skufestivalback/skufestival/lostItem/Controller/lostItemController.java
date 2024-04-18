package Skufestivalback.skufestival.lostItem.Controller;
import org.springframework.web.bind.annotation.RequestParam;

import Skufestivalback.skufestival.lostItem.DTO.lostItemDto;
import Skufestivalback.skufestival.lostItem.Service.lostItemBoardService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class lostItemController {

    private lostItemBoardService lostitemboardService;

    public lostItemController(lostItemBoardService lostitemboardService){
        this.lostitemboardService = lostitemboardService;
    }

    @GetMapping("/")
    public String list(){
        return "lostItem/list";
    }

    @GetMapping("/lostItem/post")
    public String write(){
        return "lostItem/write";
    }

    /*
    @PostMapping("/lostItem/post")
    public String write(lostItemDto lostitemDto, MultipartFile file){
        lostitemboardService.savePost(lostitemDto, file);
        return "redirect:/";
    }
    */

    @PostMapping("/lostItem/post")
    public String write(lostItemDto lostitemDto, @RequestParam("file") MultipartFile file) {
        lostitemboardService.savePost(lostitemDto, file);
        return "redirect:/";
    }

}
