package CarrotServer.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Clubs {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long clubId;
    private ClubCategory clubCategory;
    private String clubName;
    private String clubContent;
    private String participation_img;
    private String clubImg;
    private String clubBackgroundImg;
    private String town;
    private int participationCount;
}
