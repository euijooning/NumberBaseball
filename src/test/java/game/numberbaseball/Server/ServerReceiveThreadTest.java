package game.numberbaseball.Server;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ServerReceiveThreadTest {
  ServerReceiveThread serverReceiveThread = new ServerReceiveThread();

  @DisplayName("입력한 숫자를 배열로 만들기")
  @Test
  void makeIntArray() {
    String receiveString = "615";
    int[] expectedArray = {6, 1, 5};

    int[] actualArray = serverReceiveThread.makeIntArray(receiveString);

    assertArrayEquals(expectedArray, actualArray);
  }

}