package com.distribuida.db;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.bytebuddy.agent.builder.AgentBuilder;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Author implements Serializable {
    public static final long serialVersionUID = 1L;
    @Id
    //Campos tabla Author
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    //Relación entre Book y Author
    @OneToMany(orphanRemoval = true)
    @JoinColumn(name = "author_id", nullable = false)
    private List<Book> books;

}
