package com.couponsstage2.repositories;

import com.couponsstage2.enteties.Category;
import com.couponsstage2.enteties.Coupon;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface CouponsRep extends JpaRepository<Coupon,Integer> {

    List<Coupon> findByCompanyId(int companyId);

    List<Coupon> findByCategoryAndCompanyId(Category category,int companyId);

    List<Coupon> findByPriceAndCompanyId(double maxPrice,int companyId);

    List<Coupon> findByCustomersId(int customerId);
}
