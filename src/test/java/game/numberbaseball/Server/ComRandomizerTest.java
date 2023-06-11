package game.numberbaseball.Server;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.annotation.Repeat;

@ExtendWith(MockitoExtension.class)
class ComRandomizerTest {

  @Repeat(value = 10) //정확도를 위해 10번 반복 설정
  @Test
  @DisplayName("랜덤 수 추출과정 반복 테스트")
  void generateRandomNumbers() {
    int[] rNumbers = ComRandomizer.generateRandomNumbers();

    assertThat(rNumbers[0] != rNumbers[1]).isTrue();
    assertThat(rNumbers[1] != rNumbers[2]).isTrue();
    assertThat(rNumbers[0] != rNumbers[2]).isTrue();
  }
}