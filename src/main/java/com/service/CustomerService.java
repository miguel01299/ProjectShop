package com.service;

import java.awt.print.Pageable;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import com.entity.Customer;
import com.registration.CustomerRegistration;
import com.repository.CustomerRepository;

import java.util.Optional;


@Service
public class CustomerService implements ICustomerService{
 
	//Dependency injection
	@Autowired
	private CustomerRepository customerRepo;
	
	
	@Override
	public Customer create(Customer customer) {
		// TODO Auto-generated method stub
		return customerRepo.save(customer);
	}

	@Override
	public Customer update(Customer customer) {
		// TODO Auto-generated method stub
		return customerRepo.save(customer);
	}

	@Override
	public Customer findById(Integer id) {
		// TODO Auto-generated method stub
		Optional <Customer> customerOptional= customerRepo.findById(id);
		Customer customer = null;
	    if (customerOptional.isPresent()) {
	        customer = customerOptional.get();
	    } else {
	        throw new RuntimeException(" Customer not found for id : " + id);
	    }
	    return customer;
	}

	@Override
	public List<Customer> findAll() {
		// TODO Auto-generated method stub
		//Here it gives me an error
		return (List<Customer>) customerRepo.findAll();
		
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		customerRepo.deleteById(id);
		
	}

	@Override
	public Page<Customer> findPaginated(int pageNo, int pageSize) {
	 PageRequest pageable = PageRequest.of(pageNo - 1, pageSize);
	 return this.customerRepo.findAll(pageable);
	}

	@Override
	public Customer save(CustomerRegistration registration) {
		//check
		Customer customer= new Customer(0, registration.getName(),registration.getSurname(),registration.getBirthsday(),registration.getEmail(),registration.getPassword(), "role", null, null, null);
		return customerRepo.save(customer);
	}
	
	

}
