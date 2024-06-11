package com.bookstore.IT355_Project.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "writer")
@RequiredArgsConstructor
public class Writer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "writer_id", nullable = false)
    private Integer id;

    @Lob
    @Column(name = "writer_name", nullable = false)
    private String writerName;

    @Lob
    @Column(name = "writer_surname", nullable = false)
    private String writerSurname;

    @Lob
    @Column(name = "writer_state", nullable = false)
    private String writerState;

}