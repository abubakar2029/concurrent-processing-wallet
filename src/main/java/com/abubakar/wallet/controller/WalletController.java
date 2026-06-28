package com.abubakar.wallet.controller;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transactions")
public class WalletController {

    @PutMapping("/")
    public void class addTransaction(){

    }
}
