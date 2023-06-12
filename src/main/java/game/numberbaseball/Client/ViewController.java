package game.numberbaseball.Client;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.text.JTextComponent;

//화면을 담당하는 부분 클래스 분리
public class ViewController extends JFrame {

  GameBoard gameBoard;
  JTextField textField;
  JTextArea errorMessageArea;
  JTextPane errorPane;
  JTextComponent errorTextComponent;
  JButton button;

  public void init(ClientReceiveThread rThread) {
    Container container = getContentPane();
    container.setSize(500, 500);
    container.setLayout(new BorderLayout());

    gameBoard = new GameBoard();
    gameBoard.setBackground(Color.BLACK); // 게임 결과판 배경 검정색
    gameBoard.setSize(500, 500);

    textField = new JTextField(15);
    gameBoard.add(textField);

    errorMessageArea = new JTextArea();
    errorMessageArea.setLocation(30, 50);
    gameBoard.add(errorMessageArea);

    button = new JButton("입력");
    button.addActionListener(rThread);
    button.setFont(new Font("맑은 고딕",Font.BOLD,18));
    gameBoard.add(button);

    container.add(gameBoard);

    setSize(600,600);
    setVisible(true);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
}
