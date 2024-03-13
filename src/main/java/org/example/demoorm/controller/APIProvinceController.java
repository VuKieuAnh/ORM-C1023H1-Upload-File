package org.example.demoorm.controller;

import org.example.demoorm.model.DTO.CountNumberCustomer;
import org.example.demoorm.model.entity.Province;
import org.example.demoorm.service.province.IProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/provinces")
public class APIProvinceController
{
    @Autowired
    private IProvinceService provinceService;
    @GetMapping
    public ResponseEntity<Iterable<Province>> getAllProvince(){
        Iterable<Province> provinces = provinceService.findAll();
        return new ResponseEntity<>(provinces, HttpStatus.OK);
    }

    @GetMapping("/cont")
    public ResponseEntity<Iterable<CountNumberCustomer>> getAllProvinceAndNumber(){
        Iterable<CountNumberCustomer> numberCustomers = provinceService.countCustomer1();
        return new ResponseEntity<>(numberCustomers, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<Province> createNewProvince(@RequestBody Province province){
        provinceService.save(province);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Province> editProvince(@PathVariable Long id,@RequestBody Province province){
        province.setId(id);
        provinceService.save(province);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/{id}")
    public ResponseEntity<Province> deleteById(@PathVariable Long id){
//        goi sẻvice thay doi bankhang hang
//        xoatinh
//        xu ly nghiep vu -> khong dung dung
        provinceService.deleteById(id);


        return new ResponseEntity<>(HttpStatus.OK);
    }
}
