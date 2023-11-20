package CarrotServer.domain;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
public class Albums {
    @Id @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long albumId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "club_id")
    private Clubs club;
    private String albumImg;
}
