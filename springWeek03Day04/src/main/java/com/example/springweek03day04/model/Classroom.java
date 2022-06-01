package com.example.springweek03day04.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Set;

@AllArgsConstructor @NoArgsConstructor @Getter @Setter
@Entity
public class Classroom {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(unique = true)
    @Size(min = 3,max = 15,message = "Name min 3 and max 15")
    @NotEmpty(message = "Name is required")
    private String name;

    @ManyToMany(cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Student> students;

    @ManyToOne
    @JsonIgnore
    private Teacher teacher;

    public Classroom(String name, Teacher teacher) {
        this.name = name;
        this.teacher = teacher;
    }
}
