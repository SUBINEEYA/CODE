package com.example.simpledms.repository;

import com.example.simpledms.model.Customer;
import com.example.simpledms.model.Emp;
import com.example.simpledms.model.Qna;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * packageName : com.example.simpledms.repository
 * fileName : QnaRepository
 * author : gangsubin
 * date : 2022/11/09
 * description :
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2022/11/09         gangsubin          최초 생성
 */
@Repository
public interface QnaRepository extends JpaRepository<Qna,Integer> {

    Page<Qna> findAllByQuestionerContaining(String questioner, Pageable pageable);

    Page<Qna> findAllByQuestionContaining(String question, Pageable pageable);
}
