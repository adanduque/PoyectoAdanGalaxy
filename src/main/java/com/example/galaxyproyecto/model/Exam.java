package com.example.galaxyproyecto.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "EXAMS")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Exam {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqExam")
    @SequenceGenerator(sequenceName = "SEQ_EXAM", allocationSize = 1, name = "seqExam")
    private Integer idExam;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String description;
    @ManyToOne
    @JoinColumn(name = "id_course", nullable = false, foreignKey = @ForeignKey(name = "FK_EXAMS_COURSE"))
    private Course course;
    @Column(nullable = false)
    private Integer state;
    @Column(nullable = false)
    private LocalDateTime examDate;

}
