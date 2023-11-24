package CarrotServer.exception;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum Success {

    // 200 OK
    GET_HEALTH_CHECK_SUCCESS(HttpStatus.OK, "서버 상태 체크에 성공했습니다"),
    GET_CLUB_SUCCESS(HttpStatus.OK, "우리동네 모임 상세 조회 성공"),
    GET_TOWN_LIVES_SUCCESS(HttpStatus.OK, "동네 생활 리스트 조회 성공"),
    GET_FILTERED_TOWN_LIVES_SUCCESS(HttpStatus.OK, "카테고리 별 동네 생활 리스트 조회 성공"),
    GET_TOWN_CLUBS_SUCCESS(HttpStatus.OK, "동네 모임 리스트 조회 성공"),
    GET_FILTERED_TOWN_CLUBS_SUCCESS(HttpStatus.OK, "카테고리 별 동네 모임 리스트 조회 성공"),

    // 201 craeted
    CREATE_PROFILE_SUCCESS(HttpStatus.CREATED, "모임 프로필 생성 성공");


    private final HttpStatus httpStatus;
    private final String message;

    public int getHttpStatus(){
        return httpStatus.value();
    }

    public String getMessage(){
        return message;
    }
}
