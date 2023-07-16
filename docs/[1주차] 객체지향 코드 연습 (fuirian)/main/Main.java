// Main.java
package main;

import controller.LottoController;
import model.LottoModel;
import view.LottoView;

public class Main {
    public static void main(String[] args) {
        // 모델 객체 생성
        LottoModel lottoModel = new LottoModel();

        // 뷰 객체 생성
        LottoView lottoView = new LottoView();

        // 컨트롤러 객체 생성
        LottoController lottoController = new LottoController(lottoModel, lottoView);

        // 게임 실행
        lottoController.run();
    }
}
