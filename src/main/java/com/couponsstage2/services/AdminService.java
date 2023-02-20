package com.couponsstage2.services;

import com.couponsstage2.enteties.Company;
import com.couponsstage2.enteties.Customer;
import com.couponsstage2.exceptions.CouponsExceptions;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class AdminService extends ClientService {

    private final static String emailA = "admin@admin.com";
    private final static String passwordA = "admin";

    @Override
    public boolean login(String email, String password) {
        if (email == emailA && password == passwordA) {
            System.out.println("user admin returned true");
            return true;
        } else {
            System.out.println("email or password are not correct");
            System.out.println("return false to login method");
            return false;
        }
    }

    // TODO: 19/02/2023 add exceptions 
    public void addCompany(Company company) throws CouponsExceptions {
        if (this.companiesRep.findByEmailAndPassword(company.getEmail(), company.getPassword()).isPresent()) {
            //throw new CouponsExceptions("company is already in the database");
            System.out.println(company.getName() + " " + company.getId() + " is already in the database");
        } else {
            companiesRep.save(company);
            System.out.println("company saved");
        }
    }

    public void updateCompany(Company company) { //v
        if (companiesRep.findById(company.getId()).isPresent()) {
            companiesRep.save(company);
            System.out.println("company updated");
        } else {
            System.out.println("failed to update");
        }
    }


    public List<Company> getAllCompanies() { //v
        return companiesRep.findAll();
    }

    public void addCustomer(Customer customer) { //v
        if (customerRep.existsById(customer.getId())) {
            System.out.println("customer " +customer.getFirstName() +" already exist");
            return;
        }
        customerRep.save(customer);
        System.out.println("customer" + customer.getFirstName() + " saved");
    }

    public void updateCustomer(Customer customer) throws CouponsExceptions { //v
        if (customerRep.existsById(customer.getId())) {
            customerRep.save(customer);
            System.out.println(customer.getFirstName() + " updated");
        } else throw new CouponsExceptions("could not be updated");
    }


    public void deleteCompany(int companyId) { //v
        if (companiesRep.existsById(companyId)) {
            companiesRep.deleteById(companyId);
            System.out.println("company " + companyId + " deleted");
        } else {
            System.out.println(" could not not find company - cannot delete");
        }
    }

    // TODO: 20/02/2023 problem with id numbers, mybe because customerVScoupons
    public void deleteCustomer(int customerId) { //vx
        if (companiesRep.existsById(customerId)) {
            customerRep.deleteById(customerId);
            System.out.println("customer " +customerId + " deleted");
        } else {
            System.out.println("did not find customer");

        }
    }

    public List<Customer> getAllCustomers() {  //v
        return customerRep.findAll();
    }

    //correct?
    public Optional<Company> getOneCompany(int companyId) { //v
        if (companiesRep.existsById(companyId)) {
            return companiesRep.findById(companyId);
        } else {
            System.out.println("could not find company " + companyId);
            return null;
        }
    }

    public Optional<Customer> getOneCustomer(int customerId) { //v
        if (companiesRep.existsById(customerId)) {
            return customerRep.findById(customerId);
        } else {
            System.out.println("could not find customer " + customerId);
            return null;
        }
    }
    //-----------------
}