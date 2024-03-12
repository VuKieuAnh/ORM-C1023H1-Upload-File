package org.example.demoorm.repo.customer;

import org.example.demoorm.model.entity.Customer;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface ICustomerRepo extends PagingAndSortingRepository<Customer, Long> {
}
//Chuyen sang dung repo co san
//Khong chua phan thuc thi
