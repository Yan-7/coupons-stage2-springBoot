package com.couponsstage2.services;

import com.couponsstage2.enteties.Category;
import com.couponsstage2.enteties.Coupon;
import com.couponsstage2.enteties.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class CustomerService extends ClientService {

    private int customerId;

    @Override
    public boolean login(String email, String password) {
        Optional<Customer> customerOpt = customerRep.findByEmailAndPassword(email, password);
        if (customerOpt.isPresent()) {
            Customer customer = customerOpt.get();
            this.customerId = customer.getId();
            System.out.println("Login successful, customer " + customer.getFirstName() + " is logged in");

            return true;
        }
        System.out.println("failed not login");
        return false;
    }


    public void purchaseCoupon(Coupon coupon) {  //v
        Optional<Customer> customerOpt = customerRep.findById(customerId);
        if (customerOpt.isPresent()) {
            Customer customer1 = customerOpt.get();
            System.out.println();
            System.out.println("customer for adding coupon: " + customer1);
            Optional<Coupon> optionalCoupon = couponsRep.findById(coupon.getId());
            System.out.println("the coupon: " + optionalCoupon);
            if (optionalCoupon.isPresent()) {
                Coupon coupon1 = optionalCoupon.get();
                customer1.attachCouponToCustomer(coupon1);
                coupon1.setAmount(coupon1.getAmount() - 1);
                return;
            }
        }
        System.out.println("could not add coupon to customer");
    }

    public List<Coupon> getCustomerCoupons() { //v
        System.out.println("customer " + customerId + " coupons:");
        return couponsRep.findByCustomersId(customerId);
    }


    @Transactional
    public List<Coupon> getCustomerCouponsByCategory(Category category) {  //v
        Optional<Customer> customerOpt = customerRep.findById(customerId);
        if (customerOpt.isPresent()) {
            Customer customer = customerOpt.get();
            System.out.println("customer coupons by category: " + category);
            List<Coupon> customerCoupons = customer.getCoupons();
            System.out.println(customerCoupons);
            // load the coupons eagerly before the session is closed
            System.out.println("size: " + customerCoupons.size());

            List<Coupon> result = new ArrayList<>();
            for (Coupon coupon : customerCoupons) {
                if (coupon.getCategory().equals(category)) {
                    result.add(coupon);
                }
            }
            System.out.println("coupons by category: " + category);
            System.out.println(result);
            return result;
        }
        System.out.println("could not find coupon");
        return null;
    }
    public List<Coupon> getCustomerCouponsByMaxPrice(double maxPrice) { //v
        List<Coupon> customerCoupons = couponsRep.findByCustomersId(customerId);

        if (!customerCoupons.isEmpty()) {
            List<Coupon> customerCoupons2 = new ArrayList<>();
            for (Coupon c : customerCoupons) {
                if (c.getPrice() <= maxPrice) {
                    customerCoupons2.add(c);
                }
            }
            System.out.println("customer coupons by price: " + maxPrice);
            System.out.println(customerCoupons2);
            return customerCoupons2;
        }
        System.out.println("could not find coupons by max price "+ maxPrice);
        return null;
    }


    public Optional<Customer> getCustomerDetails() { //v
        System.out.println("customer details:");
        return customerRep.findById(customerId);
    }

}
