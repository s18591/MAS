package edu.pja.s18591.mp_5.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Building {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotBlank(message = "Name is mandatory")
    @Size(max = 255)
    private String name;


    @ManyToOne
    @JoinColumn(name = "building_id")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Settlement settlement;

    @OneToMany(mappedBy = "building",cascade = {CascadeType.REMOVE})
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @Builder.Default
    private Set<PartsOfBuilding> partsOfBuildings = new HashSet<>();
}
