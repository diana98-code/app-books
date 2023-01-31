package com.distribuida.db;

import io.quarkus.arc.impl.Identified;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
@Entity
@Getter
@Setter
@AllArgsConstructor@NoArgsConstructor

public class Book implements Serializable {
    public static final long serializableVersionUID = 1L;

    @Id
    //Campos de la tabla book
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "isbn")
    private String isbn;

    @Column(name = "title")
    private String title;
    @Column(name = "price")
    private double price;

}
