package lotto;

public class Application {
    public static void main(String[] args) {
        LottoCounter lottoDigit = new LottoCounter();

        LottoNumberCreater lottoNumber = new LottoNumberCreater();
        lottoNumber.numberCreate(lottoDigit.getLottoCount());

        LottoWinNumberCreater lottoWinNumber = new LottoWinNumberCreater();
        lottoWinNumber.createLottoWinNumber();

        Lotto lotto = new Lotto(lottoWinNumber.getLottoWinNumber());
        lotto.compareLottoNumbers(lottoNumber.getLottoNumbers(),lottoWinNumber.getBounsNumber(),lottoDigit.getLottoCount());
    }
}
