package com.example.L09SpringJPAdemo;

import com.example.L09SpringJPAdemo.entity.Branch;
import com.example.L09SpringJPAdemo.repo.IBranchRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/branch")
public class BranchController {

    @Autowired
    private IBranchRepo branchRepo;

    @GetMapping("/{id}")
    ResponseEntity<Branch> getBranch(@PathVariable Long id){
        Branch branch = branchRepo.findById(id).get();
        return ResponseEntity.ok(branch);
    }
}
