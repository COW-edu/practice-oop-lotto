# 학습한 내용
1. 인터페이스를 활용해서 의존성을 외부에 주입함으로써 최대한 결합도를 낮추려고
해보았습니다. 
2. MVC패턴을 활용해서 model, view, controller에 해당되는 적절한 객체 분리
# 고민한 부분
1. 비즈니스 로직이 출력 로직에 섞이지 않게 하는 것.
2. Console.readLinst()을 쓰는데 warning이 안뜨게 하는 것.

아직 객체 지향 프로그래밍을 하는데 미숙한 부분이 많아 객체에 적절한 분리가 잘 된 것
같지는 않습니다... 

또한 camp.nextstep.edu.missionutil 에서 제공하는
Console을 활용하려고 했는데 WARNING 메시지가 자꾸 떠서 우선은
Scanner를 활용해서 사용자의 입력을 받았습니다.