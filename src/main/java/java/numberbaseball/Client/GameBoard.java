package java.numberbaseball.Client;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JPanel;

public class GameBoard extends JPanel {

  int strike = 0;
  int ball = 0;
  int out = 0;

  void setData(int strike, int ball, int out) {
    this.strike = strike;
    this.ball = ball;
    this.out = out;
  }

  @Override
  public void paintComponent(Graphics g){
    super.paintComponent(g);
    g.setFont(new Font("맑은 고딕",Font.BOLD,20));

    // 스트라이크 경우의 수
    if(strike == 3) { // 홈런
      g.setFont(new Font("맑음고딕",Font.BOLD,60));
      g.drawString("Home Run! 축하합니다!", 30, 180);
    }

    else { // 홈런 아닌 경우
      if(strike == 0) { // 0 strike
        g.setColor(Color.YELLOW);
        g.drawString("S", 30, 222);
        g.drawOval(50,200,30,30);
        g.drawOval(90,200,30,30);
      }
      else if(strike == 1) { // 1 Strike
        g.setColor(Color.YELLOW);
        g.drawString("S", 30, 222);
        g.fillOval(50,200,30,30);
        g.drawOval(90,200,30,30);
      }
      else { // 2 strike
        g.setColor(Color.YELLOW);
        g.drawString("S", 30, 222);
        g.fillOval(50,200,30,30);
        g.fillOval(90,200,30,30);
      }

      // 볼 경우의 수
      if(ball == 0) { // 0 ball
        g.setColor(Color.GREEN);
        g.drawString("B", 30, 262);
        g.drawOval(50,240,30,30);
        g.drawOval(90,240,30,30);
        g.drawOval(130,240,30,30);
      }
      else if(ball == 1) { // 1 ball
        g.setColor(Color.GREEN);
        g.drawString("B", 30, 262);
        g.fillOval(50,240,30,30);
        g.drawOval(90,240,30,30);
        g.drawOval(130,240,30,30);
      }
      else if(ball == 2) { // 2 ball
        g.setColor(Color.GREEN);
        g.drawString("B", 30, 262);
        g.fillOval(50,240,30,30);
        g.fillOval(90,240,30,30);
        g.drawOval(130,240,30,30);
      }
      else { // 3 bakk
        g.setColor(Color.GREEN);
        g.drawString("B", 30, 262);
        g.fillOval(50,240,30,30);
        g.fillOval(90,240,30,30);
        g.fillOval(130,240,30,30);
      }

      // 아웃 경우의 수
      if(out == 0) { //No out
        g.setColor(Color.RED);
        g.drawString("O", 30, 302);
        g.drawOval(50,280,30,30);
      }
      else { // Out일 때
        g.setColor(Color.RED);
        g.drawString("O", 30, 302);
        g.fillOval(50,280,30,30);
      }
    }
  }

}