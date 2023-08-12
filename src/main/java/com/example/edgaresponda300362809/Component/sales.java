package com.example.edgaresponda300362809.Component;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigInteger;
import java.util.Date;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "sales")
public class sales {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "recno")
    private int recno;
    @Column(name = "icode")
    private String icode;
    @Column(name= "qty")
    private double qty;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "dot")
    private Date dot;

}
