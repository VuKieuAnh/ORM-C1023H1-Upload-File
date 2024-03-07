package org.example.demoorm.service.province;

import org.example.demoorm.model.DTO.CountCustomer;
import org.example.demoorm.model.DTO.CountNumberCustomer;
import org.example.demoorm.model.entity.Province;

public interface IProvinceService {
    Iterable<Province> findAll();
    void save(Province province);
    Province findById(Long id);
    void deleteById(Long id);

    Iterable<CountCustomer> countCustomer();

    Iterable<CountNumberCustomer> countCustomer1();
}
