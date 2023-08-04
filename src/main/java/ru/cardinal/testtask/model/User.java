package ru.cardinal.testtask.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false, unique = true)
    private long id;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "sur_name", nullable = false)
    private String surName;
    @Column(name = "email", nullable = false)
    private String email;
    @Column(name = "image_url", nullable = false)
    private String imageUrl;
    @Column(name = "status", nullable = false)
    private String status;
}
