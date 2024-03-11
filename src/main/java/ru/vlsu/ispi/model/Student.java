package ru.vlsu.ispi.model;

import lombok.Data;
import javax.persistence.*;

@Entity
@Table(name = "student_table", schema = "public")
@Data
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    Long id;
    @Column(name="name")
    String name;
}
