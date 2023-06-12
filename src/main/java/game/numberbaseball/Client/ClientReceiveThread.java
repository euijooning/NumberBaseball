package game.numberbaseball.Client;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientReceiveThread implements Runnable, ActionListener {

  private Socket mSocket;
  PrintWriter sendWriter;
  ViewController viewController;
  ClientNumberValidator clientNumberValidator = new ClientNumberValidator();

  public ClientReceiveThread(ViewController viewController) {
    this.viewController = viewController;
  }

  // 서버가 보낸 스트라이크 볼을 가지고 화면 다시 그리기
  @Override
  public void run() {
    try {
      System.out.println(Thread.currentThread().getName()); // 현재 쓰레드명 출력
      BufferedReader tempbuf = new BufferedReader(new InputStreamReader(mSocket.getInputStream()));
      String receiveString;

      while(true) {
        receiveString = tempbuf.readLine();

        if(receiveString == null) {
          System.out.println("프로그램을 종료합니다.");
          break;
        }
        else {
          System.out.println(receiveString);
          viewController.setGameBoardData(Character.getNumericValue(receiveString.charAt(0)), Character.getNumericValue(receiveString.charAt(1)), Character.getNumericValue(receiveString.charAt(2)));
          viewController.repaint();
        }
      }
    } catch(IOException e) {
      e.printStackTrace();
    }
    System.exit(0);
  }

  public void setSocket(Socket socket) {
    mSocket = socket;

    try {
      sendWriter = new PrintWriter(mSocket.getOutputStream());
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  //서버 -> 데이터 전송
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