const app = Vue.createApp({
    data(){
        return {
            friends : [{id:'manuel', name:'Manuel Lorenzo',phone:'11010 1010 110',email:'manuel@localhost.com'},
            {id:'julie', name:'julie Lorenzo',phone:'11010 1010 110',email:'julie@localhost.com'},
            {id:'tom', name:'tom Lorenzo',phone:'11010 1010 110',email:'tom@localhost.com'}]
        }
    }
});

app.mount('#app');