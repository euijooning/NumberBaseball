package game.numberbaseball.Server;

//랜덤한 난수 생성하는 클래스
public class ComRandomizer {
  int[] com; // 컴퓨터가 추출한 난수를 저장할 배열
  public ComRandomizer() {
    com = new int[3];

    com[0] =(int)(Math.random()*9+1); // 1~9 사이의 추출된 랜덤 수를 저장
    com[1] =(int)(Math.random()*9+1);
    // 중복 검사 => 같으면 다시 추출하기
    while(com[0] == com[1]) {
      com[1] =(int)(Math.random()*9+1);
    }
    com[2] =(int)(Math.random()*9+1);

    while(com[0] == com[2] || com[1] == com[2]) {
      com[2] =(int)(Math.random()*9+1);
    }
  }

}
