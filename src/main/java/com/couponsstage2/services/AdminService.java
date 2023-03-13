package com.couponsstage2.services;

import com.couponsstage2.enteties.Company;
import com.couponsstage2.enteties.Customer;
import com.couponsstage2.exceptions.CouponException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class AdminService extends ClientService {

    private final static String emailA = "admin@admin.com";
    private final static String passwordA = "admin";

    // TODO: 28/02/2023 is the login method needed, why do i need boolean? 
    @Override
    public boolean login(String email, String password) {
        if (email == emailA && password == passwordA) {
            System.out.println("user admin logged in");
            return true;
        } else {
            System.out.println("email or password are not correct");
            System.out.println("return false to login method");
            return false;
        }
    }

    // TODO: 28/02/2023 those damm exceptions are crashing the app. 

    public void addCompany(Company company) throws CouponException {
        company.setId(0);
        if (this.companiesRep.findByEmailAndPassword(company.getEmail(), company.getPassword()).isPresent()) {
            throw new CouponException("company is already in the database");
//            System.out.println(company.getName() + " ,id: " + company.getId() + " is already in the database, cannot add again");

        } else {
            companiesRep.save(company);
            System.out.println("company saved");
        }
    }

    public void updateCompany(Company company) throws CouponException { //v
        if (companiesRep.findById(company.getId()).isPresent()) {
            companiesRep.save(company);
            System.out.println("company updated");
        } else {
            throw new CouponException("failed to update");
//            System.out.println("failed to update");
        }
    }


    public List<Company> getAllCompanies() { //v
        return companiesRep.findAll();
    }

    public void addCustomer(Customer customer) throws CouponException { //v
        if (customerRep.existsById(customer.getId())) {
            throw new CouponException("customer " +customer.getFirstName() +" already exist");
//            System.out.println("customer " +customer.getFirstName() +" already exist");
//            return;
        }
        customerRep.save(customer);
        System.out.println("customer" + customer.getFirstName() + " saved");
    }

    public void updateCustomer(Customer customer) throws CouponException { //v
        if (customerRep.existsById(customer.getId())) {
            customerRep.save(customer);
            System.out.println(customer.getFirstName() + " updated");
        } else throw new CouponException("could not be updated");
    }


    public void deleteCompany(int companyId) throws CouponException { //v
        if (companiesRep.existsById(companyId)) {
            companiesRep.deleteById(companyId);
            System.out.println("company " + companyId + " deleted");
        } else {
            throw new CouponException(" could not not find company - cannot delete");
//            System.out.println(" could not not find company - cannot delete");
        }
    }

    public void deleteCustomer(int customerId) throws CouponException { //vx
        if (companiesRep.existsById(customerId)) {
            customerRep.deleteById(customerId);
            System.out.println("customer " +customerId + " deleted");
        } else {
//            System.out.println("did not find customer");
            throw new CouponException("did not find customer");
        }
    }

    public List<Customer> getAllCustomers() {  //v
        return customerRep.findAll();
    }

    //correct?
    public Optional<Company> getOneCompany(int companyId) throws CouponException { //v
        if (companiesRep.existsById(companyId)) {
            return companiesRep.findById(companyId);
        } else {
            throw new CouponException("could not find company " + companyId);
//            System.out.println("could not find company " + companyId);
//            return null;
        }
    }

    public Optional<Customer> getOneCustomer(int customerId) throws CouponException { //v
        if (companiesRep.existsById(customerId)) {
            return customerRep.findById(customerId);
        } else {
            throw new CouponException("could not find customer " + customerId);
//            System.out.println("could not find customer " + customerId);
//            return null;
        }
    }
    //-----------------
}