package com.couponsstage2.repositories;

import com.couponsstage2.enteties.Company;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CompaniesRep extends JpaRepository<Company,Integer> {

    Optional<Company> findByEmailAndPassword(String email, String password);
    @Override
    Optional<Company> findById(Integer integer);

    @Override
    default List<Company> findAll() {
        return null;
    }

    @Override
    default <S extends Company> S save(S entity) {
        return null;
    }

    @Override
    default boolean existsById(Integer integer) {
        return false;
    }

    @Override
    default void deleteById(Integer integer) {

    }

}
