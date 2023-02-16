package com.couponsstage2.login;

import com.couponsstage2.services.AdminService;
import com.couponsstage2.services.ClientService;
import com.couponsstage2.services.CompanyService;
import com.couponsstage2.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// TODO: 14/02/2023
@Service
public class LoginManager {

    @Autowired
    private AdminService adminService;
    @Autowired
    private CustomerService customerService;
    @Autowired
    private CompanyService companyService;

    public ClientService login(String email, String password, ClientType clientType ) {
        // TODO: 16/02/2023 check password & email 
        switch (clientType) {
            case Admin -> {
                return adminService;
            }
            // TODO: 16/02/2023 add customer and company 
            default -> {
                return null;    
            }
            
        }
    } 

    public enum ClientType {
        Admin,
        Customer,
        Company;
    }

}




