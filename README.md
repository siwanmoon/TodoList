# TodoList

## 프로그램 설명

- 

---

## 구현 기능

- [x] Todo 추가 기능
- [x] Todo 삭제 기능
- [x] 기한이 가까운 순으로 정렬, 기한이 없는 Todo는 기한이 있는 Todo 아래로 정렬
- [x] 중요일정 표시 기능
- [x] 중요 표시한 Todo를 위로 정렬
- [x] 기한이 하루 이하로 남은 Todo는 붉은색으로 표시
- [x] 완료일정 체크 표시 기능
- [ ] Todo 수정 기능

---

## 예외 처리

- [x] 할일에 빈칸 입력
- [x] 투두리스트 개수 100개 초과면 오류발생

---

## 클래스 설명

### [common]

- `ErrorMessage` : 에러메세지를 모아놓은 상수 클래스
- `Strategy` : 프로그램 규칙에 관한 상수를 모아놓은 클래스


### [controller]

- `TodoController` : 프로그램을 관리하는 클래스


### [model]

- `Todo` : 할일 객체
- `TodoRepository` : `Todo`의 일급 컬렉션 객체


### [service]

- `TodoService` : TodoList의 서비스 인터페이스
- `TodoServiceImpl` : `TodoService`의 구현 객체


`Application` : 프로그램을 실행하는 객체
