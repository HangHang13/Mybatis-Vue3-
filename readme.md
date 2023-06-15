

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



### 하나의 앱 vs 여러개의 앱

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



<<<<<<< HEAD
### 템플릿 이해하기

```js
const app2 = Vue.createApp({
  template : `<p>{{ favoriteMeal }}</p>`,
  data(){
    return {
      favoriteMeal: 'Pizza'
    }
  }
});
app2.mount('#app2')
```

- 이런식으로 템플릿을 내보낼 수 있음.
- 다만 가독성이 떨어짐



### Ref 활용하기

- ref 속성은 기본 HTML 속성이 아님
- Vue는 ref를 감지하고 내부에 이를 저장함
- 받을때는 $ 를 사용하면 내장 프로퍼티를 감지함

```html
    <section id="app">
      <h2>How Vue Works</h2>
      <input type="text" ref="userText">
      <button @click="setText">Set Text</button>
      <p>{{ message }}</p>
    </section>
```



```js
const app = Vue.createApp({
  data() {
    return {
      currentUserInput: '',
      message: 'Vue is great!',
    };
  },
  methods: {
    saveInput(event) {
      this.currentUserInput = event.target.value;
    },
    setText() {
      //this.message = this.currentUserInput;
      this.message = this.$refs.userText
    },
  },
});
```



###  Vue 가 DOM을 업데이트 하는 방법

- 인풋에 값을 넣고 변경했을 때 페이지 전부가 렌더링 되는 것이 아니라 해당 부분만 변경됨
- 이는 Vue가 DOM을 업데이트 하는 방식에 따른 것임
- Vue는 가상 DOM을 생성하고, 이를 메모리에서 업데이트하는 것이 실제 DOM을 업데이트 하는 것보다 효율적임

- 순서

1. 텍스트가 변경
2. Vue가 해당 텍스트 변경 사항을 감지
3. 새로운 가상 DOM을 생성해서 기존 가상 DOM과 비교
4. 변화를 감지한 부분을 변화가 감지된 실제 DOM에 업데이트 함



- 최적화 방식에는 여러가지가 있음 이는 그 중 하나



### Vue LifeCycle

1. `createApp({....})`
2. `beforeCreate()`
3. `created()`

(이 이후에 Vue가 프로퍼티를 인식)

4. `Compile template`
   - 모든 동적 플레이스 홀더와 보간 등이 제거된 후 사용자에게 표시될 구체적인 값으로 대체되는 단계
5. `beforeMount() `
   - 화면에 무언가 표시하기 직전 단계

----

화면 표시

6. `mounted()`
   - Vue가 화면에 표시할 대상을 인지하고 브라우저에 지시 사항을 넘겨서 브라우저가 Vue앱이 정의한 대로 모든 컨텐츠가 있는 HTML 요소를 추가함
7. `Mounted Vue Instance`
   - 마운트 된 Vue 앱, 즉 마운트된 Vue 인스턴스가 완성
8. `Data Changed `
9. `beforeUpdate()`
   - 앱 내에서 업데이트를 완전히 처리하지 않았을 때에 대한 단계
   - 렌더링이 되지 않음
10. `updated()`
    - 해당 처리가 완료되었을 때에 대한 단계
    - 업데이트 이후에는 변경 사항만 처리된 후 화면에 렌더링됨.
11. Instance Unmounted 
    - 종종 Vue가 마운트되지 않을 때가 있음
    - 앱의 마운트가 삭제되면 화면의 모든 콘텐츠가 삭제되며 앱 사용이 불가능함
12. `beforeUnmount()`
    - 콘텐츠 삭제 직전에 실행되는 단계
13. `unmounted()`
    - 콘텐츠 삭제 후 실행되는 단계



## Vue LifeCycle

```js
const app = Vue.createApp({
  
  beforeCreate(){
    console.log('beforeCreate()')
  },//화면이 마운트되기전
  created(){
    console.log('created()')
  },//화면이 마운트되기전
  beforeMount(){
    console.log('beforeMount()')
  },//화면이 마운트되기전
    
    //=========화면에서 보임
  mounted(){
    console.log('mounted()')
  },//화면이 마운트되고난후
    
    
  beforeUpdate(){
    console.log('beforeUpdate()')
  },//dom이 변화하기 전
  updated(){
    console.log('updated()')
  },//dom이 변화하고 난 후
    
    
  beforeUnmount(){
    console.log('beforeUnmount()')
  },//dom이 unmount되기전
  unmounted(){
    console.log('unmounted()')
  }//dom이 unmount되고난 후
});
```
