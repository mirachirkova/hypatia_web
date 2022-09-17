package com.example.demo.models;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "objects")
@Getter
@Setter
@ToString
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
public class AstroObjects implements CommonEntity<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, name = "id")
    private Long id;

    @Column(nullable = false, name = "name")
    @NonNull
    private String name;

    @Column(nullable = false, name = "object_class")
    private String object_class;

    @Column(nullable = false, name = "discoverer")
    private String discoverer;

    @Column(nullable = false, name = "discovery_date")
    private String discovery_date;

    @Column(nullable = false, name = "info")
    private String info;

}
