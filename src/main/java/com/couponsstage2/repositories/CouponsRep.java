package com.couponsstage2.repositories;

import com.couponsstage2.enteties.Coupon;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CouponsRep extends JpaRepository<Coupon,Integer> {



    @Override
    default Coupon getOne(Integer integer) {
        return null;
    }

    @Override
    default void deleteById(Integer integer) {

    }

    @Override
    default <S extends Coupon> S save(S entity) {
        return null;
    }


    @Override
    default Optional<Coupon> findById(Integer integer) {
        return Optional.empty();
    }

    @Override
    default boolean existsById(Integer integer) {
        return false;
    }

    @Override
    default <S extends Coupon> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }
}
