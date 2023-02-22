package com.couponsstage2.services;

import com.couponsstage2.enteties.Category;
import com.couponsstage2.enteties.Company;
import com.couponsstage2.enteties.Coupon;
import com.couponsstage2.enteties.Customer;
import com.couponsstage2.exceptions.CouponsExceptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CompanyService extends ClientService {

    private int companyId;

    @Autowired
    private EntityManager entityManager;

    @Override
    public boolean login(String email, String password) { //v
        Optional<Company> companyOpt = companiesRep.findByEmailAndPassword(email, password);
        if (companyOpt.isPresent()) {
            Company company = companyOpt.get();
            this.companyId = company.getId();
            System.out.println("Login successful - true");
            return true;
        }
        System.out.println("could not login - false");
        return false;
    }




    public void addCouponToCompany(Coupon coupon) { //v
        Optional<Company> optionalCompany = this.companiesRep.findById(coupon.getCompany().getId());
        if (optionalCompany.isPresent()) {
            Company company = optionalCompany.get();
            //        if (coupon.getStartDate().isAfter(LocalDate.now()) && coupon.getEndDate().isBefore(LocalDate.now())) {
            Coupon mergedCoupon = entityManager.merge(coupon); // Reattaches the Coupon object to the current session
            company.addCouponClass(mergedCoupon);
            System.out.println("Coupon " + mergedCoupon.getId() + " was added to company " + company.getId());
        } else {
            System.out.println("Could not add coupon to company");
        }
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
        System.out.println("company id: " +companyId);
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