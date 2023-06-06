package java.numberbaseball.Server;

// 볼, 스트라이크, 아웃 판별하는 클래스
public class ResultChecker {

  int strike; // 스트라이크 저장 변수
  int ball; // 볼 저장 변수
  int out; // 아웃 저장 변수

  public void judgeNumber(int[] com, int[] user) {

    strike = 0;
    ball = 0;
    out = 0;

    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        if (com[i] == user[j]) { // 숫자 같고
          if (i == j) { // 자리까지 같으면
            strike++;
          }
          else { // 그렇지 않으면
            ball++;
          }
        }
      }
    }

    if (strike == 0 && ball == 0) { // s, b 중에 아무것도 맞는 게 없으면
      out = 1; // out 처리
    }
  }

  public String getValue() {
    return strike + "" + ball + "" + out;
  }
}
