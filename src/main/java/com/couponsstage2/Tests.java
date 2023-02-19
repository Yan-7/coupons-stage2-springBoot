package com.couponsstage2;

import com.couponsstage2.enteties.Company;
import com.couponsstage2.enteties.Coupon;
import com.couponsstage2.login.ClientType;
import com.couponsstage2.login.LoginManager;
import com.couponsstage2.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Tests implements CommandLineRunner {

    @Autowired
    private LoginManager loginManager;

    @Override
    public void run(String... args) throws Exception {


        Coupon coupon1 = new Coupon();
        List<Coupon> coupons = new ArrayList<>();
        coupons.add(coupon1);
        Company comp1 = new Company(0,"MoshePhone", "Moshe@", "admin",coupons );

        AdminService admin = (AdminService) loginManager.login("admin@admin.com", "admin", ClientType.Admin);
        admin.addCompany(comp1);
        System.out.println(admin.getAllCompanies());
    }
}
