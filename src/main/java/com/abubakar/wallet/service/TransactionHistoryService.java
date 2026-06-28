package com.abubakar.wallet.service;

import com.abubakar.wallet.repository.TransactionRepository;
import org.springframework.stereotype.Service;

@Service
public class TransactionHistoryService {

    private final TransactionRepository repository;

    public TransactionHistoryService(TransactionRepository repository) {
        this.repository = repository;
    }
    
}
