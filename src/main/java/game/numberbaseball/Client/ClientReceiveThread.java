package game.numberbaseball.Client;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class ClientReceiveThread extends JFrame implements ActionListener, Runnable{

  GameBoard gameBoard;
  JTextField textField;
  JButton button;

  private Socket mSocket;
  PrintWriter sendWriter;


  public ClientReceiveThread(){

    Container container = getContentPane();
    container.setLayout(new BorderLayout());

    gameBoard = new GameBoard();
    textField = new JTextField(15);
    gameBoard.add(textField);

    button = new JButton("입력");
    button.addActionListener(this);
    button.setFont(new Font("맑은 고딕",Font.BOLD,18));
    gameBoard.add(button);

    container.add(gameBoard);

    setSize(600,600);

    setVisible(true);

    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
        System.out.println(receiveString);

        if(receiveString == null) {
          System.out.println("프로그램을 종료합니다.");
          break;
        }
        else {
          System.out.println(receiveString);
          gameBoard.setData(Character.getNumericValue(receiveString.charAt(0)),Character.getNumericValue(receiveString.charAt(1)), Character.getNumericValue(receiveString.charAt(2)));
          gameBoard.repaint();
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

  // 서버 -> 데이터 전송
  public void actionPerformed(ActionEvent e) {
    System.out.println(Thread.currentThread().getName()); // 현재 쓰레드명 출력
    sendWriter.println(textField.getText());
    sendWriter.flush();
  }
}
