package com.couponsstage2.login;

import com.couponsstage2.repositories.CompaniesRep;
import com.couponsstage2.repositories.CustomerRep;
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

    @Autowired
    private CustomerRep customerRep;

    public ClientService login(String email, String password, ClientType clientType) {
        switch (clientType) {
            case Admin: {
                if ("admin@admin.com".equals(email) && "admin".equals(password)) {

                    return adminService;
                }
                break;
            }
            case Company: {
                if (companiesRep.findByEmailAndPassword(email, password).isPresent()) {
                    return companyService;
                }
                break;
            }
            case Customer: {
                if (customerRep.findByEmailAndPassword(email, password).orElse(null) != null) {
                    return customerService;
                }
                break;
            }
        }
        System.out.println("Could not connect");
        return null;
    }
}
