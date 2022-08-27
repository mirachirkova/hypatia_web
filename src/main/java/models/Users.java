package models;

import lombok.*;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "users")
@Getter
@Setter
@ToString
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
public class Users implements CommonEntity<Long> {

    public enum EGender {
        female,
        male,
        unspecified,
        other
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, name = "id")
    private Long id;

    @Column(nullable = false, name = "nickname")
    @NonNull
    private String nickname;

    @Column(nullable = false, name = "first_name")
    @NonNull
    private String first_name;

    @Column(nullable = false, name = "last_name")
    private String last_name;

    @Column(nullable = false, name = "gender")
    @NonNull
    private EGender gender;

    @Column(name = "password_hash")
    @NonNull
    private Integer password_hash;
}