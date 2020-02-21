package com.anna.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="users")
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User {

    @Id()
    @GeneratedValue
    @Getter
    @Setter
    private Long userId;

    @Column(name="user_name")
    @Getter
    @Setter
    private String name;

    @Column(name="user_surname")
    @Getter
    @Setter
    private String surname;

    @Column(name="passport_id")
    @Getter
    @Setter
    private String passportId;

    @Column(name="email")
    @Getter
    @Setter
    private String email;

    @Column(name="password")
    @Getter
    @Setter
    private String password;
}
