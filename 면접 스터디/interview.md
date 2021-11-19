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
  객체 지향 프로그래밍이란

</div>
</details>
<details>
<summary>2. 다형성이란?</summary>
<div markdown="1">

  - <b>지헌</b>  
  하나의 레퍼런스 변수가 다양한 객체를 참조할 수 있는 것을 의미하며 다형성을 구현하기 위해서는 오버로딩과 오버라이딩이 있습니다.
  
  

</div>
</details>

<details>
<summary>3. 추상클래스와 인터페이스의 차이점</summary>
<div markdown="1">

  - <b>지헌</b>  
  인터페이스는 추상 메소드와 상수만을 멤버로 가지며 추상클래스는 최소한 하나의 추상메소드를 갖고있을 경우를 말합니다.
  인터페이스는 해당 인터페이스를 구현하는 클래스들이 같은 기능을 수행하도록 강제할 때 사용되며, 
  추상 클래스는 이를 상속할 각 객체들의 공통점을 찾아 추상화시켜 놓은 것으로 자식 클래스에게 부모클래스의 기능을 구현하도록 할 경우 사용합니다.
  

  
</div>
</details>

<details>
<summary>4. 컴파일러 와 인터프리터 차이점</summary>
<div markdown="1">



</div>
</details>

<details>
<summary>5. Call By Reference 와 Call By Value의 차이점</summary>
<div markdown="1">



</div>
</details>

<details>
<summary>6. 가비지 컬렉션이란?</summary>
<div markdown="1">



</div>
</details>

<details>
<summary>7. String 과 StringBuffer의 차이점</summary>
<div markdown="1">



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
