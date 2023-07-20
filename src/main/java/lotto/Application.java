package lotto;

import lotto.controller.Controller;

public class Application {

  public static void main(String[] args) {
    // TODO: 메인 메소드 작성
    Controller controller = new Controller();
    try {
    } catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
    }
  }
}
