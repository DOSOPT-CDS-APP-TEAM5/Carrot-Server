package CarrotServer.domain;

import CarrotServer.common.enums.ClubCategory;
import jakarta.persistence.*;
import lombok.Getter;

import java.util.List;

@Entity
@Getter
public class Clubs {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long clubId;
    @Enumerated(value = EnumType.STRING)
    private ClubCategory clubCategory;
    private String clubName;
    private String clubContent;
    private String participantsImg;
    private String clubImg;
    private String clubBackgroundImg;
    private String town;
    private int participantCount;
    @OneToMany
    private List<Albums> albums;
}
