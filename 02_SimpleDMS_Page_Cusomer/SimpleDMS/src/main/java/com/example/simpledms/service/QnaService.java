package com.example.simpledms.service;

import com.example.simpledms.model.Qna;
import com.example.simpledms.repository.QnaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * packageName : com.example.simpledms.service
 * fileName : QnaService
 * author : gangsubin
 * date : 2022/11/09
 * description :
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2022/11/09         gangsubin          최초 생성
 */
@Service
public class QnaService {

    @Autowired
    QnaRepository qnaRepository;

    //    전체 조회 함수
//    페이징 처리 추가. findAll -> findAll(Pageable pageable)
    public Page<Qna> findAll(Pageable pageable) {
        Page<Qna> page = qnaRepository.findAll(pageable);
        return page;
    }
    //   부서 정보 저장/수정 함수
    public Qna save(Qna qna) {

        Qna qna2 = qnaRepository.save(qna);

        return qna2;
    }

    //    부서번호로 조회하는 함수
    public Optional<Qna> findById(int qno) {
//        findById(기본키속성)
        Optional<Qna> optionalQna = qnaRepository.findById(qno);

        return optionalQna;
    }

    public boolean removeById(int qno) {
//        existsById(기본키) 있으면 삭제 실행 + true 리턴
        if(qnaRepository.existsById(qno) == true) {
            qnaRepository.deleteById(qno);
            return true;
        }

//        없으면 그냥 false 리턴
        return false;
    }

    //    question(질문) like 검색 함수 ( 페이징 처리 )
    public Page<Qna> findAllByQuestionContaining(String question, Pageable pageable) {
        Page<Qna> page = qnaRepository.findAllByQuestionContaining(question, pageable);

        return page;
    }

    //    questioner(질문자) like 검색 함수 ( 페이징 처리 )
    public Page<Qna> findAllByQuestionerContaining(String questioner, Pageable pageable) {
        Page<Qna> page = qnaRepository.findAllByQuestionerContaining(questioner, pageable);

        return page;
    }

}
