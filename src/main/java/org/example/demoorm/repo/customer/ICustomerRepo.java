package org.example.demoorm.repo.customer;

import org.example.demoorm.model.Customer;
import org.example.demoorm.repo.IGenerateRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICustomerRepo extends PagingAndSortingRepository<Customer, Long> {
}
//Chuyen sang dung repo co san
//Khong chua phan thuc thi
