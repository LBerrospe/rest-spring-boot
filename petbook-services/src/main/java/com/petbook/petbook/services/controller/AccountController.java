package com.petbook.petbook.services.controller;

import com.petbook.petbook.services.repository.entity.AccountEntity;
import com.petbook.petbook.services.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    @Autowired
    private AccountService service;

    @GetMapping
    ResponseEntity<List<AccountEntity>> all(
            @RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "size", defaultValue = "100") int size
    ) {
        return service.getAccounts(page, size);
    }

    @GetMapping("/{id}")
    ResponseEntity<AccountEntity> one(
            @PathVariable("id") Long id
    ) {
        return service.getAccount(id);
    }

    @DeleteMapping("/{id}")
    ResponseEntity deleteOne(
            @PathVariable("id") Long id
    ) {
        return service.deleteAccount(id);
    }
}
