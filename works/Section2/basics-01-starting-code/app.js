const { createApp, ref, computed } = Vue;

const app = createApp({
    setup() {
      const someValue = ref(10);
      const someComputed = computed(() => someValue.value * 10,
        // console.log("실행됨")
      );
      const squre = (()  => someValue.value * 10, console.log("실행됨"));
      
      let courseGoal = 'Finish the course';
      return {
        someValue,
        someComputed,
        courseGoal,
        squre
      }
    },
    function : {
        
    }
  });
  app.mount("#user-goal");
