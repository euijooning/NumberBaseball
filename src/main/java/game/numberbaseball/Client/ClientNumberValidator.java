package game.numberbaseball.Client;

public class ClientNumberValidator {

  public boolean validate(String number) {
    if(number.length() != 3) {
      return false;
    }

    if (number.charAt(0) == number.charAt(1) ||
        number.charAt(1) == number.charAt(2) ||
        number.charAt(0) == number.charAt(2)) {
      return false;
    }

    return true;
  }
}
