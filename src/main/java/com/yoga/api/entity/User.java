package com.yoga.api.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user_master")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;
    private String userName;
    private String phoneNo;
    private String emailId;
    private String password;
    private Boolean isAdmin;

    private Boolean isActive;
    private LocalDateTime createdOn;
    private String createdBy;
    private LocalDateTime updatedOn;
    private String updatedBy;


}
