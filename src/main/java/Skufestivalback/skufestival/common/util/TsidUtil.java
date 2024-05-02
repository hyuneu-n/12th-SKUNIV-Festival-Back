package Skufestivalback.skufestival.common.util;

public class TsidUtil {

    // ID를 생성하는 메서드 - 예를 들어 데이터베이스에서 자동으로 증가하는 ID를 반환하거나
    // 어떤 방식으로든 생성된 정수형 ID를 반환할 수 있습니다.
    public static Long createLong() {
        // 여기서는 예시로 0을 반환하고 있습니다. 실제로는 적절한 ID 생성 로직을 구현해야 합니다.
        return 0L; // 이 부분을 적절한 ID 생성 로직으로 변경하세요.
    }

    // 문자열 형태의 숫자 ID를 Long으로 변환
    public static Long toLong(String id) {
        try {
            return Long.parseLong(id);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("ID 형식 오류: 입력된 ID '" + id + "'는 숫자 형식이 아닙니다.", e);
        }
    }

    // Long 타입의 ID를 문자열로 변환
    public static String toString(Long id) {
        return String.valueOf(id);
    }
}
