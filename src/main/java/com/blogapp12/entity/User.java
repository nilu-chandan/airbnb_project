package com.blogapp12.entity;

import lombok.Data;

import javax.persistence.*;

import javax.persistence.Entity;
import java.util.Set;

@Data
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String email;
    private String username;
    private String password;


//    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
//    @JoinTable(name = "user_roles",
//            joinColumns = @JoinColumns(name = "user_id",referencedColumnName = "id"),
//            inverseJoinColumns = @JoinColumns(name ="role_id", referencedColumnName = "id")
//    )

    private Set<Role> role;
}
