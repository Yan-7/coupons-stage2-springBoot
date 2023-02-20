//package com.couponsstage2;
//
//import com.couponsstage2.enteties.Company;
//import com.couponsstage2.enteties.Coupon;
//import com.couponsstage2.enteties.Customer;
//import com.couponsstage2.login.ClientType;
//import com.couponsstage2.login.LoginManager;
//import com.couponsstage2.services.AdminService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.stereotype.Component;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Component
//public class Tests implements CommandLineRunner {
//
//    @Autowired
//    private LoginManager loginManager;
//
//    @Override
//    public void run(String... args) throws Exception {
//
//
//        Coupon coupon1 = new Coupon();
//        List<Coupon> coupons = new ArrayList<>();
//        coupons.add(coupon1);
//        Company comp1 = new Company(14,"MoshePhone", "Moshe@", "admin",coupons );
//        Customer customer1 = new Customer(1,"Bob","Sponge","bob@","1234",coupons);
//
//        AdminService admin = (AdminService) loginManager.login("admin@admin.com", "admin", ClientType.Admin);
//
//        System.out.println("----------------------");
//
//        System.out.println(admin.getAllCompanies());
//
//        System.out.println("--------------");
//    //    admin.addCustomer(customer1);
//
//
//        System.out.println(admin.getAllCustomers());
////        admin.deleteCustomer(1);
////        System.out.println(admin.getOneCustomer(customer1.getId()));
////        System.out.println(customer1.getId());
////        System.out.println(admin.getAllCustomers());
//        //        admin.addCustomer(customer1);4
//        //        admin.addCompany(comp1);
////        admin.deleteCompany(comp1.getId());
////        admin.updateCompany(comp1);
////        System.out.println(comp1.getId());
////        System.out.println(admin.getOneCompany(comp1.getId()));
//    }
//}
