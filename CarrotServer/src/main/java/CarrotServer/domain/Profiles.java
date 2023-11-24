package CarrotServer.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Profiles {
    @Id @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long profileId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="clubId")
    private Clubs club;
    private String nickname;
    private String information;

    @Builder
    public Profiles(Clubs club, String nickname, String information) {
        this.club = club;
        this.nickname = nickname;
        this.information = information;
    }
}
