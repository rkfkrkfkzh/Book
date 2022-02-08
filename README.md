# Book
<img width="827" alt="스크린샷 2022-02-04 오전 12 38 52" src="https://user-images.githubusercontent.com/86057607/152375508-53ef351c-c1f7-4b8e-9fe7-cf1d4896faf8.png">
try블록에는 예외가 발생할 수 있는 코드가 위치합니다.

try 블록의 코드가 예외없이 정상 실행되면 catch블록의 코드는 실행되지 않습니다.</br>
하지만 try 블록의 코드에서 예외가 발생하면 즉시 실행을 멈추고 catch 블록으로 이동하여 예외처리 코드를 실행합니다.

## 1. 프로그램 오류
 
컴파일 에러(compile-time error): 컴파일할 때 발생하는 에러

런타임 에러(runtime error): 실행할 때 발생하는 에러

에러(error) : 프로그램 코드에 의해서 수습될 수 없는 심각한 오류

예외(exception) : 프로그램 코드에 의해서 수습될 수 있는 다소 미약한 오류 (처리 가능한 오류)

## 2. 예외처리의 정의와 목적
 
에러(error)는 어쩔 수 없지만, 예외(exception)는 처리해야 합니다.

예외처리(exception handling)는 프로그램 실행 시 발생할 수 있는 예외의 발생에 대한 코드를 작성하는 것입니다.

예외처리의 목적은 프로그램의 비정상 종료를 막고, 정상적인 실행상태를 유지하는 것입니다.

(에러와 예외는 모두 실행 시(runtime) 발생하는 오류입니다.)

## 3. 예외처리구문 : try-catch
 
예외를 처리하려면 try-catch문을 사용해야 합니다.


<img width="618" alt="스크린샷 2022-02-08 오후 5 49 29" src="https://user-images.githubusercontent.com/86057607/152951116-36229c14-b535-4639-a7cd-12a275e0afc2.png">

## 4. try-catch문에서의 흐름
 

try블럭 내에서 예외가 발생한 경우,

1. 발생한 예외와 일치하는 catch블럭이 있는지 확인합니다.

2. 일치하는 catch블럭을 찾게 되면, 그 catch블럭 내의 문장들을 수행하고 전체 try-catch문을 빠져나가서 그다음 문장을 계속해서 수행합니다. 만약 일치하는 catch블럭을 찾지 못하면, 예외는 처리되지 못합니다.

<img width="429" alt="스크린샷 2022-02-08 오후 5 53 24" src="https://user-images.githubusercontent.com/86057607/152951767-93a4f923-163f-4bef-b2d1-03427f18eea1.png">
[실행결과]
<img width="244" alt="스크린샷 2022-02-08 오후 6 01 22" src="https://user-images.githubusercontent.com/86057607/152953318-485fb6da-1420-4f16-b47f-2a634efa3969.png">

try블럭 내에서 예외가 발생하지 않은 경우,

1. catch블럭을 거치지 않고 전체 try-catch문을 빠져나가서 수행을 계속합니다.

<img width="350" alt="스크린샷 2022-02-08 오후 5 57 11" src="https://user-images.githubusercontent.com/86057607/152952447-661fa339-9030-41e6-b719-872a97bb30d7.png">
[실행결과]
<img width="304" alt="스크린샷 2022-02-08 오후 6 00 45" src="https://user-images.githubusercontent.com/86057607/152953300-e8ebe6f7-a453-4cc0-8a16-0db17a7059a3.png">



