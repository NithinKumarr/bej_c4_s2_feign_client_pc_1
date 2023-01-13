
package com.niit.Customer.service;
import com.niit.Customer.domain.User;
import com.niit.Customer.exception.UserAlreadyExistException;
import com.niit.Customer.exception.UserNotFoundException;
import com.niit.Customer.proxy.UserProxy;
import com.niit.Customer.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CustomerServiceImpl implements CustomerService {

    CustomerRepository customerRepository;
    UserProxy userProxy;
@Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository, UserProxy userProxy) {
        this.customerRepository = customerRepository;
        this.userProxy = userProxy;
    }
//    @Override
//    public User addCustomer(User user) throws UserAlreadyExistException {
//    if (customerRepository.findById(user.getEmail()).isEmpty()){
//        User user1 =customerRepository.save(user);
//        return user1;
//    }
//        throw new UserAlreadyExistException();
//    }
    @Override
    public User addCustomer(User user) throws UserAlreadyExistException {
        if (customerRepository.findById((user.getEmail())).isEmpty()){
            userProxy.add(user);
            User user1 =customerRepository.save(user);
            return user1;
        }
        throw new UserAlreadyExistException();
    }
    @Override
    public List<User> getAll() {
        return customerRepository.findAll();
    }
//    @Override
//    public String deleteCustomer(Integer customerId) throws UserNotFoundException {
//        if (customerRepository.findById(customerId).isEmpty()){
//            throw new UserNotFoundException();
//        }
//       customerRepository.deleteById(customerId);
//        return "Deleted Successfully";
//    }
    @Override
    public List<User> getAllTheDetailsWhoHaveBoughtSamsung(String productName) {
        return customerRepository.getAllTheDetailsWhoHaveBoughtSamsung(productName);
    }
}
