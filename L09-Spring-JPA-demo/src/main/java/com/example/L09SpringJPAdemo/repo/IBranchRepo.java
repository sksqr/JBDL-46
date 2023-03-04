package com.example.L09SpringJPAdemo.repo;

import com.example.L09SpringJPAdemo.entity.Branch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

@Repository
public interface IBranchRepo extends JpaRepository<Branch, Long> {
}
