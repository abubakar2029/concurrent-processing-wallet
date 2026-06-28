package com.abubakar.wallet.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Wallet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long amount;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
}
