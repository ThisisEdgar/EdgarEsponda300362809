package com.example.edgaresponda300362809.Component;

import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Getter
@Setter
public class category {
    @Id
    @Column(name = "Catcode")
    private String Catcode;
    @Column(name="Catdesc")
    private String Catdesc;
}
