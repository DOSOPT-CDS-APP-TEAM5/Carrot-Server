package CarrotServer.domain;

import jakarta.persistence.*;

@Entity
public class Profiles {
    @Id @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long profileId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="clubId")
    private Clubs club;
    private String nickname;
    private String information;
}
