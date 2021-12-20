package com.example.ExamProjectAA.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(nullable = false)
    private String first_name;

    @NotNull
    @Column(nullable = false)
    private String last_name;

    @NotNull
    @Column(nullable = false,unique = true)
    private String nickname;

    @OneToOne(mappedBy = "user")
    private Cart cart;


}
