package game.numberbaseball.Client;

import java.io.IOException;
import java.net.Socket;

public class MainClient {  //main client

  public static void main(String[] args) {
    try {
      System.out.println(Thread.currentThread().getName()); // 현재 쓰레드명 출력
      Socket cSocket = new Socket("localHost", 8102);

      ViewController viewController = new ViewController();
      ClientReceiveThread rThread = new ClientReceiveThread(viewController);
      // 이렇게 하면 viewController와 MainClient에서의 viewController가 똑같은 객체를 가리킴
      viewController.init(rThread); // 조립하게 만들기

      rThread.setSocket(cSocket);
      Thread cThread = new Thread(rThread);
      cThread.start();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}