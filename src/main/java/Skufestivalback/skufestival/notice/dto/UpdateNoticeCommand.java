package Skufestivalback.skufestival.notice.dto;

import Skufestivalback.skufestival.common.util.TsidUtil;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class UpdateNoticeCommand {

    private final long id;
    private final String content;

    public UpdateNoticeCommand(String id, String content) {
        this.id = TsidUtil.toLong(id);
        this.content = content;
    }
}