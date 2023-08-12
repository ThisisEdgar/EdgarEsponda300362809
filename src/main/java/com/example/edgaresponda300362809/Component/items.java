package com.example.edgaresponda300362809.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "items")
public class items {
    @Id
    @Column(name = "Catcode")
    private String Catcode;
    @Column(name="Icode")
    private String Icode;
    @Column(name = "Idesc")
    private String Idesc;
    @Column(name = "Price")
    private float Price;
}
