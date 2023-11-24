package CarrotServer.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum LifeCategory {
    DICTIONARY("동네백과"),
    QUESTION("동네질문"),
    ACCIDENT("동네 사건사고"),
    INFORMATION("생활정보"),
    HOBBY("취미생활");

    private final String name;

    public static LifeCategory findByName(String name){
        for(LifeCategory lifeCategory : LifeCategory.values()){
            if(lifeCategory.getName().equals(name)){
                return lifeCategory;
            }
        }
        return null;
    }
}
