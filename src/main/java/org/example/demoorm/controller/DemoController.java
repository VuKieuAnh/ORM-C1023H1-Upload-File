package org.example.demoorm.controller;

import org.example.demoorm.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {
    @Autowired
    private ICustomerService customerService;
    @GetMapping("/demo")
    public String demo(Model model){
//        List<Customer> customers = customerService.findAll();
//        model.addAttribute("c", customers);
        return "index";
    }
}
