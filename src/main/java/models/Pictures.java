package models;

import lombok.*;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "pictures")
@Getter
@Setter
@ToString
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
public class Pictures implements CommonEntity<Long> {

    public enum ETelescope {
        SKYLINE,
        SVD1300,
        GHM03
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, name = "id")
    private Long id;

    @Column(nullable = false, name = "link")
    @NonNull
    private String link;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "author_id")
    @ToString.Exclude
    @NonNull
    private Users author_id;

    @Column(nullable = false, name = "telescope")
    private ETelescope telescope;
}