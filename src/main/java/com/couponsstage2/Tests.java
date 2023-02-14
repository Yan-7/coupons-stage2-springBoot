package com.couponsstage2;

import com.couponsstage2.enteties.Company;
import com.couponsstage2.enteties.Coupon;
import com.couponsstage2.services.AdminService;
import org.springframework.boot.CommandLineRunner;

import java.util.ArrayList;
import java.util.List;

public class Tests implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {

        Coupon coupon1 = new Coupon();
        List<Coupon> coupons = new ArrayList<>();
        coupons.add(coupon1);
        Company comp1 = new Company(0,"intel", "intel@", "admin",coupons );

        AdminService adminService = new AdminService();
        adminService.addCompany(comp1);
    }
}
