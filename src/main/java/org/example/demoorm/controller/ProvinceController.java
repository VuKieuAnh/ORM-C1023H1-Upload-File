package org.example.demoorm.controller;

import org.example.demoorm.model.DTO.CountNumberCustomer;
import org.example.demoorm.service.province.IProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/province")
public class ProvinceController {
    @Autowired
    private IProvinceService provinceService;
    @GetMapping()
    public ModelAndView getAll(){
        ModelAndView allP = new ModelAndView("/provice");
        allP.addObject("p", provinceService.countCustomer());
        return allP;
    }

    @GetMapping("/count")
    public ModelAndView count(){
        ModelAndView allP = new ModelAndView("/provicecount");
        Iterable<CountNumberCustomer> p = provinceService.countCustomer1();
        allP.addObject("p", p);
        return allP;
    }
}
