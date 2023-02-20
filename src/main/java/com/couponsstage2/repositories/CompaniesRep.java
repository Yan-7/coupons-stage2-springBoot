package com.couponsstage2.repositories;

import com.couponsstage2.enteties.Company;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CompaniesRep extends JpaRepository<Company,Integer> {

    Optional<Company> findByEmailAndPassword(String email, String password);

    List<Company> findByEmail (String email);


}
