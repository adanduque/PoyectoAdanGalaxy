package com.example.galaxyproyecto.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "TEACHERS")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqTeacher")
    @SequenceGenerator(sequenceName = "SEQ_TEACHER", allocationSize = 1, name = "seqTeacher")
    private Integer idTeacher;
    @Column(length = 250,nullable = false)
    private String name;
    @Column(length = 9,nullable = false)
    private String dni;
    @Column(nullable = false)
    private LocalDateTime birthDate;
    @Column(nullable = false)
    private Integer state;
}
