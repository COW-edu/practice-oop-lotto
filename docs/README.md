# Lotto 프로젝트

--------------------------------------------------------------------------------

## 기능 구현 목록

### Model

- **Lotto**: 로또 번호를 저장하고, 번호의 유효성을 검증합니다.

- **WinningNumbers**: RepositoryImpl에서 사용하기 위해 당첨 번호와 보너스 번호를 임시 저장합니다.

- **LottoResult**: 로또 결과를 관리하고, 당첨된 로또의 개수 및 수익률을 계산합니다.

### Repository

- **LottoRepository**: 로또 구매 및 당첨 번호 저장과 관련된 메서드를 정의합니다.

- **LottoRepositoryImpl**: LottoRepository의 구현체로, 로또 및 당첨 번호를 메모리 내에서 저장하고 관리합니다.

### Service

- **LottoService**: 로또 구매, 당첨 번호 입력, 결과 확인 및 출력과 관련된 비즈니스 로직을 정의합니다.

- **LottoServiceImpl**: LottoService의 구현체로, 로또 구매 및 결과 확인 로직을 구현하며, 저장소와 상호작용하여 데이터를 관리합니다.

### View

- **InputView**: 사용자로부터 입력을 받는 역할을 수행하며, 구입 금액, 당첨 번호, 보너스 번호 등을 입력받습니다.

- **OutputView**: 출력 메시지를 담당하며, 로또 구매 결과 및 오류 메시지를 출력하는 기능을 제공합니다.

### Controller

- **LottoController**: View와 Service 간의 중재 역할을 수행하며, 프로그램의 흐름을 관리하고 각 입력에 따라 적절한 
