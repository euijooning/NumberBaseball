package game.numberbaseball.Server;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ResultCheckerTest {
  ResultChecker resultChecker = new ResultChecker();

  @Test
  @DisplayName("3스트라이크인 경우")
  void judgeNumber_3strike() {
    // Given
    int[] com = {1, 2, 3};
    int[] user = {1, 2, 3};

    // When
    CountResult actualResult = resultChecker.judgeNumber(com, user);

    // Then
    CountResult expectedResult = CountResult.builder()
        .strike(3)
        .ball(0)
        .out(0)
        .build();

    assertEquals(expectedResult, actualResult);
  }

  @Test
  @DisplayName("결과가 Out인 경우")
  void judgeNumber_out() {
    // Given
    int[] com = {1, 2, 3};
    int[] user = {4, 5, 6};

    // When
    CountResult actualResult = resultChecker.judgeNumber(com, user);

    // Then
    CountResult expectedResult = CountResult.builder()
        .strike(0)
        .ball(0)
        .out(1)
        .build();

    assertEquals(expectedResult, actualResult);
  }

  @Test
  @DisplayName("3볼인 경우")
  void judgeNumber_3ball() {
    // Given
    int[] com = {1, 2, 3};
    int[] user = {3, 1, 2};

    // When
    CountResult actualResult = resultChecker.judgeNumber(com, user);

    // Then
    CountResult expectedResult = CountResult.builder()
        .strike(0)
        .ball(3)
        .out(0)
        .build();

    assertEquals(expectedResult, actualResult);
  }

  @Test
  @DisplayName("스트라이크와 볼이 함께 있는 경우")
  void judgeNumber_strikeAndBallBoth() {
    // Given
    int[] com = {1, 5, 9};
    int[] user = {5, 7, 9};

    // When
    CountResult actualResult = resultChecker.judgeNumber(com, user);

    // Then
    CountResult expectedResult = CountResult.builder()
        .strike(1)
        .ball(1)
        .out(0)
        .build();

    assertEquals(expectedResult, actualResult);
  }

}