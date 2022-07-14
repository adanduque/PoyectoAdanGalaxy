package com.example.galaxyproyecto.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "COURSES")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqCourse")
    @SequenceGenerator(sequenceName = "SEQ_COURSE", allocationSize = 1, name = "seqCourse")
    private Integer idCourse;
    @Column(length = 50,nullable = false)
    private String name;
    @Column(nullable = false)
    private Integer state;

}
