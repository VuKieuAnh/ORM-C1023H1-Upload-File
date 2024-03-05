package org.example.demoorm.repo;

import org.example.demoorm.model.Province;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProvinceRepo extends CrudRepository<Province, Long> {
}
