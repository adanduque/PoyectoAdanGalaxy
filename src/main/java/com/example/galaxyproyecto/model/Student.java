package com.example.galaxyproyecto.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "STUDENTS")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqStudent")
    @SequenceGenerator(sequenceName = "SEQ_STUDENT", allocationSize = 1, name = "seqStudent")
    private Integer idStudent;
    @Column(length = 250,nullable = false)
    private String name;
    @Column(length = 9,nullable = false)
    private String dni;
    @Column(nullable = false)
    private LocalDateTime birthDate;
    @Column(nullable = false)
    private Integer state;
}
