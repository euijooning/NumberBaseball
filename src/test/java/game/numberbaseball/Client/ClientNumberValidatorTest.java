package game.numberbaseball.Client;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

// 클라이언트가 입력한 숫자가 조건에 맞는지 여부를 테스트
class ClientNumberValidatorTest {
  ClientNumberValidator validator = new ClientNumberValidator();

  @Test
  @DisplayName("유효한 입력일 때")
  void appropriateInput() {

    String inputNumber = "345";
    boolean isValid = validator.validate(inputNumber);

    assertThat(isValid).isTrue();
  }

  @Test
  @DisplayName("입력한 숫자가 3개가 아닐 때 - 적은 경우")
  void underThree() {

    String inputNumber = "89";
    boolean isValid = validator.validate(inputNumber);

    assertThat(isValid).isFalse();
  }

  @Test
  @DisplayName("입력한 숫자가 3개가 아닐 때 - 많은 경우")
  void overThree() {

    String inputNumber = "56789";
    boolean isValid = validator.validate(inputNumber);

    assertThat(isValid).isFalse();
  }

  @Test
  @DisplayName("중복된 수를 입력했을 때")
  void ifDuplicatedNumbers() {

    String inputNumber = "777";
    boolean isValid = validator.validate(inputNumber);

    assertThat(isValid).isFalse();
  }

  @Test
  @DisplayName("입력에 숫자 아닌 것이 섞여있을 때")
  void testNonNumericCharacters() {

    String input = "91%";
    boolean isValid = validator.validate(input);

    assertThat(isValid).isFalse();
  }

}