# Lotto 프로젝트

--------------------------------------------------------------------------------

## 기능 구현 목록

### Model

- **Lotto**: 로또 번호를 저장하고, 번호의 유효성을 검증한다.

- **WinningNumbers**: RepositoryImpl에서 사용하기 위해 당첨 번호와 보너스 번호를 임시 저장한다.

- **LottoResult**: 로또 결과를 관리하고, 당첨된 로또의 개수 및 수익률을 계산한다.

### Repository

- **LottoRepository**: 로또 구매 및 당첨 번호 저장과 관련된 메서드를 정의한다.

- **LottoRepositoryImpl**: LottoRepository의 구현체로, 로또 및 당첨 번호를 메모리 내에서 저장하고 관리한다.

### Service

- **LottoService**: 로또 구매, 당첨 번호 입력, 결과 확인 및 출력과 관련된 비즈니스 로직을 정의한다.

- **LottoServiceImpl**: LottoService의 구현체로, 로또 구매 및 결과 확인 로직을 구현하며, 저장소와 상호작용하여 데이터를 관리한다.

### View

- **InputView**: 사용자로부터 입력을 받는 역할을 수행하며, 구입 금액, 당첨 번호, 보너스 번호 등을 입력받는다.

- **OutputView**: 출력 메시지를 담당하며, 로또 구매 결과 및 오류 메시지를 출력하는 기능을 제공한다.

- **ErrorMessage**: 각종 오류 메시지를 enum으로 관리한다. 사용자가 잘못된 입력을 했을 때 적절한 오류 메시지를 출력하여 문제를 안내한다.

### Controller

- **LottoController**: View와 Service 간의 중재 역할을 수행하며, 프로그램의 흐름을 관리하고 각 입력에 따라 적절한 서비스를 호출한다.

### AppConfig

- **AppConfig**: 애플리케이션의 구성 정보를 관리하며, 각 클래스의 인스턴스를 생성하고 의존성 주입을 담당한다.

### Application

- **Application**: 프로그램의 진입점으로, main 메서드를 포함하고 애플리케이션을 초기화하여 실행한다.


