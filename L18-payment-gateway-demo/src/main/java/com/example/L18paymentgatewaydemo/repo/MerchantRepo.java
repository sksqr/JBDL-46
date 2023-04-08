package com.example.L18paymentgatewaydemo.repo;

import com.example.L18paymentgatewaydemo.entity.Merchant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MerchantRepo extends JpaRepository<Merchant, Long> {
}
