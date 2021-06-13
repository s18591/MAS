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
public class Kingdom {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotBlank(message = "Name is mandatory")
    @Size(max = 255)
    private String name;
    @NotBlank(message = "King name is mandatory")
    @Size(max = 255)
    private String kingName;

    @OneToMany(mappedBy = "kingdom", fetch = FetchType.LAZY)
    @Builder.Default
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<Settlement> settlements = new HashSet<>();

    @OneToMany(mappedBy = "kingdom",cascade = {CascadeType.REMOVE}, fetch = FetchType.LAZY)
    @Builder.Default
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<Contract> contracts  = new HashSet<>();

}
