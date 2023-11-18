package CarrotServer.domain;

import jakarta.persistence.*;

@Entity
public class Clubs {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long clubId;
    @Enumerated(value = EnumType.STRING)
    private ClubCategory clubCategory;
    private String clubName;
    private String clubContent;
    private String participation_img;
    private String clubImg;
    private String clubBackgroundImg;
    private String town;
    private int participationCount;
}
