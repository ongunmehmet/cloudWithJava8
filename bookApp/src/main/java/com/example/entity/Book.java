package com.example.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "Book")
public class Book {
    @Id
    private long id;
    private String name;
    private String author;
    private int stock;

}
