package edu.pja.s18591.mp_5.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PartsOfBuilding {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @NotBlank(message = "Name is mandatory")
    @Size(max = 255)
    private String name;

    @ManyToOne(optional = false)
    @JoinColumn(name = "building_id",nullable = false, updatable = false)
    private Building building;



}
