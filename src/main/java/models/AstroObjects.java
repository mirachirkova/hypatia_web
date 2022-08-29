package models;

import lombok.*;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "objects")
@Getter
@Setter
@ToString
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
public class AstroObjects implements CommonEntity<Long> {

    public enum EObjectClass {
        comet,
        star,
        planet,
        satellite,
        other
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, name = "id")
    private Long id;

    @Column(nullable = false, name = "name")
    @NonNull
    private String name;

    @Column(nullable = false, name = "object_class")
    private EObjectClass object_class;

    @Column(nullable = false, name = "discoverer")
    private String discoverer;

    @Column(nullable = false, name = "discovery_date")
    private java.sql.Date discovery_date;

    @Column(nullable = false, name = "info")
    private String info;

}
