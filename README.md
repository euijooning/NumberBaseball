# ![image](https://github.com/euijooning/NumberBaseball/assets/49093239/803399e1-ff5a-43cd-bc0f-fb54a1687975)숫자 야구 게임(NumberBaseball)


<div>
<img src="https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FbxPjvq%2Fbtsknvzrv2g%2FOovugdfpImYi1Pg0FZWsv1%2Fimg.png" style="width: 390px;">
</div>

<br>

<p>
<span style="font-size: 20px; font-weight: bold;">⚾자바 GUI와 TCP 통신을 이용한 숫자야구 게임입니다.
</p>
<br>

## ⚾ 게임 규칙 <br>
📢 클라이언트가 3자리 숫자를 입력한다. <br>

📢 일치 여부에 따라 B, S, O의 개수가 화면에 표시된다.
  - 숫자 일치 & 자리 불일치 : Ball
  - 숫자 & 자리 일치 : Strike
  - 숫자 모두 불일치 : OUT <br>

📢 3개의 Strike가 되면 HomeRun이 되며 프로그램이 종료된다.    

<br>

## ⚾ 시연 영상 <br>
📺 https://youtu.be/M7vqkyJ9CDE

<br>
---

## 📋 프로젝트 개요 <br>
### 🚀 기획 의도
- Socket을 통한 TCP 통신의 활용
- Thread를 사용한 프로세스 처리
- 자바 GUI를 통한 화면 구현
- 많은 리팩토링 등을 통한 클린 코드 구현

### 🚀 제작 인원
- 1인 프로젝트

### 🚀 프로젝트 기간
- 2023.06.06 ~ 2023.06.18

<br>

---
## 📋 커밋 규칙

### 🔑 Commit Type
- [feat] : 새로운 기능 추가<br>
- [fix]: 버그 수정<br>
- [docs] : 문서 수정<br>
- [refactor] : 코드 리팩토링<br>
- [test] : 테스트 코드 추가<br>
- [rename] : 파일, 변수, 메서드, 폴더명 등을 수정하는 경우<br>
- [remove] : 파일 혹은 폴더 삭제 작업

<br>

---

## 📋 주요 기능
✅ 숫자 입력 시 화면에 결과 판별.<br>
✅ 잘못된 입력(세 자리가 아닌 경우, 문자가 낀 경우, 숫자 중복 입력) 시 오류 메시지 출력 후 재진행<br>
✅ 콘솔을 통한 채팅<br>
