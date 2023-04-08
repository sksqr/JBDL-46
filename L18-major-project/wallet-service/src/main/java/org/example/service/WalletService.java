package org.example.service;

import org.example.WalletRepo;
import org.example.dto.TransactionInitPayload;
import org.example.dto.WalletDto;
import org.example.entity.Wallet;
import org.example.exception.InsufficientBalance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class WalletService {

    @Autowired
    private WalletRepo walletRepo;

    public WalletDto getBalance(Long userId){
        Wallet wallet = walletRepo.findByUserId(userId);
        WalletDto walletDto = WalletDto.builder()
                .userId(wallet.getUserId())
                .balance(wallet.getBalance())
                .build();
        return walletDto;
    }

    @Transactional
    public void doWalletTxn(TransactionInitPayload transactionInitPayload) throws InsufficientBalance {
        Wallet fromWallet = walletRepo.findByUserId(transactionInitPayload.getFromUserId());
        if(fromWallet.getBalance() >= transactionInitPayload.getAmount()){
            Wallet toWallet = walletRepo.findByUserId(transactionInitPayload.getToUserId());
            fromWallet.setBalance(fromWallet.getBalance() - transactionInitPayload.getAmount());
            toWallet.setBalance(toWallet.getBalance() + transactionInitPayload.getAmount());
            walletRepo.save(toWallet);
            walletRepo.save(fromWallet);
        }
        else {
            throw  new InsufficientBalance("Low Balance");
        }
    }
}
