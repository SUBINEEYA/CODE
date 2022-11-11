package com.example.simpledms.service;

import com.example.simpledms.model.Customer;
import com.example.simpledms.model.Dept;
import com.example.simpledms.model.Emp;
import com.example.simpledms.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * packageName : com.example.simpledms.service
 * fileName : CustomerService
 * author : gangsubin
 * date : 2022/11/08
 * description :
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2022/11/08         gangsubin          최초 생성
 */
@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository; // JPA CRUD 함수가 있는 인터페이스

    //    전체 조회 함수
//    페이징 처리 추가. findAll -> findAll(Pageable pageable)
    public Page<Customer> findAll(Pageable pageable) {
        Page<Customer> page = customerRepository.findAll(pageable);
        return page;
    }
    //   부서 정보 저장/수정 함수
    public Customer save(Customer customer) {

        Customer customer2 = customerRepository.save(customer);

        return customer2;
    }

    //    부서번호로 조회하는 함수
    public Optional<Customer> findById(int cid) {
//        findById(기본키속성)
        Optional<Customer> optionalCustomer = customerRepository.findById(cid);

        return optionalCustomer;
    }

    public boolean removeById(int cid) {
//        existsById(기본키) 있으면 삭제 실행 + true 리턴
        if(customerRepository.existsById(cid) == true) {
            customerRepository.deleteById(cid);
            return true;
        }

//        없으면 그냥 false 리턴
        return false;
    }

    //    dname like 검색 함수
    public Page<Customer> findAllByEmailContaining(String email, Pageable pageable) {
        Page<Customer> page = customerRepository.findAllByEmailContaining(email, pageable);

        return page;
    }
}


