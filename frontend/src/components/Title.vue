<template>
  <div class="w3-container w3-display-container" id="showcase">
    <div class="para-comp-hl para-comp-hl-title"></div>
    <p class="w3-center">
      <img style="width: 75px;" src="../assets/img/Watto-Silohuette.png"/>
    </p>
    <h1 class="w3-center para-jumbo para-text-blue para-title-font"><b>Unauthorized Junk Parts Dealer</b><b class="para-text-red">.</b></h1>
    <h1 class="w3-center para-jumbo para-text-blue"><b class="para-text-red">-</b> Tatooine <b class="para-text-red">-</b></h1>
    <h1 class="w3-display-container w3-xxxlarge para-text-blue para-min-container">
      <b>Muestrario</b><b class="para-text-red"> - </b><b class="para-manda-font para-manda-size">Muestrario</b><b class="para-text-red">.</b>
      <div class="para-comp-hl para-comp-hl-cart-icon"></div>
      <img class="w3-display-topright para-card-icon" src="../assets/img/Card.png" alt="Carrito Compra" v-on:click="toggleSideShoppingCart()"/>
    </h1>
    <hr style="width:50px;border:5px solid #FF4543" class="w3-round">
  </div>
</template>

<script>
export default {
  name: 'Title',
  props: {
    msg: String
  },
  methods:{
    toggleSideShoppingCart: function(){
      this.$emit("ShowCart", true);
    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>

</style>