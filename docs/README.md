# 미션: 로또

## 구현 기능 목록

### Model

- Lotto : 로또 번호를 저장하는 객체
- LottoStorage : 로또들을 모아서 저장하는 객체
- Wallet : 구입 금액 관련 정보들을 저장하는 객체
- WinNumbers : 당첨 번호 관련 정보들을 저장하는 객체
- WinResult : 로또 당첨 결과 관련 정보들을 저장하는 객체
- WinRewardData : 로또 당첨 상금 관련 정보들을 저장하는 객체(열거형)
- ErrorMessage : 에러 메시지들을 저장하는 객체(열거형)

### View

- InputView : 입력 관련 작업들을 처리하는 객체
- OutputView : 출력 관련 작업들을 처리하는 객체
- ViewText : 출력 메시지들을 저장하는 객체(열거형)

### Controller

- Controller : 모델과 뷰 사이에 컨트롤러 역할을 하는 객체

### Service

- Service : 서비스 관련 객체들을 모아서 관리하는 객체
- WinNumbersGenerator : 로또 당첨 번호를 생성하는 객체
- LottoGenerator : 로또를 생성(판매)하는 객체
- WinResultCalculator : 로또 당첨 결과를 계산하는 객체

### 그 외

- Application : main 메소드를 가지는 객체
- DIConfig : 의존성 주입을 위한 객체

## 실행 순서

1. 로또 구입 금액 입력
2. 입력받은 구입 금액을 바탕으로 로또 생성
3. 당첨 번호와 보너스 번호 입력
4. 입력받은 번호들을 바탕으로 결과 계산
5. 결과 출력
