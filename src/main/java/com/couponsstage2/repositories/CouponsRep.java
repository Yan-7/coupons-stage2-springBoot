package com.couponsstage2.repositories;

import com.couponsstage2.enteties.Coupon;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CouponsRep extends JpaRepository<Coupon,Integer> {

}
