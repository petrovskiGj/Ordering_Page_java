package com.example.finalbmworder.Repository;


import com.example.finalbmworder.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
