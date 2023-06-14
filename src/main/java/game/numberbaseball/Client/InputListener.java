package game.numberbaseball.Client;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintWriter;

// 리스닝만 담당하는 클래스 분리
public class InputListener implements ActionListener {

  PrintWriter sendWriter;
  ClientNumberValidator clientNumberValidator = new ClientNumberValidator();
  ViewController viewController;

  public InputListener(PrintWriter printWriter, ViewController viewController) {
    this.sendWriter = printWriter;
    this.viewController = viewController;
  }

  //서버 -> 데이터 전송
  @Override
  public void actionPerformed(ActionEvent e) {
    String clientNumber = viewController.getTextFieldValue();

    if (clientNumberValidator.validate(clientNumber)) {
      viewController.setErrorMessage("");

      sendWriter.println(clientNumber);
      sendWriter.flush();

    } else {
      viewController.setErrorMessage("중복되지 않은 세자리 수를 입력해주세요!");
    }
  }
}
