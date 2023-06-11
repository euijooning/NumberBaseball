package game.numberbaseball.Server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class SendThread extends Thread {

  public static final String QUIT_STRING = "quit";
  private Socket mSocket; //main 소켓
  public void run() {
    super.run();
    try {
      BufferedReader tempbuf = new BufferedReader(new InputStreamReader(System.in));
      PrintWriter sendWriter = new PrintWriter(mSocket.getOutputStream());

      String sendString;

      while(true) {
        sendString = tempbuf.readLine(); // blocking
        System.out.println("나 : " + sendString); // 내가 보낸 메시지

        if(sendString.equals(QUIT_STRING)) { // "quit" 을 입력한 경우
          System.out.println("프로그램을 종료합니다.");
          sendString = "quitSignal";
          sendWriter.println(sendString);
          sendWriter.flush();
          break;

        } else {
          sendWriter.println(sendString);
          sendWriter.flush();
        }
      }

      mSocket.close();

    } catch(IOException e) {
      e.printStackTrace();
    }
    System.exit(0);
  }

  public void setSocket(Socket socket) {
    mSocket = socket;
  }
}
