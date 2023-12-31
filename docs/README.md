## 📜 기능 목록

### ⌨️ 입력

- [✔] 식당 예상 방문 날짜을 입력 받는다.
    - [✔] 1 ~ 31 사이의 숫자가 아니라면, IllegalArgumentException 발생
    - [✔] 입력이 문자라면, IllegalArgumentException 발생
    - [✔] 입력이 공백이라면, IllegalArgumentException 발생

- [✔] 주문할 메뉴의 종류와 개수를 입력 받는다.
    - [✔] 메뉴 입력의 양식을 지키지 않은 경우, IllegalArgumentException 발생
      - [✔] 메뉴들을 쉼표(,)를 기준으로 구분한다.
        - [✔] 메뉴판에 없는 메뉴 입력시, IllegalArgumentException 발생
        - [✔] 중복 메뉴 입력시, IllegalArgumentException 발생
        - [✔] 음료만 주문 시, 주문할 수 없습니다.
      - [✔] 각 메뉴의 종류와 주문 개수를 (-)를 기준으로 구분한다.
        - [✔] 메뉴 개수가 숫자가 아닐 떄, IllegalArgumentException 발생
        - [✔] 메뉴 개수가 1 이상의 숫자가 아닐 때, IllegalArgumentException 발생
        - [✔] 메뉴는 한 번에 최대 20개까지만 주문할 수 있습니다.
    - [✔] 입력이 공백이라면, IllegalArgumentException 발생

### 🖥️ 출력

- [✔]  식당 예상 방문 날짜 입력 안내 메시지 출력
- [✔]  주문할 메뉴의 종류와 개수 입력 안내 메시지 출력

- [✔] 이벤트 플래너 출력
  - [✔] 주문 메뉴
  - [✔] 할인 전 총주문 금액
  - [✔] 증정 메뉴
  - [✔] 혜택 내역
  - [✔] 총혜택 금액
  - [✔] 할인 후 예상 결제 금액
  - [✔] 12월 이벤트 배지 내용을 보여주기

- [✔] 예외 상황 시 에러 문구를 출력해야 한다. 단, 에러 문구는 "[ERROR]"로 시작해야 한다.

### 📱 기능 처리

- [✔] 메뉴의 종류와 가격을 저장 - Menu (Enum)

- [✔] 할인을 계산하는 기능 구현 및 총 할인 저장 - CalenderDiscount
  - [✔] 크리스마스 디데이 할인 : 1,000원으로 시작하여 크리스마스가 다가올수록 날마다 할인 금액이 100원씩 증가
  - [✔] 평일 할인(일요일~목요일): 평일에는 디저트 메뉴를 메뉴 1개당 2,023원 할인
  - [✔] 주말 할인(금요일, 토요일): 주말에는 메인 메뉴를 메뉴 1개당 2,023원 할인
  - [✔] 특별 할인: 이벤트 달력에 별이 있으면 총주문 금액에서 1,000원 할인
  - [✔] 증정 이벤트: 할인 전 총주문 금액이 12만 원 이상일 때, 샴페인 1개 증정
  - [✔] 이벤트 기간: '크리스마스 디데이 할인'을 제외한 다른 이벤트는 2023.12.1 ~ 2023.12.31 동안 적용

- [✔] 계산을 처리하는 기능 구현 - CalenderCompute

- [✔] 요일을 계산하는 기능 구현 - CalenderDay

- [✔] 입력 조건에 맞게 입력했는지 검증하는 기능 구현 - CalenderValidate

- [✔] 상수들을 관리하는 파일 - Constants

### 🪜 목표

- TDD 적용
- 클래스 분리
    - 클래스 구현 순서 지키기
    - 핵심 로직을 구현하는 코드와 UI를 담당하는 로직을 분리해 구현 -> MVC 패턴 적용
- Enum 클래스를 Menu, Discount에 적용