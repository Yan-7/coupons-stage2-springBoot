package com.couponsstage2;

import com.couponsstage2.enteties.Category;
import com.couponsstage2.enteties.Company;
import com.couponsstage2.enteties.Coupon;
import com.couponsstage2.enteties.Customer;
import com.couponsstage2.login.ClientType;
import com.couponsstage2.login.LoginManager;
import com.couponsstage2.services.ClientService;
import com.couponsstage2.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

//@Component
public class TestsCustomerService implements CommandLineRunner {

    @Autowired
    private LoginManager loginManager;

    @Override
    public void run(String... args) throws Exception {

        CustomerService customerService = (CustomerService) loginManager.login("bob@", "1234", ClientType.Customer);

        List<Customer> customers = new ArrayList<>();
        List<Coupon> coupons = new ArrayList<>();
        Company comp1 = new Company(1, "MoshePhone", "Moshe@", "admin", coupons);
        Coupon coupon1 = new Coupon(3, Category.ELECTRICITY, "chip", "bla bla", LocalDate.of(2000, 1, 1), LocalDate.of(2030, 1, 1), 100, 99, "image", customers, comp1);
        Coupon coupon7 = new Coupon(7, Category.FOOD, "chips", "bla bla10", LocalDate.of(2000, 1, 1), LocalDate.of(2030, 1, 1), 100, 99, "image", customers, comp1);
        coupons.add(coupon1);

        Customer customer3 = new Customer(3, "Bob", "Sponge", "bob@", "1234", coupons);


        customerService.login(customer3.getEmail(), customer3.getPassword());
        System.out.println("customer details:");
        System.out.println(customerService.getCustomerDetails());
        System.out.println("-----------------------------");

        System.out.println("--------------------");
        System.out.println("-----------");
    }
}

//            customerService.getCustomerCouponsByMaxPrice(1); v
//        customerService.getCustomerCouponsByCategory(Category.FOOD); v
//        customerService.purchaseCoupon(coupon7); v
//        System.out.println(customerService.getCustomerDetails()); v
