package th.ac.ku.atm.service;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;
import th.ac.ku.atm.model.Customer;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerService {
    private final List<Customer> customers = new ArrayList<>();

    public void createCustomer(Customer customer) {
        String hashedPin = hash(customer.getPin());
        customer.setPin(hashedPin);
        customers.add(customer);
    }

    public List<Customer> getCustomers() {
        return new ArrayList<>(customers);
    }

    private String hash(String pin) {
        String salt = BCrypt.gensalt(12);
        return BCrypt.hashpw(pin, salt);
    }
}
