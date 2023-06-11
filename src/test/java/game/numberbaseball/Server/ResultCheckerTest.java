package game.numberbaseball.Server;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class ResultCheckerTest {

  @Test
  @DisplayName("3스트라이크인 경우")
  void judgeNumber_3strike() {
    // Given
    int[] com = {1, 2, 3};
    int[] user = {1, 2, 3};
    ResultChecker resultChecker = new ResultChecker();

    // When
    resultChecker.judgeNumber(com, user);

    // Then
    Assertions.assertEquals(3, resultChecker.strike);
    Assertions.assertEquals(0, resultChecker.ball);
    Assertions.assertEquals(0, resultChecker.out);
  }

  @Test
  @DisplayName("결과가 Out인 경우")
  void judgeNumber_out() {
    // Given
    int[] com = {1, 2, 3};
    int[] user = {4, 5, 6};
    ResultChecker resultChecker = new ResultChecker();

    // When
    resultChecker.judgeNumber(com, user);

    // Then
    Assertions.assertEquals(0, resultChecker.strike);
    Assertions.assertEquals(0, resultChecker.ball);
    Assertions.assertEquals(1, resultChecker.out);
  }

  @Test
  @DisplayName("3볼인 경우")
  void judgeNumber_3ball() {
    // Given
    int[] com = {1, 2, 3};
    int[] user = {3, 1, 2};
    ResultChecker resultChecker = new ResultChecker();

    // When
    resultChecker.judgeNumber(com, user);

    // Then
    Assertions.assertEquals(0, resultChecker.strike);
    Assertions.assertEquals(3, resultChecker.ball);
    Assertions.assertEquals(0, resultChecker.out);
  }

  @Test
  @DisplayName("스트라이크와 볼이 함께 있는 경우")
  void judgeNumber_strikeAndBallBoth() {
    // Given
    int[] com = {1, 5, 9};
    int[] user = {5, 7, 9};
    ResultChecker resultChecker = new ResultChecker();

    // When
    resultChecker.judgeNumber(com, user);

    // Then
    Assertions.assertEquals(1, resultChecker.strike);
    Assertions.assertEquals(1, resultChecker.ball);
    Assertions.assertEquals(0, resultChecker.out);
  }

}