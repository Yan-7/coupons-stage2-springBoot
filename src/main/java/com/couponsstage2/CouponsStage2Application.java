package com.couponsstage2;

//import com.couponsstage2.dailyJob.CouponExpiration;
import com.couponsstage2.dailyJob.CouponExpiration;
import com.couponsstage2.enteties.Coupon;
import com.couponsstage2.exceptions.CouponException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class CouponsStage2Application {
	

	public static void main(String[] args) {
		SpringApplication.run(CouponsStage2Application.class, args);
//		CouponExpiration couponExpiration;
//		couponExpiration.deleteExpiredCoupons();

	}

}
