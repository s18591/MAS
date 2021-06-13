package edu.pja.s18591.mp_5.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(uniqueConstraints =
    @UniqueConstraint(columnNames = {"owner_id","kingdom_Id"})
)
public class Contract {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @OneToOne
    @NotNull
    @JoinColumn(name="owner_id",nullable = false)
    private Owner owner;

    @ManyToOne
    @NotNull
    @JoinColumn(name = "kingdom_Id",nullable = false)
    private Kingdom kingdom;

    @NotNull
    private LocalDate startDate;
    @NotNull
    private float tax;
}
