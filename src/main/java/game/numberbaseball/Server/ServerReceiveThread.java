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
      BufferedReader reader = new BufferedReader(new InputStreamReader(mSocket.getInputStream()));
      PrintWriter sendWriter = new PrintWriter(mSocket.getOutputStream());

      String receiveString;

      while(true) {
        receiveString = reader.readLine();

        if(receiveString == null) {
          System.out.println("프로그램을 끝냅니다.");
          break;
        }
        else {
          System.out.println(receiveString);
          int[] user = makeIntArray(receiveString);

          CountResult cResult = checker.judgeNumber(com, user);
          String resultString = cResult.strike + "" + cResult.ball + "" + cResult.out;

          sendWriter.println(resultString);
          sendWriter.flush();
        }
      }
    } catch(IOException e) {
      e.printStackTrace();
    }
    System.exit(0);
  }

  public int[] makeIntArray(String receiveString) {
    int num1 = Character.getNumericValue(receiveString.charAt(0));
    int num2 = Character.getNumericValue(receiveString.charAt(1));
    int num3 = Character.getNumericValue(receiveString.charAt(2));

    int[] userInput = {num1, num2, num3};
    return userInput;
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
