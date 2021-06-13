package edu.pja.s18591.mp_5.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;
import javax.validation.constraints.Min;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class Town extends Settlement {

    @Min(0)
    private int crafts;

    @Override
    public int calculateTax() {
        return tax + crafts;
    }
}
