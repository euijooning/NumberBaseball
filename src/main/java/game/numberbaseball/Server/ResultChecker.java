package game.numberbaseball.Server;

// 볼, 스트라이크, 아웃 판별하는 클래스
public class ResultChecker {

  public CountResult judgeNumber(int[] com, int[] user) {
    CountResult cResult = new CountResult();

    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        if (com[i] == user[j]) { // 숫자 같고
          if (i == j) { // 자리까지 같으면
            cResult.strike++;
          }
          else { // 그렇지 않으면
            cResult.ball++;
          }
        }
      }
    }

    if (cResult.strike == 0 && cResult.ball == 0) { // s, b 중에 아무것도 맞는 게 없으면
      cResult.out = 1; // out 처리
    }
    return cResult;
  }

}
