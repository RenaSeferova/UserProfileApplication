package com.example.userprofileapplication.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "users")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "profile_id")
    private Profile profile;

//    @OneToMany(mappedBy = "user",cascade = {CascadeType.ALL},fetch =FetchType.EAGER )
//    private List<Post> post;

    @ManyToOne
    private Post posts;

}
