package lotto;

import controller.CLotto;
import model.CalculateSheet;
import model.Lotto;
import view.VLotto;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        CalculateSheet calc = new CalculateSheet();
        VLotto vLotto = new VLotto();
        CLotto cLotto = new CLotto(calc, vLotto);

        cLotto.run();
    }


}
