package com.ms.user.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.UUID;

@Entity
@Table(name = "TB_USERS")
@Data
public class UserModel {

    @Id
    @GeneratedValue(generator = "UUID")
    private UUID userId;

    private String name;

    private String email;
}
