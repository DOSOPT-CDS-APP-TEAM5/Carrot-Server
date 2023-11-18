package CarrotServer.domain;

import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDateTime;

@Entity
@Getter
public class Lives {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long lifeId;
    @Enumerated(value = EnumType.STRING)
    private LifeCategory lifeCategory;
    private String lifeTitle;
    private String lifeContent;
    private String town;
    private LocalDateTime createdAt;
    private int viewCount;
    private int likeCount;
    private int commentCount;
}
