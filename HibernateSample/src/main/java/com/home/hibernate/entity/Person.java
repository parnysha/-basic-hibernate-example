package com.home.hibernate.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name =  "person_test")
@Data
@NoArgsConstructor
public class Person {
    @Id
    @GeneratedValue()
    private int id;

    private String name;
    private String email;

    @Embedded
    private Phone phone;

    public Person(String name, String email, Phone phone){
        this.name = name;
        this.email = email;
        this.phone = phone;
    }
}
