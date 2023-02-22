/*eslint-disable*/
import "./App.css";
import React, { useState } from "react";

function App() {
  // let posts = '강남고기맛집';

  let [title, titleChange] = useState([
    "남자 코트 추천",
    "강남 우동 맛집",
    "부산 맛집 추천",
    "비올 때 먹고싶은 음식",
  ]);
  let [count, countChange] = useState([0,0,0,0]);
  //[state데이터 ,state 데이터 변경 함수] ES6 신문법
  // state 데이터 변경 함수 = 대체할 데이터

  let[modal, setModal] = useState(false);

  function 제목바꾸기() {
    var newArray = [...title];
    //deep copy =[...변수명]; <- ... = 괄호를 벗기고 다시 씌워주세요 (독립적인 화살표가 됨)
    //deep copy : 값공유가 없이 서로 독립적인 값을 가지는 복사
    //수정된[데이터]를 만듦 -> state의 복사본을 만들어서 수정해야함 (deep copy 해야함)
    newArray[0] = "여자 코트 추천";
    titleChange(newArray);
  }

  function Article(props) {
    return (
      <article>
        <h2>{props.title}</h2>
        {props.body}
      </article>
    );
  }
  return (
    //return 소괄호 안에는 div 한개만 들어갈 수 있음 /여려개를 넣고싶으면 큰 div 안에 넣으면 됨
    <div className="App">
      <div className="black-nav">
        <div>개발 blog</div>
      </div>
      <button onClick={제목바꾸기}>버튼</button>
      {/* <div className="list">
        <h3 onClick={()=> {setModal(!modal)}}>
          {title[0]}{" "}
          <span
            onClick={() => {
              countChange(count + 1);
            }}
          >
            👍🏻
          </span>{" "}
          {count}{" "}
        </h3>
        <p> 2월 2일 발행</p>
        <hr />
      </div> */}
      {/* <div className="list">
        <h3 onClick={()=> {setModal(!modal)}}>{title[1]}</h3>
        <p> 2월 3일 발행</p>
        <hr />
      </div>
      <div className="list">
        <h3 onClick={()=> {setModal(!modal)}}>{title[2]}</h3>
        <p> 2월 4일 발행</p>
        <hr />
      </div> */}
      {
        // 조건식 ? 참일때 실행할코드 : 거짓일 때 실행할 코드 
        modal == true ? <Modal/> : null // 모달값이 true면 모달 보여주고 아니면 보여주지마
      }
      { //같은 html 반복생성 (i = 0 부터 1 씩 증가함 )
         title.map(function(item , i){
          return   <div className="list" key = {i}>
          <h3 onClick={()=> {setModal(!modal)}}>{title[i]}  
          <span onClick={() => { 
            let copy = [...count];
            copy[i] = copy[i] + 1 ; 
            countChange(copy)}
          }> 👍🏻 </span>{" "} {count[i]}{" "}</h3>
          {/* <h3 onClick={()=> {setModal(!modal)}}>{item}</h3>  */ //위와 같은것임 
         }
          <p> 2월 4일 발행</p>
          <hr />
        </div>
        })
      }
      <Article title="맛집검색" body="부산시 맛집추천"></Article>
    </div>
  );
}
//component 만드는법  1)함수 이름짓기 2)축약을 원하는 HTML넣기 3)원하는곳에서 <함수명/>
//return 내부를 묶을때 의미없는 div 쓰기싷다면 <> </> 사용
function Modal() {
  return (
    <>
      <div className="modal">
        <h2>제목</h2>
        <p>날짜</p>
        <p>상세내용</p>
      </div>
    </>
  );
}

export default App;
