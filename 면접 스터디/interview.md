## 📚SSAFY 면접 스터디📚

기간 - 2021.11 ~ 진행중 ! 

### 자바
<details>
<summary>1. 객체 지향 프로그래밍(OOP)이란?</summary>
<div markdown="1">
  
  - <b>지헌</b>  
  객체 지향 프로그래밍이란 순차적으로 실행되는 절차 지향적 프로그래밍과는 다르게 객체의 상호작용을 통해 동작하는 것을 의미합니다.
  객체의 상호작용을 통해 상속, 추상화, 다형성을 사용하여 코드 재사용성을 증가시켜줍니다.

  
  - <b>기동</b>  
  객체 지향 프로그래밍은 컴퓨터 프로그래밍의 패러다임 중 하나이며, 컴퓨터 프로그램을 명령어의 목록으로 보는 시각에서 벗어나 여러 개의 독립된 단위, 즉 "객체"들의 모임으로 파악하고자 하는 것이다. 기본 구성요소는 클래스, 객체, 메서드로 이루어져 있으며 캡슐화,상속,다형성이라는 특징을 가지고있다. 객체지향의 목표로는 소프트웨어의 생산성 향상 , 실세계애 대한 쉬운 모델링 등이 있다.

</div>
</details>
<details>
<summary>2. 다형성이란?</summary>
<div markdown="1">

  - <b>지헌</b>  
  하나의 레퍼런스 변수가 다양한 객체를 참조할 수 있는 것을 의미하며 다형성을 구현하기 위해서는 오버로딩과 오버라이딩이 있습니다.

  - <b>기동</b>  
  같은 이름의메소드가 클래스 혹은 객체에 따라 다르게 구현되는것을 말하며
메소드 오버라이딩(overriding) 과 메소드 오버로딩(overloading) 있다.
오버라이딩은 슈퍼클래스에 구현된 메소드를, 서브 클래스에서 자신의 특징에 맞게 동일한 이름으로 다시 구현하는것 이며 오버로딩은 클래스내에서 같은 이름의메소드를 여러개 만드는 것으로 자바에서는 클래스 내에 이름은 같지만 매개 변수의 타입이나 개수가 서로 다른 여러개의 메소드를 작성할수있다.

</div>
</details>

<details>
<summary>3. 추상클래스와 인터페이스의 차이점</summary>
<div markdown="1">

  - <b>지헌</b>  
  인터페이스는 추상 메소드와 상수만을 멤버로 가지며 추상클래스는 최소한 하나의 추상메소드를 갖고있을 경우를 말합니다.
  인터페이스는 해당 인터페이스를 구현하는 클래스들이 같은 기능을 수행하도록 강제할 때 사용되며, 
  추상 클래스는 이를 상속할 각 객체들의 공통점을 찾아 추상화시켜 놓은 것으로 자식 클래스에게 부모클래스의 기능을 구현하도록 할 경우 사용합니다.
  
  - <b>기동</b>  
  추상클래스의 목적은 상속을 받아서 기능을 확장시키는 것이지만 
  인터페이스는 구현하는 모든 클래스에 대해 특정한 메서드가 반드시 존재하도록 강제하는역할로 구현하는 객체가 같은 동작을 하기위해 사용한다.
  구조적으로 추상클래스는 추상메서드가 하나 이상 포함되거나 abstract로 정의 된 경우 인터페이스는 추상메서드로만 이루어진 경우이다.

    공통점 : 둘다 추상메서드를 구현하도록 강제하고 인스턴스화가 불가능하다.
  
</div>
</details>

<details>
<summary>4. 컴파일러 와 인터프리터 차이점</summary>
<div markdown="1">
  
   - <b>기동</b><br>
      컴파일러와 인터프리터 사림이 고급언어를 작성하면 해당 고급언어로 작성된 소스코드를 기계어로 번역하는하는 공통점이 있지만
      컴파일러는 코드 전체를 한번에 번역하여 인터프리터 보다 번역속도는 느리지만 한번 번역을하면 실행 파일이 생성되어 인터프리터보다 실행 시간이 빠른 편입니다.
      인터프리터는 코드를 한줄 한줄 번역하여 진행하기때문에 컴파일러보다 번역속도가 빠르지만 실행파일을 만들지 않고 매번 번역해야기 떄문에 실행속도가 느린 편입니다.

       **추가 질문 컴파일러가 인터프리터보다 실행속도가 빠른데 왜 인터프터를 사용하는 이유가 무엇인가?**

         : 컴파일러는 플랫폼에 종속적이지만, 인터프리터는 모든 플랫폼에 종속되지 않습니다.

        ex) JVM 안에서
        .java  -- 컴파일러 --> .class  -- 인터프리터 --> 기계언어

        .java파일을 javac 컴파일러가 바이트코드인 .class 파일로 변환 .class 상태에서는 플랫폼에 종속적

        인터프리터는 .class 파일내의 바이트코드를 특정환경 기계에서 실행할수 있도록 변환해줍니다.


</div>
</details>

<details>
<summary>5. Call By Reference 와 Call By Value의 차이점</summary>
<div markdown="1">

  - <b>기동</b><br>
    참조에 의한 호출 , 값의 의한 호출로<br>
    Call by value는 메서드 호출 시에 사용되는 인자의 메모리에 저장되어 있는 값(value)을 복사하여 보낸다.<br>
    Call by reference는 메서드 호출 시 사용되는 인자 값의   메모리에 저장되어있는 주소 (Address)를 복사하여 보낸다.<br>
    <br>
    기본 자료형 : call by value 로 동작 (int, short, long, float, double, char, boolean)<br>
    참조 자료형 : call by reference 로 동작 (Array, Class Instance) 
    
</div>
</details>

<details>
<summary>6. 가비지 컬렉션이란?</summary>
<div markdown="1">
  
  - <b>기동</b><br>
   JVM안에 GC는 동적 할당된 메모리 영역(heap) 중에서 더 이상 사용하지 않는 영역을 즉 참조되지 않는 객체등 을 탐지하여 자동으로 해제 시키는 것


</div>
</details>

<details>
<summary>7. String 과 StringBuffer의 차이점</summary>
<div markdown="1">

  
  
  - <b>기동</b><br>
    String은 불변의 속성을 가지고 있지만 StringBuffer는 스트링을 다루는 클래스로 내부에 가변 크기의 버퍼를 가지고 문자의 개수에 따라 버퍼크기를 자동 조절 가능하다.
    String은 불변하기 때문에 문자열 추가,수정 삭제 등의 연산이 빈번하면 힙 메모리의 임시 가비지가 생성된다.

    그래서 String은 문자열 연산이 적고 멀티쓰레드 환경일 경우 StringBuffer는 문자열 연산이 많고 멀티쓰레드인 환경일 경우 적합.

    **StringBuffer 와 StringBuilder 차이
     동기화 유무로 사용하는것을 선택하는데 StringBuffer는 동기화를 지원하지만 StringBuilder는 동기화를 지원하지 않는다. 그래서 단일 쓰레드에서의 성능은 StringBuilder가 더 좋다.


</div>
</details>

<hr>

### 프레임워크
<details>
<summary>8. 스프링부트와 스프링 프레임워크의 차이점</summary>
<div markdown="1">

  - <b>지헌</b>  
  기존 스프링 프레임워크는 기능이 많은 만큼 환경설정과 버전관리를 일일히 해줘야 되는 불편함이 있다. 
  하지만 스프링 부트에서는 스프링 스타터라는 디펜더시만 추가해주면 자동으로 API를 가져오고 내장 톰캣으로 웹 어플리케이션 서버를 실행할 수 있다는 장점을 가지고 있다.

</div>
</details>

<details>
<summary>9. 스프링의 특징 AOP,IOC,DI? </summary>
<div markdown="1">



</div>
</details>

<details>
<summary>10. 스프링 필터와 인터셉터의 차이점 </summary>
<div markdown="1">

  - <b>지헌</b>  
  스프링 필터는 스프링과 무관하게 웹 컨테이너 내부에 존재하며 인터셉터는 스프링 컨테이너 내부에 존재합니다.
  필터는 하나의 요청이 DispatcherServlet에 도착하기 이전에 실행되는 반면,
  인터셉터는 DispatcherServlet이 컨트롤러를 호출하기 전,후에 요청과 응답을 처리하는 기능을 제공합니다. 
  


</div>
</details>

<details>
<summary>11. DAO, DTO의 차이점 </summary>
<div markdown="1">

  - <b>지헌</b>  
  DAO란 데이터베이스에 접근하기 위해 생성된 객체로써, 데이터베이스에 접속하여 조회 및 조작하는 기능을 전담하는 객체입니다.
  DTO란 계층 간의 데이터 교환을 위한 순수 자바객체로서 객체의 속성과 Getter, Setter메소드만을 가지고 있습니다.


</div>
</details>

<hr>

### 웹 개발 
<details>
<summary>12. 서버란?</summary>
<div markdown="1">



</div>
</details>

<details>
<summary>13. WAS 와 Web Server의 차이점</summary>
<div markdown="1">

  - <b>지헌</b>  
  Web Server는 정적인 파일을 제공하는 서버이며 WAS는 동적인 데이터를 제공하기 위한 서버이다.
  일반적으로 WAS는 Web Server의 기능을 내제하고 있어 Web Server없이도 서비스 가능하다.


</div>
</details>

<details>
<summary>14. REST API란?</summary>
<div markdown="1">

  - <b>지헌</b>  
  HTTP URI를 통해 자원을 명시하고, HTTP METHOD를 통해 해당 자원에 대한 연산을 수행하는 것을 의미합니다.
  해당 연산에는 4가지가 존재하며 삽입, 조회, 수정, 삭제 연산이 있습니다.
  REST API를 사용함으로서, 서버와 클라이언트간 분리가 명확해지며, HTTP 표준 프로토콜에 따르는 모든 플랫폼에서 사용이 가능하다는 장점이 있습니다.



</div>
</details>

<details>
<summary>15. http 403 vs 404 </summary>
<div markdown="1">



</div>
</details>

<details>
<summary>16. MVC 패턴이란?  </summary>
<div markdown="1">



</div>
</details>


<details>
<summary>17. 비동기 vs 동기식 통신의 차이점 </summary>
<div markdown="1">

  - <b>지헌</b>  
  동기식 통신에서는 데이터를 받아올때까지 대기하는 상태로 있기떄문에 어떠한 작업도 못한다는 단점이있습니다. 
  하지만 비동기 방식에서는 데이터를 요청하고 결과를 받아오는 시간동안 다른 작업을 수행할 수 있다는 장점을 가지고 있습니다.
  

</div>
</details>
