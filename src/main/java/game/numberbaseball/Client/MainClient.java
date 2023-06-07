package game.numberbaseball.Client;

import java.io.IOException;
import java.net.Socket;

public class MainClient {  //main client

  public static void main(String[] args) {
    try {
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