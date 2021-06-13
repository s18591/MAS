package edu.pja.s18591.mp_5.model;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
@SuperBuilder
public abstract class Settlement {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotBlank
    @Size(max = 255)
    private String name;
    protected static int tax = 10;

    @ManyToOne
    @JoinColumn(name = "kingdom_Id")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Kingdom kingdom;

    @OneToMany(mappedBy = "settlement", fetch = FetchType.LAZY)
    @Builder.Default
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<Building> buildings = new HashSet<>();

    public abstract int calculateTax();
}
