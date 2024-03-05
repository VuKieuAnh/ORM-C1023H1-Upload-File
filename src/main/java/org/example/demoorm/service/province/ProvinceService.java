package org.example.demoorm.service.province;

import org.example.demoorm.model.Province;
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

//    @Override
//    public Province findById(Long id) {
//        return provinceRepo.findById(id).get();
//    }

    @Override
    public void deleteById(Long id) {
        provinceRepo.deleteById(id);
    }
}
