package game.numberbaseball.Client;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

//화면을 담당하는 부분 클래스 분리
public class ViewController {

  GameBoard gameBoard;
  JFrame frame;
  JTextField textField;
  JTextArea errorMessageArea;
  JButton button;

  public void init(Socket socket) throws IOException {

    textField = new JTextField(15);

    errorMessageArea = new JTextArea();
    errorMessageArea.setLocation(30, 50);

    button = new JButton("입력");
    InputListener inputListener = new InputListener(new PrintWriter(socket.getOutputStream()), this);
    button.addActionListener(inputListener);
    button.setFont(new Font("맑은 고딕",Font.BOLD,18));

    gameBoard = new GameBoard();
    gameBoard.setBackground(Color.BLACK);
    gameBoard.setSize(500, 500);
    gameBoard.add(textField);
    gameBoard.add(errorMessageArea);
    gameBoard.add(button);

    frame = new JFrame();
    Container container = frame.getContentPane();
    container.setSize(500, 500);
    container.setLayout(new BorderLayout());
    container.add(gameBoard);

    frame.setSize(600,600);
    frame.setVisible(true);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }

  public void setGameBoardData(int numericValue1, int numericValue2, int numericValue3) {
    this.gameBoard.setData(numericValue1, numericValue2, numericValue3);
  }

  public String getTextFieldValue() {
    return this.textField.getText();
  }

  public void setErrorMessage(String message) {
    this.errorMessageArea.setText(message);
  }

  public void repaint() {
    this.frame.repaint();
  }
}
