package java.numberbaseball.Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;

public class MainServer {		// main server

  public static void main(String[] args) {

    ComRandomizer randomizer = new ComRandomizer();
    ResultChecker checker = new ResultChecker();
    System.out.println(Arrays.toString(randomizer.com));

    try {
      ServerSocket sSocket = new ServerSocket(8102);
      Socket cSocket = sSocket.accept();

      ServerReceiveThread serverReceiveThread = new ServerReceiveThread();
      serverReceiveThread.setSocket(cSocket);
      serverReceiveThread.setRandomNumber(randomizer.com);
      serverReceiveThread.setUserNumber(checker);

      // 채팅용 Thread
      SendThread sendThread = new SendThread();
      sendThread.setSocket(cSocket);
      serverReceiveThread.start();
      sendThread.start();
    }
    catch(IOException e) {
      e.printStackTrace();
    }
  }

}
