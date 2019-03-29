package com.petbook.petbook.services.repository.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@ToString
@Entity
@Table(name = "ACCOUNT")
public class AccountEntity {

    @Id
    private Long id;
    private String lookupName;
    private String emailAddress;
    private String password;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private Date birthdayDate;
    @OneToOne
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private AddressEntity addressEntity;
}
