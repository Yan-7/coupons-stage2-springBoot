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


//@Component
public class TestsCompanyService implements CommandLineRunner {

    @Autowired
    private LoginManager loginManager;

    @Override
    public void run(String... args) throws Exception {

        List<Customer> customers = new ArrayList<>();
        List<Coupon> coupons = new ArrayList<>();
        Company comp1 = new Company(15, "MoshePhone", "Moshe@", "1234", coupons);
        Company comp1Update = new Company(15, "MoshePhoneU", "Moshe@U", "1234", coupons);
        Coupon coupon1 = new Coupon(3, Category.ELECTRICITY, "chip", "bla bla", LocalDate.of(2000, 1, 1), LocalDate.of(2030, 1, 1), 100, 99, "image", customers, comp1);
        Coupon coupon10 = new Coupon(10, Category.FOOD, "burger", "bla bla", LocalDate.of(2000, 1, 1), LocalDate.of(2030, 1, 1), 100, 99, "image", null, comp1);
        coupons.add(coupon1);
        Customer customer1 = new Customer(1, "Bob", "Sponge", "bob@", "1234", coupons);

        CompanyService companyService = (CompanyService) loginManager.login(comp1.getEmail(),comp1.getPassword(), ClientType.Company);
        companyService.login(comp1.getEmail(),comp1.getPassword());
        System.out.println("----------------->");
        companyService.getCompanyDetails();
        System.out.println("<------------->");

        companyService.addCouponToCompany(coupon10);
        companyService.updateCoupon(coupon10);
        companyService.deleteCoupon(10);
        companyService.getCompanyCoupons();
        companyService.getCompanyCouponsByCategory(Category.FOOD);
        companyService.getCompanyCouponsByMaxPrice(70);


        System.out.println("<--------------");


    }
}
