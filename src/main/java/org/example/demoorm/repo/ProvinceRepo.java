package org.example.demoorm.repo;

import org.example.demoorm.model.DTO.CountCustomer;
import org.example.demoorm.model.DTO.CountNumberCustomer;
import org.example.demoorm.model.entity.Province;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface ProvinceRepo extends CrudRepository<Province, Long> {
    @Query(nativeQuery = true, value = "select p.name, count(c.name) as totalOfCustomer from Province p join customer c on p.id = c.province_id group by p.name;")
    Iterable<CountCustomer> countByName();

    @Query(nativeQuery = true, value = "select p.name, count(c.name) as numberCustomer from Province p left join customer c\n" +
            "    on p.id = c.province_id group by p.name;")
    Iterable<CountNumberCustomer> countCustomer();
    @Modifying
    @Query(nativeQuery = true, value = "call deleteprovince(:id);")
    void deleteByFindId(@Param("id") Long id);
}
