package game.numberbaseball.Client;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JPanel;

public class GameBoard extends JPanel {

  int strike = 0;
  int ball = 0;
  int out = 0;

  public GameBoard() {
  }

  void setData(int strike, int ball, int out) {
    this.strike = strike;
    this.ball = ball;
    this.out = out;
  }

  @Override
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    g.setFont(new Font("맑은 고딕", 1,20));
    this.drawStrike(g);

    if (this.strike != 3) {
      this.drawBall(g);
      this.drawOut(g);
    }
  }

  public boolean gameOver() {
    return this.strike == 3;
  }

  public void drawHomerun(Graphics g) {
    super.paintComponent(g);
    this.removeAll();
    this.repaint();

    g.setColor(Color.WHITE);
    g.setFont(new Font("맑은 고딕", 1, 60));
    g.drawString("Home Run!", 30, 180);
    g.drawString("축하합니다.", 30, 300);
  }

  public void drawStrike(Graphics g) {
    // 스트라이크 그리기
    if (this.strike == 3) { // 홈런인 경우
      drawHomerun(g);
    }
    else { // 홈런 아닌 경우
      g.setColor(Color.YELLOW);
      g.drawString("S", 30, 262);

      if (this.strike == 0) { // 0 strike
        g.drawOval(50, 240, 30, 30);
        g.drawOval(90, 240, 30, 30);
      } else if (this.strike == 1) { // 1 strike
        g.fillOval(50, 240, 30, 30);
        g.drawOval(90, 240, 30, 30);
      } else { // 2 strike
        g.fillOval(50, 240, 30, 30);
        g.fillOval(90, 240, 30, 30);
      }
    }
  }

  public void drawBall(Graphics g) {
    // 볼 그리기
    g.setColor(Color.GREEN);
    g.drawString("B", 30, 222);

    if (this.ball == 0) { // 0 ball
      g.drawOval(50, 200, 30, 30);
      g.drawOval(90, 200, 30, 30);
      g.drawOval(130, 200, 30, 30);
    } else if (this.ball == 1) { // 1 ball
      g.fillOval(50, 200, 30, 30);
      g.drawOval(90, 200, 30, 30);
      g.drawOval(130, 200, 30, 30);
    } else if (this.ball == 2) { // 2 ball
      g.fillOval(50, 200, 30, 30);
      g.fillOval(90, 200, 30, 30);
      g.drawOval(130, 200, 30, 30);
    } else { // 3 ball
      g.fillOval(50, 200, 30, 30);
      g.fillOval(90, 200, 30, 30);
      g.fillOval(130, 200, 30, 30);
    }
  }

  public void drawOut(Graphics g) {
    // 아웃 그리기
    g.setColor(Color.RED);
    g.drawString("O", 30, 302);

    if (out == 0) { // No-Out
      g.drawOval(50, 280, 30, 30);
    } else { // Out
      g.fillOval(50, 280, 30, 30);
    }
  }
}