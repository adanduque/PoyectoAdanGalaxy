package com.example.galaxyproyecto.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "SCHEDULES")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqSchedule")
    @SequenceGenerator(sequenceName = "SEQ_SCHEDULE", allocationSize = 1, name = "seqSchedule")
    private Integer idSchedule;

    @Column(nullable = false)
    private LocalDateTime startTime;

    @Column(nullable = false)
    private LocalDateTime endTime;

    @Column(nullable = false, length = 150)
    private String days;

    @Column(nullable = false)
    private Integer state;
}
