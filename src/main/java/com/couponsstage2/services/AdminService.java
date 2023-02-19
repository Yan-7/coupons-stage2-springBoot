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
        if (email == emailA && password ==passwordA) {
            System.out.println("user admin returned true");
            return true;
        } else {
            System.out.println("email or password are not correct");
            System.out.println("return false to login method");
            return false;
        }
    }

    // TODO: 19/02/2023 add exceptions 
    public void addCompany(Company company)  {
        if (this.companiesRep.findByEmailAndPassword(company.getEmail(), company.getPassword()).isPresent()) {
            System.out.println("company is already in the data base");
            } else {
            companiesRep.save(company);
            System.out.println("company saved");
        }
    }

    public void updateCompany(Company company){

    }

    public void deleteCompany(int companyId){}

    public List<Company> getAllCompanies(){
        return companiesRep.findAll();
    }
    //correct?
    public Optional<Company> getOneCompany(int companyId) {
        return companiesRep.findById(companyId);
    }
    public void addCustomer(Customer customer) {
        customerRep.save(customer);
        System.out.println("customer" + customer.getFirstName() +" saved");
    }

    public void updateCustomer(Customer customer) {}

    public void deleteCustomer(int customerId) {
        customerRep.deleteById(customerId);
    }

    public List<Customer> getAllCustomers() {
        return customerRep.findAll();
    }

    public Customer getOneCustomer(int customerId) {
        return customerRep.getReferenceById(customerId);
    }
}
