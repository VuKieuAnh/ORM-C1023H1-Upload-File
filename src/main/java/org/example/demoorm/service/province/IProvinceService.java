package org.example.demoorm.service.province;

import org.example.demoorm.model.Province;

public interface IProvinceService {
    Iterable<Province> findAll();
    void save(Province province);
//    Province findById(Long id);
    void deleteById(Long id);
}
