package com.example.simpledms.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;

/**
 * packageName : com.example.simpledms.model
 * fileName : Qna
 * author : gangsubin
 * date : 2022/11/09
 * description :
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2022/11/09         gangsubin          최초 생성
 */

@Entity
@Table(name = "TB_QNA")
@SequenceGenerator(
        name= "SQ_QNA_GENERATOR"
        , sequenceName = "SQ_QNA"
        , initialValue = 1
        , allocationSize = 1
)
@Getter
@Setter
@NoArgsConstructor
@DynamicInsert
@DynamicUpdate
// soft delete : 삭제하는 척만 하기 (화면에서는 안보이고, DB는 데이터를 삭제하지 않음)
// 법정 의무 보관 기간을 위해 실제 데이터를 삭제하지 않음
// 사용법 1) @SQLDelete(sql="update문") : delete 문이 실행되지 않고, 매개변수의 update 문이 실행되게함
//       2) @Where(clause="강제조건") : 대상클래스에 @붙이면 sql문 실행 시 강제 조건이 붙어 실행됨
@Where(clause = "DELETE_YN = 'N'")
@SQLDelete(sql="UPDATE TB_QNA SET DELETE_YN = 'Y', DELETE_TIME = TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS') WHERE QNO = ?")
public class Qna extends BaseTimeEntity{


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE
            , generator = "SQ_QNA_GENERATOR"
    )
    private Integer qno;

    @Column(columnDefinition = "VARCHAR2(255)")
    private String question;

    @Column(columnDefinition = "VARCHAR2(255)")
    private String answer;

    @Column(columnDefinition = "VARCHAR2(255)")
    private String questioner;


    @Column(columnDefinition = "VARCHAR2(255)")
    private String answerer;




}
