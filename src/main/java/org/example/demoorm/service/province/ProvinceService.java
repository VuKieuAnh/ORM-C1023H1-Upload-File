package org.example.demoorm.service.province;

import org.example.demoorm.model.DTO.CountCustomer;
import org.example.demoorm.model.DTO.CountNumberCustomer;
import org.example.demoorm.model.entity.Province;
import org.example.demoorm.repo.ProvinceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProvinceService implements IProvinceService {
    @Autowired
    private ProvinceRepo provinceRepo;
    @Override
    public Iterable<Province> findAll() {
        return provinceRepo.findAll();
    }

    @Override
    public void save(Province province) {
        provinceRepo.save(province);
    }

    @Override
    public Province findById(Long id) {
        return provinceRepo.findById(id).get();
    }

    @Override
    public void deleteById(Long id) {
//        service cua kha hang
//        -> khong co transtraction
        provinceRepo.deleteByFindId(id);
    }

    @Override
    public Iterable<CountCustomer> countCustomer() {
        return provinceRepo.countByName();
    }

    public Iterable<CountNumberCustomer> countCustomer1(){
        return provinceRepo.countCustomer();
    }
}
