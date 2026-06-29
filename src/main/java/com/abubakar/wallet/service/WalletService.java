package com.abubakar.wallet.service;

import com.abubakar.wallet.model.Wallet;
import com.abubakar.wallet.repository.WalletRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class WalletService {

    private final WalletRepository walletRepository;
    private final TransactionHistoryService transactionHistoryService;

    public WalletService(WalletRepository walletRepository, TransactionHistoryService transactionHistoryService) {
        this.walletRepository = walletRepository;
        this.transactionHistoryService = transactionHistoryService;
    }


    @Transactional // Ensures 'Deduct' and 'Add' happen together
    public void transferMoney(Long senderId, Long receiverId, BigDecimal amount) {
        Wallet sender = walletRepository.findById(senderId)
                .orElseThrow(() -> new RuntimeException("Sender Wallet not found!"));

        Wallet receiver = walletRepository.findById(receiverId)
                .orElseThrow(() -> new RuntimeException("Beneficiary Wallet not found!"));

        if (sender.getBalance().compareTo(amount) < 0)
            throw new RuntimeException("Insufficient Balance!");

        sender.setBalance(sender.getBalance().subtract(amount));
        receiver.setBalance(receiver.getBalance().add(amount));

        walletRepository.save(sender);
        walletRepository.save(receiver);

        transactionHistoryService.recordTransaction(senderId, receiverId, amount, "SUCCESS");

    }
}
