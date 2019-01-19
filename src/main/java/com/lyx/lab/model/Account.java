package com.lyx.lab.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class Account {
    @Id
    private Long id;
    @Column(length = 32)
    private String accCode;
    @Column(length = 8)
    private String accType;
}
