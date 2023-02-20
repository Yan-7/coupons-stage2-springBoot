package com.couponsstage2.login;

import com.couponsstage2.repositories.CompaniesRep;
import com.couponsstage2.services.AdminService;
import com.couponsstage2.services.ClientService;
import com.couponsstage2.services.CompanyService;
import com.couponsstage2.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginManager {

    @Autowired
    private AdminService adminService;
    @Autowired
    private CustomerService customerService;
    @Autowired
    private CompanyService companyService;

    @Autowired
    private CompaniesRep companiesRep;
    public ClientService login(String email, String password, ClientType clientType) {
        // TODO: 16/02/2023 check password & email 
        switch (clientType) {
            case Admin:
                if (email == "admin@admin.com" && password == "admin") {
                    return adminService;
                }
            case Company:
                if (companiesRep.findByEmailAndPassword(email, password).isPresent()) {
                    return companyService;
                }
            default:
                System.out.println("could not connect");
                return null;
        }
    }
}




