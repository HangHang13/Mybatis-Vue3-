

## 왜 Vue를 쓰는가

- 웹, 앱은 신속하게 반응해야함
- 기존의 방식은 요쳥을 보내고 html 페이지를 새로 받음
- 자바스크립트는 로드된 페이지, 브라우저 내에서 실행됨
- 문서객체모델(DOM) 을 자바스크립트로 조작

- **Vue를 쓰는 이유는 자바스크립트가 완벽하지 않아서**
  - 바닐라 자바스크립트의 경우 모든 것을 만들어야함.
  - 이에따라 성능, 보안이슈, 협업 이슈
  - 핵심 비즈니스 로직에만 집



## SinglePageApplication

- 서버로부터 새로운 페이지를 받지 않고 현재의 페이지를 동적으로 작성
- SPA에서 HTML, 자바스크립트, CSS 등 모든 코드를 하나의 페이지로 불러오거나, 적절한 자원들을 동적으로 불러들임
- 전통적인 웹 방식은 새로운 페이지를 요청할 때 마다 정적 리소스가 다운로드 되고, 전체 페이지를 다시 렌더링함.
- 이는 변경이 필요없는 부분까지도 렌더링하여 비효율적

![image-20230601181724346](https://github.com/HangHang13/Mybatis-Vue3-/assets/82326116/2d8477be-41c7-419a-8f08-801ca2c3a510)



## SPA의 특징

### 1. 라우팅

- 출발지에서 목적지까지 경로를 결정하는 기능
- 사용자가 화면에서 다른 화면으로 전환할때의 네비게이션 기능
- 요청 URI에 따라 브라우저에서 DOM을 변경하는 방식
- 동적으로 렌더링 되도록 만들면 라우팅에 따라 다른 화면을 구현할 수 있음

### 2. 컴포넌트



## SPA의 장점

- 서버가 할 일을 클라이언트 부담하므로, 서버 부담이 경감
- 모듈화 및 컴포넌트 개발에 용이
- 백엔드와 프론트 개발 영역을 명확하게 구분

## SPA의 단점

- 초기 구동 속도가 느림(처음 접속 시, 사이트 구성과 관련없는 모든 리소스를 한 번에 다 받음)
- 클라이언트에 중요 비즈니스 로직이 노출될 수 있음
- 검색 엔진 최적화가 어려움 => 페이지가 로딩되어야 리소스가 보이므로, 검색에 노출이 안됨





## 세 가지 변수 선언법의 차이점

- `var` 선언은 전역 범위 또는 함수 범위이며, `let`과 `const`는 블록 범위이다.
- `var` 변수는 범위 내에서 업데이트 및 재선언할 수 있다. `let` 변수는 업데이트할 수 있지만, 재선언은 할 수 없다. `const` 변수는 업데이트와 재선언 둘 다 불가능하다.
- 세 가지 모두 최상위로 호이스팅된다. 하지만 `var` 변수만 `undefined(정의되지 않음)`으로 초기화되고 `let`과 `const` 변수는 초기화되지 않는다.
- `var`와 `let`은 초기화하지 않은 상태에서 선언할 수 있지만, `const`는 선언 중에 초기화해야한다.





## Vue 연결

```html
<section id="user-goal">
      <h2>My Course Goal</h2>
      <p></p>
</section>
```

```js
const app = Vue.creatApp();

app.mount('#user-goal');
```





## Vue 내부 들여다보기



### 프록시

```js
let message = 'Hello'

let longMessage = message + 'World'

console.log(longMessage) // Hello World

let mesasge = 'Hello!!!!'

console.log(longMessage) // Hello World

/자바스크립트는 반응형이 아니다.
```

```js
const data ={
  message: 'Hello!',
  longMessage: 'Hello! World!'
};

const handler = {
  set(target, key, value){
    console.log(target)
    console.log(key)
    console.log(value)
  }
}

const proxy = new Proxy(data, handler);

proxy.message = 'Hello!!!!!'

//{message: 'Hello!', longMessage: 'Hello! World!'}
//message
//Hello!!!!!
/Vue는 이러한 프록시를 내장하여 반응형 변수를 만든다.
```



### 나누기

```html
 <body>
    <section id="app">
    </section>
    <section id="app2">
    </section>
  </body>
```



```js
const app = Vue.createApp()
app.mount('#app');

const app2 = Vue.createApp();
app.mount('#app2')
```



