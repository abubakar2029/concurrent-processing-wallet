package com.abubakar.wallet.service;

import com.abubakar.wallet.model.TransactionRecord;
import com.abubakar.wallet.repository.TransactionRepository;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Service
public class TransactionHistoryService {

    private final TransactionRepository repository;

    public TransactionHistoryService(TransactionRepository repository) {
        this.repository = repository;
    }

    @Async // This creates a separate Thread!
    public void recordTransaction(Long senderId, Long receiverId, BigDecimal amount, String status) {
        TransactionRecord record = new TransactionRecord();

        record.setSenderWalletId(senderId);
        record.setReceiverWalletId(receiverId);
        record.setAmount(amount);
        record.setStatus(status);
        record.setTimestamp(LocalDateTime.now());

        repository.save(record);
        System.out.println("History saved in background thread: " + Thread.currentThread().getName());

    }

}
