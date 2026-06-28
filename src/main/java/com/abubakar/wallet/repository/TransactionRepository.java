package com.abubakar.wallet.repository;

import com.abubakar.wallet.model.TransactionRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<TransactionRecord, Long> {
}
