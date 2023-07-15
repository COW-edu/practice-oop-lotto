package model;

public enum WinLottoCount {
  threeCount("3",5000),
  fourCount("4",50000),
  fiveCount("5",1500000),
  fiveBonusCount("5.5",30000000),
  sixCount("6",2000000000);

  private String count;
  private int lottoWinningPrice;
  WinLottoCount(String count, int lottoWinningPrice){
    this.count =count;
    this.lottoWinningPrice =lottoWinningPrice;
  }
  public String getCount(){
    return this.count;
  }
  public int getLottoWinningPrice(){return this.lottoWinningPrice;}
}
