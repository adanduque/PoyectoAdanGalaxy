package com.example.galaxyproyecto.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "NOTES")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Note {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqNote")
    @SequenceGenerator(sequenceName = "SEQ_NOTE", allocationSize = 1, name = "seqNote")
    private Integer idNote;
    @Column(nullable = false)
    private Integer value;
    @ManyToOne
    @JoinColumn(name = "id_student", nullable = false, foreignKey = @ForeignKey(name = "FK_NOTE_STUDENT"))
    private Student student;
    @ManyToOne
    @JoinColumn(name = "id_exam", nullable = false, foreignKey = @ForeignKey(name = "FK_NOTE_EXAM"))
    private Exam exam;
    @Column(nullable = false)
    private Integer state;
}
