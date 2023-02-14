package com.couponsstage2.repositories;

import com.couponsstage2.enteties.Customer;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public interface CustomerRep extends JpaRepository<Customer,Integer> {

    @Override
    default List<Customer> findAll() {
        return null;
    }

    @Override
    default void flush() {

    }

    @Override
    default <S extends Customer> S save(S entity) {
        return null;
    }

    @Override
    default Optional<Customer> findById(Integer integer) {
        return Optional.empty();
    }

    @Override
    default void deleteById(Integer integer) {

    }

    @Override
    default void deleteAll() {

    }

    @Override
    default <S extends Customer> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    default <S extends Customer> boolean exists(Example<S> example) {
        return false;
    }
}
