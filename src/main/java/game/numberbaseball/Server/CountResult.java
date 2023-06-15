package game.numberbaseball.Server;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data; // 롬복 활용
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class CountResult {

  int strike = 0;
  int ball = 0;
  int out = 0;

}
