package fr.inventiv.cases.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity(name = "cases")

//@AllArgsConstructor
//@NoArgsConstructor
@Data
public class Case {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long caseId;
    @Column(length = 255)
    private String title;
    @Column(length = 2056)
    private String description;
    @Column(name = "creation_date")
    private LocalDateTime creationDate;
    @Column(name = "last_update_date")
    private LocalDateTime lastUpdateDate;
}
