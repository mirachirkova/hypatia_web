package models;

import lombok.*;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "pictures_to_phenomenons")
@Getter
@Setter
@ToString
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
public class PicturesToPhenomenons implements CommonEntity<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, name = "id")
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "phenomenon_id")
    @ToString.Exclude
    @NonNull
    private Phenomenons phenomenon_id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "picture_id")
    @ToString.Exclude
    @NonNull
    private Pictures picture_id;
}