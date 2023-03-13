package com.couponsstage2;

import com.couponsstage2.enteties.Company;
import com.couponsstage2.enteties.Coupon;
import com.couponsstage2.enteties.Customer;
import com.couponsstage2.exceptions.CouponException;
import com.couponsstage2.login.ClientType;
import com.couponsstage2.login.LoginManager;
import com.couponsstage2.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TestsAdminService implements CommandLineRunner {

    @Autowired
    private LoginManager loginManager;

//    @Autowired
//    private AdminService adminService;

    @Override
    public void run(String... args) throws Exception {


        Coupon coupon1 = new Coupon();
        List<Coupon> coupons = new ArrayList<>();
        coupons.add(coupon1);
        Company comp1 = new Company(0, "MoshePhone", "Moshe@", "admin", coupons);
        Company comp2 = new Company(0, "MoshePhone2", "Moshe2@", "admin", coupons);
        Customer customer1 = new Customer(0, "Bob", "Sponge", "bob@", "1234", coupons);


        AdminService admin = (AdminService) loginManager.login("admin@admin.com", "admin", ClientType.Admin);

// TODO: 28/02/2023 the exceptions are crashing the software
        System.out.println("---------------------->");

        try {
            admin.addCompany(comp1);
        } catch (CouponException exceptions) {
            System.out.println("error");
            System.out.println(exceptions.getMessage());
        }


        System.out.println(admin.getOneCompany(comp1.getId()));
        System.out.println("--------------<");
        //    admin.addCustomer(customer1);

//        admin.deleteCustomer(1);
//        System.out.println(admin.getOneCustomer(customer1.getId()));
//        System.out.println(customer1.getId());
//        System.out.println(admin.getAllCustomers());
        //        admin.addCustomer(customer1);4
//        admin.deleteCompany(comp1.getId());
//        admin.updateCompany(comp1);
//        System.out.println(comp1.getId());
    }
}
