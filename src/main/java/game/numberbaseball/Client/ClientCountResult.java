package game.numberbaseball.Client;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class ClientCountResult {

  int strike = 0;
  int ball = 0;
  int out = 0;

  public ClientCountResult(String result) {
    this.strike = Character.getNumericValue(result.charAt(0));
    this.ball = Character.getNumericValue(result.charAt(1));
    this.out = Character.getNumericValue(result.charAt(2));
  }
}
