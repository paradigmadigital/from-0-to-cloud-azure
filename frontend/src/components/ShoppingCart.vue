<template>
  <div id="shoppingSideBar" class="para-shopping-cart" v-bind:class="{ 'para-sideopen': this.openCart }">
    <div class="para-comp-hl"></div>
    <span class="w3-button para-black w3-xxlarge w3-display-topright" style="z-index:40" v-on:click="toggleSideShoppingCart()">×</span>
    <div class="w3-container" id="showcase">
      <h1 class="w3-display-container w3-xxxlarge w3-text-white para-min-container">
        <b>Carrito</b><b class="para-text-red"> - </b><b class="para-manda-font para-manda-size">Carrito</b><b class="para-text-red">.</b>
      </h1>
      <hr style="width:50px;border:5px solid #FF4543" class="w3-round">
      <ul id="cartContainer" class="w3-ul w3-white w3-center" v-bind:key="item.id" v-for="item in itemsInCart">
        <li :id="item.id" class="w3-padding-16" style="height: 160px; position: relative;">
          <div class="w3-half">
            <img :src="item.img" class='para-cart-img para-shop-item' :alt="item.alttext">
          </div>
          <div class="w3-half">
            <p>{{item.name}}</p>
            <span>{{parseFloat(item.price).toFixed(2)}}€</span>
            <br/>
            <span>Cantidad: {{item.amount}}</span>
          </div>
          <span class="w3-button para-black w3-large w3-display-topright" style="position:absolute" v-on:click="removeItemFromCart(item.id)">×</span>
        </li>
      </ul>
      <ul class="w3-ul w3-light-grey w3-center">
        <li class="w3-padding-16">
          <span class="w3-opacity">Total</span>
          <h2 id="totalCart">{{this.totalprice}}€</h2>
        </li>
        <li class="w3-light-grey w3-padding-24">
          <button class="w3-button w3-white w3-padding-large w3-hover-black" v-on:click="getOrder()">Tramitar Compra</button>
        </li>
      </ul>
    </div>
  </div>
</template>

<script>
export default {
  name: 'ShoppingCart',
  props: {
    openCart: Boolean,
    totalprice: Number,
    itemsInCart: Array,
  },
  methods:{
    toggleSideShoppingCart: function(){
      this.$emit("ShowCart", false);
    },
    removeItemFromCart: function(id){
      this.$emit("removeItemFromCart", id);
    },
    getOrder: function(){
      this.$emit("sendOrder");
    }
  }
}
</script>