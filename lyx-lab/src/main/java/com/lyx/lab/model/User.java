package com.lyx.lab.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class User {
    @Id
    private Long id;
    @Column(length = 32)
    private String name;
    @Column(length = 64)
    private String password;
}
