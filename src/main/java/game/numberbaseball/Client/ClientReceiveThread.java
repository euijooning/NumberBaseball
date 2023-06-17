package game.numberbaseball.Client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientReceiveThread implements Runnable {

  private Socket mSocket;
  ViewController viewController;

  public ClientReceiveThread(ViewController viewController) {
    this.viewController = viewController;
  }

  // 서버가 보낸 스트라이크 볼을 가지고 화면 다시 그리기
  @Override
  public void run() {
    try {
      System.out.println(Thread.currentThread().getName()); // 현재 쓰레드명 출력
      BufferedReader reader = new BufferedReader(new InputStreamReader(mSocket.getInputStream()));
      String receiveString;

      while(true) {
        receiveString = reader.readLine();

        if(receiveString == null) {
          System.out.println("프로그램을 종료합니다.");
          break;
        }
        else {
          System.out.println(receiveString);
          viewController.setGameBoardData(new ClientCountResult(receiveString));
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
  }

}