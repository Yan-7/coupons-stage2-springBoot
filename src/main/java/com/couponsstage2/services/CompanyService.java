package com.couponsstage2.services;

import com.couponsstage2.enteties.Company;
import com.couponsstage2.enteties.Coupon;
import com.couponsstage2.exceptions.CouponsExceptions;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Transactional
@Service
public class CompanyService extends ClientService {

    private Company company;

    @Override
    public boolean login(String email, String password) {
        Optional<Company> optionalCompany = companiesRep.findByEmailAndPassword(email, password);
        if (optionalCompany.isPresent()) {
            System.out.println("company " + optionalCompany.get().getName() + "is logged in");
            return true;
        } else {
            try {
                throw new CouponsExceptions("login for " +  optionalCompany.get().getName() + "cannot login");
            } catch (CouponsExceptions e) {
                throw new RuntimeException(e);
            }

        }
    }

    public void addCoupon(Coupon coupon) {
        company = companiesRep.getReferenceById(this.company.getId());
        company.addCoupon(coupon);
    }

    public void updateCoupon(Coupon coupon) {
        couponsRep.save(coupon);
        System.out.println("coupon saved to repository");
    }

    public void deleteCoupon(int couponId) {
        if (couponsRep.existsById(couponId)) {
        couponsRep.deleteById(couponId);
        System.out.println("coupon " + couponId + " deleted");
    }


}
