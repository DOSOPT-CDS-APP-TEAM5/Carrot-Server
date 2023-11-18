package CarrotServer.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;

import java.time.LocalDateTime;

@Entity
@Getter
public class Lives {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long lifeId;
    private LifeCategory lifeCategory;
    private String lifeTitle;
    private String lifeContent;
    private String town;
    private LocalDateTime createdAt;
    private int viewCount;
    private int likeCount;
    private int commentCount;
}
