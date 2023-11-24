package CarrotServer.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Table(name = "profiles")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Profile {
    @Id @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long profileId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="clubId")
    private Club club;
    private String nickname;
    private String information;

    @Builder
    public Profile(Club club, String nickname, String information) {
        this.club = club;
        this.nickname = nickname;
        this.information = information;
    }
}
