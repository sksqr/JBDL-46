package org.example;

import org.example.dto.WalletDto;
import org.example.service.WalletService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/wallet-service")
public class WalletController {

    private static Logger LOGGER = LoggerFactory.getLogger(WalletController.class);

    @Autowired
    private WalletService walletService;
    @Autowired
    private WalletRepo walletRepo;

    @GetMapping("/balance")
    ResponseEntity<WalletDto> getBalance(@RequestHeader Long userId){
        LOGGER.info("Balance Request for user {} ", userId);
        WalletDto walletDto = walletService.getBalance(userId);
        return ResponseEntity.ok(walletDto);
    }
}
