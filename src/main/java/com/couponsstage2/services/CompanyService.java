package com.couponsstage2.services;

import com.couponsstage2.enteties.Category;
import com.couponsstage2.enteties.Company;
import com.couponsstage2.enteties.Coupon;
import com.couponsstage2.exceptions.CouponsExceptions;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
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

    // TODO: 20/02/2023 not working
    public void addCoupon(Coupon coupon) {
//        Optional<Company> optionalCompany = this.companiesRep.findById(coupon.getCompany().getId());
//        if (optionalCompany.isPresent()) {
////        if (coupon.getStartDate().isAfter(LocalDate.now()) && coupon.getEndDate().isBefore(LocalDate.now())) {
//            Company company = optionalCompany.get();
//            company.addCouponC(coupon);
//            System.out.println("coupon " + coupon.getDescription() + " was added to company " + coupon.getCompany());
//        } else {
//            System.out.println("could not add coupon to company");
//        }
//
    }

    // TODO: 21/02/2023 more testing
    public void updateCoupon(Coupon coupon) { //vx
        couponsRep.save(coupon);
        System.out.println("coupon saved to repository");
    }

    public void deleteCoupon(int couponId) { //v
        if (couponsRep.existsById(couponId)) {
            couponsRep.deleteById(couponId);
            System.out.println("coupon " + couponId + " deleted");
        }
    }

    // TODO: 21/02/2023 could not find
    public List<Coupon> getCompanyCoupons() {


        if (couponsRep.existsById(companyId)) {
            return couponsRep.findByCompanyId(companyId);
        }
        System.out.println("could not find coupons");
        return null;
    }

    public ArrayList<Coupon> getCompanyCouponsByCategory(Category category) {
        return null;
    }

    public ArrayList<Coupon> getCompanyCouponsByMaxPrice(double maxPrice) {
        return null;
    }

    public Company getCompanyDetails() {
        Optional<Company> optional = companiesRep.findById(companyId);
        if (optional.isPresent()) {
            Company company = optional.get();
            System.out.println("company details: ");
            System.out.println(company);
            return company;
        } else {
            System.out.println("could not find company");
            return null;
        }
    }
}