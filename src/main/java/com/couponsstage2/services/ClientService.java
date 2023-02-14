package com.couponsstage2.services;

import com.couponsstage2.repositories.CompaniesRep;
import com.couponsstage2.repositories.CouponsRep;
import com.couponsstage2.repositories.CustomerRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


public abstract class ClientService {


    @Autowired
    public CustomerRep customerRep;

    @Autowired
    public CompaniesRep companiesRep;

    @Autowired
    public CouponsRep couponsRep;

    public boolean login(String email, String password) {
        return false;
    }
}
