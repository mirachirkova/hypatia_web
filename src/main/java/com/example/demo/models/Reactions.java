package com.example.demo.models;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "reactions")
@Getter
@Setter
@ToString
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
public class Reactions implements CommonEntity<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, name = "id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    @ToString.Exclude
    @NonNull
    private Users user_id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "picture_id")
    @ToString.Exclude
    @NonNull
    private Pictures picture_id;

    @Column(nullable = false, name = "reaction")
    private String reaction;

}