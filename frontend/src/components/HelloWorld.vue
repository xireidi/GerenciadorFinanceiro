<template>
  <div class="hello">
    <h1>{{ msg }}</h1>
    <div>
      <input id="caixaAlerta" type='text'/><br><br>
    </div>
    <div class='alertaBotao'>
      <button id='botao' v-on:click='exibirInput'>Você escreveu:</button>
      <br><br>
      <button id='botao2' v-on:click='exibirAlerta'>Alerta</button>
      
    </div>
    <p>
      For guide and recipes on how to configure / customize this project,<br>
      check out the
      <a href="https://cli.vuejs.org" target="_blank" rel="noopener">vue-cli documentation</a>.
    </p>
    <h3>Installed CLI Plugins</h3>
    <ul>
      <li><a href="https://github.com/vuejs/vue-cli/tree/dev/packages/%40vue/cli-plugin-babel" target="_blank" rel="noopener">babel</a></li>
    </ul>
    <h3>Essential Links</h3>
    <ul>
      <li><a href="https://vuejs.org" target="_blank" rel="noopener">Core Docs</a></li>
      <li><a href="https://forum.vuejs.org" target="_blank" rel="noopener">Forum</a></li>
      <li><a href="https://chat.vuejs.org" target="_blank" rel="noopener">Community Chat</a></li>
      <li><a href="https://twitter.com/vuejs" target="_blank" rel="noopener">Twitter</a></li>
      <li><a href="https://news.vuejs.org" target="_blank" rel="noopener">News</a></li>
    </ul>
    <h3>Ecosystem</h3>
    <ul>
      <li><a href="https://router.vuejs.org" target="_blank" rel="noopener">vue-router</a></li>
      <li><a href="https://vuex.vuejs.org" target="_blank" rel="noopener">vuex</a></li>
      <li><a href="https://github.com/vuejs/vue-devtools#vue-devtools" target="_blank" rel="noopener">vue-devtools</a></li>
      <li><a href="https://vue-loader.vuejs.org" target="_blank" rel="noopener">vue-loader</a></li>
      <li><a href="https://github.com/vuejs/awesome-vue" target="_blank" rel="noopener">awesome-vue</a></li>
    </ul>
  
  </div>
</template>
  
<script>

export default {
  name: 'HelloWorld',
  props: {
    msg: String,
},
  
     methods: {
      exibirAlerta(){
       alert ('Fui clicado!');
      },
     
      exibirInput(){
        alert (caixaAlerta.value);
      }
    }
       }
       

       

</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
h3 {
  margin: 40px 0 0;
}
ul {
  list-style-type: none;
  padding: 0;
}
li {
  display: inline-block;
  margin: 0 10px;
}
a {
  color: #42b983;
}
#botao2{
    font-size: 15px;
    color:rgb(112, 207, 144);
    width:75px;
    height:25 px;
    background-color: #0f8a4c ;
    border-radius: 30px 30px 30px 30px;
    }
#botao{
    font-size: 15px;
    color:rgb(112, 207, 144);
    width:150px;
    height:25 px;
    background-color: #0f8a4c ;
    border-radius: 30px 30px 30px 30px;
    }

</style>
