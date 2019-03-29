package com.petbook.petbook.services.service;

import com.petbook.petbook.services.repository.AccountEntityRepository;
import com.petbook.petbook.services.repository.entity.AccountEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class AccountService {

    @Autowired
    AccountEntityRepository accountEntityRepository;

    public ResponseEntity<List<AccountEntity>> getAccounts(int page, int size) {
        log.debug("Getting paginated accountEntities. Page: {}, Size: {}", page, size);
        System.out.println("TEST: " + accountEntityRepository.findByEmailAddress("hector.berrospe@oracle.com"));
        Page<AccountEntity> accountsPage = accountEntityRepository.findAll(PageRequest.of(page, size));
        log.debug("Getting accountEntities content");
        List<AccountEntity> accountEntities = accountsPage.getContent();
        log.debug("Retrieved {} accountEntities", accountEntities.size());
        return ResponseEntity.ok(accountEntities);
    }

    public ResponseEntity<AccountEntity> getAccount(Long id) {
        log.debug("Getting account with id {}", id);
        Optional<AccountEntity> optionalAccount = accountEntityRepository.findById(id);
        if (optionalAccount.isPresent()) {
            throw new EntityNotFoundException("AccountEntity " + id + " is not found");
        }

        return ResponseEntity.ok(optionalAccount.get());
    }

    public ResponseEntity deleteAccount(Long id) {
        log.debug("Deleting account with id {}", id);
        accountEntityRepository.deleteById(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}
