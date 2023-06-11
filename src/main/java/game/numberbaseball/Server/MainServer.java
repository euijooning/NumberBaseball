package game.numberbaseball.Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;

public class MainServer {		// main server

  public static void main(String[] args) {

    int[] com = ComRandomizer.generateRandomNumbers();
    ResultChecker checker = new ResultChecker();
    System.out.println(Arrays.toString(com));

    try {
      ServerSocket sSocket = new ServerSocket(8102);
      Socket cSocket = sSocket.accept();

      ServerReceiveThread serverReceiveThread = new ServerReceiveThread();
      System.out.println(Thread.currentThread().getName()); // 현재 쓰레드명 출력
      serverReceiveThread.setSocket(cSocket);
      serverReceiveThread.setRandomNumber(com);
      serverReceiveThread.setUserNumber(checker);

      // 채팅용 Thread
      SendThread sendThread = new SendThread();
      System.out.println(Thread.currentThread().getName()); // 현재 쓰레드명 출력
      sendThread.setSocket(cSocket);
      serverReceiveThread.start();
      sendThread.start();
    }
    catch(IOException e) {
      e.printStackTrace();
    }
  }

}
