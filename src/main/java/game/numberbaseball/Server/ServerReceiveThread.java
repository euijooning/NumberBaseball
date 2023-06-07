package game.numberbaseball.Server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ServerReceiveThread extends Thread {

  private Socket mSocket;
  private int[] com;
  private ResultChecker checker;

  public void run() {
    super.run();

    try {
      System.out.println(Thread.currentThread().getName()); // 현재 쓰레드명 출력
      BufferedReader tempbuf = new BufferedReader(new InputStreamReader(mSocket.getInputStream()));
      PrintWriter sendWriter = new PrintWriter(mSocket.getOutputStream());

      String receiveString;

      while(true) {
        receiveString = tempbuf.readLine();
        System.out.println(receiveString);

        if(receiveString == null) {
          System.out.println("프로그램을 끝냅니다.");
          break;
        }
        else {
          System.out.println(receiveString);
          int num1 = receiveString.charAt(0)-'0';
          int num2 = receiveString.charAt(1)-'0';
          int num3 = receiveString.charAt(2)-'0';
          int[] user = {num1, num2, num3};

          checker.judgeNumber(com, user);
          sendWriter.println(checker.getValue());
          sendWriter.flush();
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

  public void setRandomNumber(int[] comRandomNumber) {
    this.com = comRandomNumber;
  }

  public void setUserNumber(ResultChecker userInputNumber) {
    this.checker = userInputNumber;
  }
}
