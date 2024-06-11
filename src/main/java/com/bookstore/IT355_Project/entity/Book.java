package com.bookstore.IT355_Project.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Getter
@Setter
@Entity
@Table(name = "book")
@RequiredArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id", nullable = false)
    private Integer id;

    @OneToOne(fetch = FetchType.EAGER, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "writer_id", nullable = false)
    private Writer writer;

    @OneToOne(fetch = FetchType.EAGER, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "publisher_id", nullable = false)
    private Publisher publisher;

    @Lob
    @Column(name = "book_title", nullable = false)
    private String bookTitle;

    @Lob
    @Column(name = "book_image_url", nullable = false)
    private String bookImageUrl;

    @Lob
    @Column(name = "book_genre", nullable = false)
    private String bookGenre;

    @Column(name = "price", nullable = false)
    private Double price;

    @Column(name = "book_year", nullable = false)
    private Integer bookYear;

}