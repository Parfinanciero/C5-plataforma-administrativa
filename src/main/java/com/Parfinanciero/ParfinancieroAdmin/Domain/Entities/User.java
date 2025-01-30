package com.Parfinanciero.ParfinancieroAdmin.Domain.Entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Builder
@Table(name = "User")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "name", length = 50, nullable = false)
    String name;

    @Column(name = "lastname", length = 100, nullable = false)
    String lastName;

    @Column(name ="password", length = 225, nullable = false)
    String password;

    @Column(name= "email", length = 50, nullable = false)
    String email;

    @Column(name = "role", nullable = false)
    String Role;

}
