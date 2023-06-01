<template>
  <div class="about">

    
     <!-- <div v-for="userInfo in userList" :key="userInfo.ID_SABUN">
      <td>
        {{ (userInfo) }}
      </td>
      &nbsp;
    </div>  -->

    <!-- <div v-for="userInfo in pms" :key="userInfo.ID_SABUN">
      <td>
        계약처 : {{ (userInfo.contractCompanyName) }}
      </td>
      &nbsp;
    </div> -->
      <!-- <h1>{{aesDencrypt(userList[0])}}</h1> -->
      <!-- <h1>{{aesDencrypt(user)}}</h1> -->

      <!-- <h1>{{decrypt2(pms)}}</h1> -->
      <!-- <h1>{{decrypt(user)}}</h1> -->
      <!-- <h1>{{decrypt(user)}}</h1> -->
      <!-- <h1>{{decrypto}}</h1> -->
      <!-- <p>{{toStringd}}</p> -->
      
  </div>
</template>
  

<script>
const key = "congsangnevoixzskqmqfejcbcqanbvq";
const iv = key.substring(0,16) // 16자리 iv;
import axios from "axios";
import CryptoJS from "crypto-js";
// import CryptoJS from 'vue-cryptojs'
export default {
  name: 'AboutView',
  
  data(){
    return {
      userList: [],
      user : '',
      toStringd : [],
      decrypto : [],
      pms : []
    }
  },

  methods: {


    aesDencrypt(txt) {
 

      const info3 = CryptoJS.AES.decrypt(txt, key).toString(CryptoJS.enc.Base64)
      return info3
    },

    decrypt(word) {
    let decData = CryptoJS.enc.Base64.parse(word).toString(CryptoJS.enc.Utf8)
    let bytes = CryptoJS.AES.decrypt(decData, key).toString(CryptoJS.enc.Utf8)
    return JSON.parse(bytes)
},


// 복호화
 decrypt2(word){
    const decipher = CryptoJS.AES.decrypt(word, CryptoJS.enc.Utf8.parse(key), {
        iv: CryptoJS.enc.Utf8.parse(iv),
        padding: CryptoJS.pad.Pkcs7,
        mode: CryptoJS.mode.CBC,
    })

    return decipher.toString(CryptoJS.enc.Utf8);},
      
    getUserInfo(){

      axios({
        url: "https://erp.cengroup.co.kr/api/users.do?CD_CORP=GO",
        method: "get"

      })
      .then(res => {
        console.log(res.data.userList);
        this.userList = res.data.userList;
   
      })
      .catch(err => console.log(err.response))
    },
    getPmsInfo(){
      axios({
        url: "http://pmsstg.cenerp.co.kr:8081/JavaERP/openApi/contracts/SS/B?DATA=K4PyOQcjjf56nTH4chTJqw%3D%3D",
        method: "get"
      })
      .then(res => {
        console.log(res.data.body);
        if (res.data.code == "200"){
          console.log("데이터요청성공")
          this.pms = res.data.body
        }
        else if(res.data.code =="500"){
          console.log("서버에러입니다.")
    
        }
      })
      .catch(err => console.log(err.response))
    }
  },

  created(){
    this.getUserInfo()
    // this.getPmsInfo()
  }
  
}
</script>
<style>
@media (min-width: 1024px) {
  /* .about {
    min-height: 100vh;
    display: flex;
    align-items: center;
  } */
}
</style>
