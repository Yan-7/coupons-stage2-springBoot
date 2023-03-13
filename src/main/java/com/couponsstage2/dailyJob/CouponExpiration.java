package com.couponsstage2.dailyJob;

import com.couponsstage2.enteties.Coupon;
import com.couponsstage2.repositories.CouponsRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
import java.util.concurrent.TimeUnit;
@Component
public class CouponExpiration{

    @Autowired
    CouponsRep couponsRep;

    // TODO: 13/03/2023 we get the coupons with the repository
    @Scheduled (timeUnit = TimeUnit.SECONDS,fixedRate = 5)
    public void deleteCoupons(List<Coupon> couponList) {
        for (Coupon c: couponList) {
            if (c.getEndDate().isAfter(LocalDate.now())) {
                couponsRep.deleteById(c.getId());
            }
        }
    }

}