package game.numberbaseball.Server;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;


class ComRandomizerTest {

  @RepeatedTest(value = 10) //추출의 정확도 확인을 위해 10번 반복 설정
  @DisplayName("랜덤 수 추출과정 반복 테스트")
  void generateRandomNumbers() {
    int[] rNumbers = ComRandomizer.generateRandomNumbers();

    assertThat(rNumbers[0] != rNumbers[1]).isTrue();
    assertThat(rNumbers[0] != rNumbers[2]).isTrue();
    assertThat(rNumbers[1] != rNumbers[2]).isTrue();
  }
}