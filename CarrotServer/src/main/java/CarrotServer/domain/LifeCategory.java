package CarrotServer.domain;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum LifeCategory {
    DICTIONARY("동네백과"),
    QUESTION("동네질문"),
    ACCIDENT("동네사건사고"),
    INFORMATION("생활정보"),
    HOBBY("취미생활");

    private final String name;
}
