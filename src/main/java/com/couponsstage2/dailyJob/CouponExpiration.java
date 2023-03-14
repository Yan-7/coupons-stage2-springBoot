package com.couponsstage2.dailyJob;

import com.couponsstage2.enteties.Category;
import com.couponsstage2.enteties.Coupon;
import com.couponsstage2.repositories.CouponsRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

    // TODO: 14/03/2023 add class to main method.
//@Component

public class CouponExpiration {


//    @Autowired
    private CouponsRep couponsRep;

    @Scheduled(timeUnit = TimeUnit.DAYS, fixedRate = 1)
    public void deleteExpiredCoupons() {
        System.out.println("starting to delete expired coupons");
        List<Coupon> coupons = couponsRep.findAll();
        if (coupons.isEmpty()) {
            System.out.println("coupons list is empty");
        } else {
            for (Coupon c : coupons) {
                if (c.getEndDate().isAfter(LocalDate.now())) {
                    couponsRep.deleteById(c.getId());
                    System.out.println("coupon " + c.getId() + "was deleted due to expiration");
                }
            }
        }
    }
}