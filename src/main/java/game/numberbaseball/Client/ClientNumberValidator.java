package game.numberbaseball.Client;

public class ClientNumberValidator {

  public boolean validate(String inputNumber) {
    if(inputNumber.length() != 3) {
      return false;
    }

    if (inputNumber.charAt(0) == inputNumber.charAt(1) ||
        inputNumber.charAt(1) == inputNumber.charAt(2) ||
        inputNumber.charAt(0) == inputNumber.charAt(2)) {
      return false;
    }

    try {
      Integer.parseInt(inputNumber);
    } catch (NumberFormatException e ) {
      return false;
    }

    return true;
  }
}
