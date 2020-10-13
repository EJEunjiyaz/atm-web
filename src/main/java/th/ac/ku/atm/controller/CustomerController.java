package th.ac.ku.atm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;

@Controller
public class CustomerController {
    ArrayList<Customer> customers = new ArrayList<>();

    @GetMapping("/customer")
    public String getCustomerPage(Model model) {
        model.addAttribute("allCustomers", customers);
        return "customer";  // customer.html
    }

    @PostMapping("/customer")
    public String registerCustomer(@ModelAttribute Customer customer, Model model) {
        customers.add(customer);
        model.addAttribute("allCustomers", customers);
        return "redirect:customer";
    }
}
