package models;

import lombok.*;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "phenomenons")
@Getter
@Setter
@ToString
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
public class Phenomenons implements CommonEntity<Long> {

    public enum EPhenomenonClass {
        flare,
        eclipse,
        parade
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, name = "id")
    private Long id;

    @Column(nullable = false, name = "name")
    @NonNull
    private String name;

    @Column(nullable = false, name = "phenomenon_class")
    private EPhenomenonClass phenomenon_class;

    @Column(nullable = false, name = "start_time")
    private Byte[] start_time;

    @Column(name = "finish_time")
    private Byte[] finish_time;
}
