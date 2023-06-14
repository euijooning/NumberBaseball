package game.numberbaseball.Server;

import lombok.Data; // 롬복 활용
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
public class CountResult {

  int strike = 0;
  int ball = 0;
  int out = 0;

  public CountResult() {
  }
}
