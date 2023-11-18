package CarrotServer.domain;

import jakarta.persistence.*;

@Entity
public class Profiles {
    @Id @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long profileId;
    @ManyToOne
    @JoinColumn(name="clubId")
    private Clubs club;
    private String nickname;
    private String information;
}
