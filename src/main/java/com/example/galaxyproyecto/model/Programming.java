package com.example.galaxyproyecto.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "PROGRAMING")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Programming {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqProgramming")
    @SequenceGenerator(sequenceName = "SEQ_PROGRAMING", allocationSize = 1, name = "seqProgramming")
    private Integer idProgramming;

    @ManyToOne
    @JoinColumn(name = "id_course", nullable = false, foreignKey = @ForeignKey(name = "FK_PROGRAMING_COURSE"))
    private Course course;

    @ManyToOne
    @JoinColumn(name = "id_teacher", nullable = false, foreignKey = @ForeignKey(name = "FK_COURSE_TEACHER"))
    private Teacher teacher;

    @ManyToOne
    @JoinColumn(name = "id_schedule", nullable = false, foreignKey = @ForeignKey(name = "FK_PROGRAMING_SCHEDULE"))
    private Schedule schedule;

    @Column(nullable = false, length = 300)
    private String classroom;

    @Column(nullable = false)
    private Integer numberStudents;

    @Column(nullable = false)
    private Integer state;

}
