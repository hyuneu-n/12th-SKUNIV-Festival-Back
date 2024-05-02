package Skufestivalback.skufestival.notice.dto;

import Skufestivalback.skufestival.common.util.TsidUtil;
import lombok.Getter;

@Getter
public class UpdateNoticeCommand {
    private final long id;
    private final String title;
    private final String content;

    public UpdateNoticeCommand(String id, String title, String content) {
        // 오류 처리를 추가하여 안정적으로 ID를 변환
        this.id = safelyParseId(id);
        this.title = title;
        this.content = content;
    }

    private static long safelyParseId(String id) {
        try {
            return TsidUtil.toLong(id);
        } catch (IllegalArgumentException e) {
            // 로그 찍기, 예외 처리, 기본값 설정 등의 조치 가능
            throw new IllegalArgumentException("Invalid ID format: " + id, e);
        }
    }
}
