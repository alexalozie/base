package org.lamisplus.base.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "Visit")
@Data
@EqualsAndHashCode
public class Visit {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Basic
    @Column(name = "date_visit_end", nullable = true)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd:MM:yyyy")
    private LocalDate dateVisitEnd;

    @Basic
    @Column(name = "date_visit_start", nullable = true)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd:MM:yyyy")
    private LocalDate dateVisitStart;

    @Basic
    @Column(name = "time_visit_start", nullable = true)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "KK:mm a")
    private LocalTime timeVisitEnd;

    @Basic
    @Column(name = "time_visit_end", nullable = true)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "KK:mm a")
    private LocalTime timeVisitStart;

    @Basic
    @Column(name = "date_next_appointment", nullable = true)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd:MM:yyyy")
    private LocalDate dateNextAppointment;

    @JoinColumn(name = "patient_id")
    @ManyToOne
    @JsonIgnore
    private Patient patient;

    @JoinColumn(name = "visit_type_id")
    @ManyToOne
    @JsonIgnore
    private ApplicationCodeset visitType;

}
