package com.example.CRUDApp.book;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String author;
    private String slug;


}
