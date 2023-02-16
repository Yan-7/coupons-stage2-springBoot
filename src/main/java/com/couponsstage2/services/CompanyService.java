package com.couponsstage2.services;

import com.couponsstage2.enteties.Company;
import com.couponsstage2.enteties.Coupon;
import com.couponsstage2.exceptions.CouponsExceptions;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.Optional;

@Service
@Transactional
public class CompanyService extends ClientService {

    private int companyId;

    @Override
    public boolean login(String email, String password) {
        Optional<Company> optionalCompany = this.companiesRep.findByEmailAndPassword(email, password);
        if (optionalCompany.isPresent()) {
            System.out.println("company " + optionalCompany.get().getName() + "is logged in");
            Company company = optionalCompany.get();
            this.companyId = company.getId();
            return true;
        } else {
            try {
                throw new CouponsExceptions("login for " + optionalCompany.get().getName() + "cannot login");
            } catch (CouponsExceptions e) {
                throw new RuntimeException(e);
            }

        }
    }

    //
    public void addCoupon(Coupon coupon) {
        Company company = companiesRep.findById(coupon.getCompany().getId()).orElseThrow();
        if (coupon.getStartDate().isAfter(LocalDate.now()) && coupon.getEndDate().isBefore(LocalDate.now())) {
            company.addCoupon(coupon);
            System.out.println("coupon " + coupon.getDescription()+ " was added to company " + coupon.getCompany());
        }
    }
}

//
//    public void updateCoupon(Coupon coupon) {
//        couponsRep.save(coupon);
//        System.out.println("coupon saved to repository");
//    }
//
//    public void deleteCoupon(int couponId) {
//        if (couponsRep.existsById(couponId)) {
//            couponsRep.deleteById(couponId);
//            System.out.println("coupon " + couponId + " deleted");
//        }
//
//
//    }
//}