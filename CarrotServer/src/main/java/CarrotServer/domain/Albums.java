package CarrotServer.domain;

import jakarta.persistence.*;

@Entity
public class Albums {
    @Id @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long albumId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "clubId")
    private Clubs club;
    private String albumImg;
}
