package game.numberbaseball.Client;

import java.io.IOException;
import java.net.Socket;

public class MainClient {  //main client

  public static void main(String[] args) {
    try {
      System.out.println(Thread.currentThread().getName()); // 현재 쓰레드명 출력
      Socket cSocket = new Socket("localHost", 8102);
      ClientReceiveThread rThread = new ClientReceiveThread();
      rThread.setSocket(cSocket);
      Thread t = new Thread(rThread);
      t.start();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}