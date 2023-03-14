package com.couponsstage2;

import com.couponsstage2.enteties.Category;
import com.couponsstage2.enteties.Company;
import com.couponsstage2.enteties.Coupon;
import com.couponsstage2.enteties.Customer;
import com.couponsstage2.login.ClientType;
import com.couponsstage2.login.LoginManager;
import com.couponsstage2.services.AdminService;
import com.couponsstage2.services.CompanyService;
import com.couponsstage2.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class AppTest implements CommandLineRunner {

    @Autowired
    private LoginManager loginManager;

    @Override
    public void run(String... args) throws Exception {


        List<Customer> customers;

        Customer customer1 = new Customer(1, "Bob", "Sponge", "bob@", "1234", null);
        Customer customer2 = new Customer(2, "Bob2", "Sponge2", "bob2@", "1234", null);
        Customer customer3 = new Customer(3, "Bob", "Sponge", "bob@", "1234", null);

        Company comp1 = new Company(1, "MoshePhone", "Moshe@", "admin", null);
        Company comp2 = new Company(2, "MoshePhone2", "Moshe2@", "1234", null);
        Company comp3 = new Company(3, "MoshePhone3", "Moshe3@", "1234", null);

        Coupon coupon1 = new Coupon(1, Category.ELECTRICITY, "chip", "bla bla", LocalDate.of(2000, 1, 1), LocalDate.of(2030, 1, 1), 100, 20, "image", null, comp2);
        Coupon coupon2 = new Coupon(2, Category.ELECTRICITY, "chip", "bla bla", LocalDate.of(2000, 1, 1), LocalDate.of(2030, 1, 1), 100, 99, "image", null, comp2);
        Coupon coupon3 = new Coupon(3, Category.FOOD, "chips", "bla bla10", LocalDate.of(2000, 1, 1), LocalDate.of(2030, 1, 1), 100, 50, "image", null, comp2);
        Coupon coupon4 = new Coupon(4, Category.FOOD, "burger", "bla bla", LocalDate.of(2000, 1, 1), LocalDate.of(2030, 1, 1), 100, 99, "image", null, comp2);

        //test for admin service:
        System.out.println("Admin service test ---------------------->");
        AdminService admin = (AdminService) loginManager.login("admin@admin.com", "admin", ClientType.Admin);
        admin.login("admin@admin.com", "admin");
        System.out.println();
        admin.addCustomer(customer1);
        admin.addCustomer(customer2);
        admin.addCompany(comp1);
        admin.addCompany(comp2);
        admin.addCompany(comp3);
        System.out.println("get company:");
        System.out.println(admin.getOneCompany(comp1.getId()));
        System.out.println("getting customer:");
        System.out.println(admin.getOneCustomer(1));
        admin.deleteCustomer(2);                       //customer 2 deleted
        admin.updateCompany(comp1);
        admin.deleteCompany(comp3.getId());
        System.out.println("getting all customers:");
        System.out.println(admin.getAllCustomers());
        System.out.println("<---------------------------------Admin service Test");
        System.out.println();

        //test for company service:
        System.out.println("Company service test------------------------------>");
        CompanyService companyService = (CompanyService) loginManager.login(comp2.getEmail(), comp2.getPassword(), ClientType.Company);
        companyService.login(comp2.getEmail(), comp2.getPassword());
        System.out.println();
        companyService.addCouponToCompany(coupon1);
        companyService.addCouponToCompany(coupon2);
        companyService.addCouponToCompany(coupon3);
        companyService.updateCoupon(coupon1);
        companyService.deleteCoupon(2);
        System.out.println(companyService.getCompanyDetails());
        System.out.println(companyService.getCompanyCoupons());
        System.out.println(companyService.getCompanyCouponsByCategory(Category.FOOD));
        companyService.getCompanyCouponsByMaxPrice(70);
        System.out.println("<--------------Company service test");
        System.out.println();

        //test for customer service
        System.out.println("Customer Service test--------------------->");
        CustomerService customerService = (CustomerService) loginManager.login("bob@", "1234", ClientType.Customer);
        customerService.login(customer1.getEmail(), customer1.getPassword());
        System.out.println();
        System.out.println(customerService.getCustomerDetails());
        customerService.purchaseCoupon(coupon1);
        customerService.purchaseCoupon(coupon3);
        customerService.getCustomerCouponsByCategory(Category.FOOD);
        customerService.getCustomerCouponsByMaxPrice(60);
        System.out.println("<---------------------Customer Service test");

    }
}
