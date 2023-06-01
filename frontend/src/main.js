import { createApp } from 'vue'
import { createPinia } from 'pinia'
import VueCryptojs from 'vue-cryptojs'
import cryptoJs from 'crypto-js'
import App from './App.vue'
import router from './router'

import './assets/main.css'

const app = createApp(App)
app.use(VueCryptojs)
app.use(cryptoJs)
app.use(createPinia())
app.use(router)
app.mount('#app')
