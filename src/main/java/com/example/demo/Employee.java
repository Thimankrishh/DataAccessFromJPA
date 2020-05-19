package com.example.demo;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private int age;

    protected Employee() {

    }

    public Employee(long id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }



    @Override
    public String toString() {
        return String.format(
                "Employee[id=%d, name='%s', age=%d]",
                id, name, age);
    }
}
