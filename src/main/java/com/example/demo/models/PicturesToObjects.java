package com.example.demo.models;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "pictures_to_objects")
@Getter
@Setter
@ToString
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
public class PicturesToObjects implements CommonEntity<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, name = "id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "object_id")
    @ToString.Exclude
    @NonNull
    private AstroObjects object_id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "picture_id")
    @ToString.Exclude
    @NonNull
    private Pictures picture_id;
}