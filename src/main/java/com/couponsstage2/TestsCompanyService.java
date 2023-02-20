package com.couponsstage2;

import com.couponsstage2.enteties.Category;
import com.couponsstage2.enteties.Company;
import com.couponsstage2.enteties.Coupon;
import com.couponsstage2.enteties.Customer;
import com.couponsstage2.login.ClientType;
import com.couponsstage2.login.LoginManager;
import com.couponsstage2.services.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Component
public class TestsCompanyService implements CommandLineRunner {

    @Autowired
    private LoginManager loginManager;

    @Override
    public void run(String... args) throws Exception {

        List<Customer> customers = new ArrayList<>();
        List<Coupon> coupons = new ArrayList<>();
        Company comp1 = new Company(14, "MoshePhone", "Moshe@", "admin", coupons);
        Coupon coupon1 = new Coupon(1, Category.ELECTRICITY, "chip", "bla bla", LocalDate.of(2000, 1, 1), LocalDate.of(2030, 1, 1), 100, 99, "image", customers, comp1);
        coupons.add(coupon1);
        Customer customer1 = new Customer(1, "Bob", "Sponge", "bob@", "1234", coupons);

        CompanyService companyService = (CompanyService) loginManager.login(comp1.getEmail(),comp1.getPassword(), ClientType.Company);

        System.out.println("-------------");
        companyService.addCoupon(coupon1);
        System.out.println("--------------");


    }
}
