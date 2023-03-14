package com.couponsstage2.services;

import com.couponsstage2.enteties.Category;
import com.couponsstage2.enteties.Company;
import com.couponsstage2.enteties.Coupon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
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
            System.out.println("company " + company.getName() + " Login successful");
            return true;
        }
        // TODO: 28/02/2023 when email is incorrect this message does not apear:
        System.out.println("could not login");
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


    public void updateCoupon(Coupon coupon) { //v
        if (couponsRep.existsById(coupon.getId())) {
            this.couponsRep.save(coupon);
            System.out.println("coupon " + coupon.getId() + " updated to repository");
        } else {
            System.out.println("coupon not found, could not update coupon");
        }
    }

    public void deleteCoupon(int couponId) { //v
        if (couponsRep.existsById(couponId)) {
            couponsRep.deleteById(couponId);
            System.out.println("coupon " + couponId + " deleted");
        }
    }

    public List<Coupon> getCompanyCoupons() { //v
        List<Coupon> companyCoupons = couponsRep.findByCompanyId(companyId);
        if (!companyCoupons.isEmpty()) {
            System.out.println("list of all company coupons:");
            return companyCoupons;
        } else {
            System.out.println("could not find coupons");
            return null;
        }
    }

    public List<Coupon> getCompanyCouponsByCategory(Category category) { //v
        List<Coupon> companyCoupons = getCompanyCoupons();
        List<Coupon> companyCoupons2 = new ArrayList<>();
        if (!companyCoupons.isEmpty()) {
            System.out.println("company coupons by category: " + category);
            return companyCoupons;
        }

        System.out.println("could not find coupons by category " + category);
        return null;

    }

    public List<Coupon> getCompanyCouponsByMaxPrice(double maxPrice) { //v
        List<Coupon> companyCoupons = getCompanyCoupons();
        if (!companyCoupons.isEmpty()) {
            List<Coupon> companyCoupons2 = new ArrayList<>();
            for (Coupon c : companyCoupons) {
                if (c.getPrice() <= maxPrice) {
                    companyCoupons2.add(c);
                }
            }

            if (!companyCoupons2.isEmpty()) {
                System.out.println("list of coupons by max price " + maxPrice);
                System.out.println(companyCoupons2);
                return companyCoupons2;
            }
        }
        System.out.println("could not find coupons by company id: " + companyId + "and max price: " + maxPrice);
        return null;
    }

    public Company getCompanyDetails() { //v
        Optional<Company> optional = companiesRep.findById(companyId);
        if (optional.isPresent()) {
            Company company = optional.get();
            System.out.println("company details: ");
            return company;
        } else {
            System.out.println("could not find company");
            return null;
        }
    }
}