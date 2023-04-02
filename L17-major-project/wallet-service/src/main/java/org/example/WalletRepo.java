package org.example;

import org.example.entity.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WalletRepo extends JpaRepository<Wallet,Long> {
}
