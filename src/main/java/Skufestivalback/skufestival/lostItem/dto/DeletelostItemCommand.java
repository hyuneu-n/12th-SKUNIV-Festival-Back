package Skufestivalback.skufestival.lostItem.dto;

import Skufestivalback.skufestival.common.util.TsidUtil;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class DeletelostItemCommand {

    private final long id;

    public DeletelostItemCommand(String id) {
        this.id = TsidUtil.toLong(id);
    }
}