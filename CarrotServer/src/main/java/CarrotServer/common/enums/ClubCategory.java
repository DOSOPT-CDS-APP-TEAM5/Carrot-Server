package CarrotServer.common.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum ClubCategory {
    WORKOUT("운동"),
    FRIEND("동네친구"),
    STUDY("스터디"),
    HOUSE("가족/육아"),
    PET("반려동물");

    private final String name;
}
