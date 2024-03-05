package org.example.demoorm.controller;

import org.example.demoorm.model.Customer;
import org.example.demoorm.model.CustomerForm;
import org.example.demoorm.service.ICustomerService;
import org.example.demoorm.service.province.IProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/customers")
@PropertySource("classpath:upload_file.properties")
public class CustomerController {

    @Value("${upload}")
    private String upload;
    @Autowired
    private ICustomerService customerService;
    @Autowired
    private IProvinceService provinceService;

    @GetMapping("")
    public String index(Model model, Pageable pageable) {
        Page<Customer> customerList = customerService.findAll(pageable);

        model.addAttribute("customers", customerList);
        return "/index";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("customer", new CustomerForm());
        model.addAttribute("provinces", provinceService.findAll());
        return "/create";
    }

    @PostMapping("/save")
    public String save(CustomerForm customerForm, @RequestParam String province) throws IOException {
//        tai file len
//        lay file
        System.out.println(province);
        MultipartFile file = customerForm.getImg();
//        lay ten
        String nameImg = file.getOriginalFilename();
//        copy file vao trong thu muc
        FileCopyUtils.copy(file.getBytes(), new File(upload+nameImg));
//        luu customer vao db
        Customer customer = new Customer();
        customer.setAddress(customerForm.getAddress());
        customer.setEmail(customerForm.getEmail());
        customer.setName(customerForm.getName());
        customer.setImg(nameImg);
        customer.setProvince(customerForm.getProvince());
        customerService.save(customer);
        return "redirect:/customers";
    }

    @GetMapping("/{id}/edit")
    public String update(@PathVariable Long id, Model model) {
        model.addAttribute("customer", customerService.findById(id));
        return "/update";
    }

    @PostMapping("/update")
    public String update(Customer customer) {
        customerService.save(customer);
        return "redirect:/customers";
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable Long id, Model model) {
        model.addAttribute("customer", customerService.findById(id));
        return "/delete";
    }

    @PostMapping("/delete")
    public String delete(Customer customer, RedirectAttributes redirect) {
        customerService.remove(customer.getId());
        redirect.addFlashAttribute("success", "Removed customer successfully!");
        return "redirect:/customers";
    }

    @GetMapping("/{id}/view")
    public String view(@PathVariable Long id, Model model) {
        model.addAttribute("customer", customerService.findById(id));
        return "/view";
    }
}