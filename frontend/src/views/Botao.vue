<template>
  <div class="botao">
    <h1>Alerta</h1>
        <div id='botaoAlerta'>
    <button class='botaoAlerta' v-on:click='greet'>Alerta</button>
    </div>
  </div>
</template>
<script>
export default {
    
}
var alerta = new Vue({
  el: '#botaoAlertas',
  data: {
    name: 'Você me clicou'
  },
  methods: {
    greet: function (event) {
      alert('Olá ' + this.name + '!')
      if (event) {
        alert(event.target.tagName)
      }
    }
  }
})

alerta.greet() 
</script>
