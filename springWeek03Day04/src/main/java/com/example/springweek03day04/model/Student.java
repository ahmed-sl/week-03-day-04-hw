package com.example.springweek03day04.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Set;

@AllArgsConstructor @NoArgsConstructor @Getter @Setter
@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(unique = true)
    @Size(min = 3,max = 15,message = "Name min 3 and max 15")
    @NotEmpty(message = "Name is required")
    private String name;
    @NotNull(message = "Age is required")
    @Positive
    private Integer age;
    @NotEmpty(message = "major name is required")
    @Pattern(regexp = "(?i)(IS|CS|IT)", message = "major must in (IS|CS|IT)")
    private String major;

    @ManyToMany(mappedBy = "students",cascade = CascadeType.ALL)
    private Set<Classroom> classrooms;
}
