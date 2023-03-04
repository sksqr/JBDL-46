package com.example.L09SpringJPAdemo.repo;

import com.example.L09SpringJPAdemo.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAddressRepo extends JpaRepository<Address,Long> {
}
