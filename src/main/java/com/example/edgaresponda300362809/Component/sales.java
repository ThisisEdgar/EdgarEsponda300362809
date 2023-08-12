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
    private Long id;
    private int recno;
    private String icode;
    private double qty;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dot;

}
