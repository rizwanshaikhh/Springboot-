package com.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import lombok.Data;



@Entity
@Data
public class Election {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long electionId;

    @NotNull
    @Column(name="ElectionName", unique=true)
    private String electionName;
    
    @NotNull
    private LocalDate electionDate;
}
