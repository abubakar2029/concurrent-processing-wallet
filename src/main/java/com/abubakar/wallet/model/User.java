package com.abubakar.wallet.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "app_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private Wallet wallet;
}
