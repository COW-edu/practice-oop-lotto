package model;

public enum WinLottoCount {
  threeCount("3",5000,"3개 일치 (5000원) -"),
  fourCount("4",50000,"4개 일치(50,000) -" ),
  fiveCount("5",1500000,"5개 일치(1,500,000원) -"),
  fiveBonusCount("5.5",30000000,"5개 일치, 보너스 볼 일치(30,000,000원) -"),
  sixCount("6",2000000000,"6개 일치 (2,000,000,000원) -");

  private final String count;
  private final int lottoWinningPrice;
  private final String resultMessage;
  WinLottoCount(String count, int lottoWinningPrice, String resultMessage){
    this.count =count;
    this.lottoWinningPrice =lottoWinningPrice;
    this.resultMessage = resultMessage;
  }
  public String getCount(){
    return this.count;
  }
  public int getLottoWinningPrice(){return this.lottoWinningPrice;}
  public String getResultMessage(){
    return resultMessage;
  }
}
