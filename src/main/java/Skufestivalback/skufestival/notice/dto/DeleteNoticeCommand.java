package Skufestivalback.skufestival.notice.dto;

import Skufestivalback.skufestival.common.util.TsidUtil;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class DeleteNoticeCommand {

    private final long id;

    public DeleteNoticeCommand(String id) {
        this.id = TsidUtil.toLong(id);
    }
}
