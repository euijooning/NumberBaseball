package game.numberbaseball.Client;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JPanel;

public class GameBoard extends JPanel {

  private static final int X_INIT = 50;
  private static final int X_SPACE = 40;

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

    if (gameOver()) {
      this.drawHomerun(g);
    } else {
      this.drawStrike(g);
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
    g.setColor(Color.YELLOW);
    g.drawString("S", 30, 262);

    if (this.strike == 0) { // 0 strike
      g.drawOval(X_INIT, 240, 30, 30);
      g.drawOval(X_INIT + X_SPACE, 240, 30, 30);
    } else if (this.strike == 1) { // 1 strike
      g.fillOval(X_INIT, 240, 30, 30);
      g.drawOval(X_INIT + X_SPACE, 240, 30, 30);
    } else { // 2 strike
      g.fillOval(X_INIT, 240, 30, 30);
      g.fillOval(X_INIT + X_SPACE, 240, 30, 30);
    }
  }

  public void drawBall(Graphics g) {
    // 볼 그리기
    g.setColor(Color.GREEN);
    g.drawString("B", 30, 222);

    int  x = X_INIT;
    for (int i = 0; i<this.ball; i++, x += X_SPACE) {
      g.fillOval(x, 200, 30, 30);
    }
    for (int i = 0; i<3-this.ball; i++, x += X_SPACE) {
      g.drawOval(x, 200, 30, 30);
    }
  }

  public void drawOut(Graphics g) {
    // 아웃 그리기
    g.setColor(Color.RED);
    g.drawString("O", 30, 302);

    if (out == 0) { // No-Out
      g.drawOval(X_INIT, 280, 30, 30);
    } else { // Out
      g.fillOval(X_INIT, 280, 30, 30);
    }
  }
}