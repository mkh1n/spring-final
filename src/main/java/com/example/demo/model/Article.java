package com.example.demo.model;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Getter;
import lombok.Setter;
@Getter
@Entity
@Table(name = "articles")
@NoArgsConstructor
@RequiredArgsConstructor
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Setter
    @NonNull
    private String title;

    @Setter
    @NonNull
    private String body;

    @Setter
    @NonNull
    private String author;

}

