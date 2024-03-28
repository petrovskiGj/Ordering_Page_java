package com.example.finalbmworder.Model;

import com.example.finalbmworder.Model.Enum.UserType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Entity
@Table(name = "UserTable")
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;
    private String email;
    private String Name;
    private String LastName;
    private UserType userType;

    public User(String username, String password, String email, String name, String lastName, UserType userType) {

        this.username = username;
        this.password = password;
        this.email = email;
        Name = name;
        LastName = lastName;
        this.userType = userType;
    }
}
