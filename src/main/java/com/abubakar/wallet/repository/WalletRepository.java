package com.abubakar.wallet.repository;

import com.abubakar.wallet.model.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WalletRepository extends JpaRepository<Wallet,Long> {
}
