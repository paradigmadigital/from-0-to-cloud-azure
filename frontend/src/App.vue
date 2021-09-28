<template>
  <div id="app">
    <SideBar />
    <div class="w3-main" style="margin-left:340px;margin-right:40px">
      <Header />
      <Title @ShowCart="toggleCart()" />
      <ItemCard :hasError="this.servError" :data="this.shopItems" @addItemToCart="addToCart"/>
      <ModalFullSize />
      <ShoppingCart 
        @ShowCart="toggleCart"
        @removeItemFromCart="removeFromCart"
        @sendOrder="sendOrder"
        :openCart="this.showCart" 
        :totalprice="this.totalCart" 
        :itemsInCart="this.cart"
      />
      <Services />
      <SpecialPackages />
      <Contact />
    </div>
    <Footer />
  </div>
</template>

<script>
import Contact from './components/Contact.vue';
import Header from './components/Header.vue';
import ItemCard from './components/ItemCard.vue';
import Footer from './components/Footer.vue';
import ModalFullSize from './components/ModalFullSize.vue';
import Services from './components/Services.vue';
import ShoppingCart from './components/ShoppingCart.vue';
import SideBar from './components/SideBar.vue';
import SpecialPackages from './components/SpecialPackages.vue';
import Title from './components/Title.vue';

import axios from "axios";
import configConst from './env/config.js';
import utils from './services/utils.js';
import services from './services/services.js';

export default {
  components: {
    Contact,
    Header,
    ItemCard,
    ModalFullSize,
    Footer,
    Services,
    ShoppingCart,
    SideBar,
    SpecialPackages,
    Title
  },
  name: 'App',
  data() {
    return{
      cart: [],
      servError: false,
      shopItems: [],
      showCart: false,
      totalCart: 0,
      order:{
        id: '',
        orderLines:[]
      }
    }
  },
  mounted: function(){
    let url = `${configConst.PRO}${configConst.BASEURL}${configConst.ITEMS}`;
    let self = this;
    axios.get(url)
    .then(function (response) {
      console.log(response.data._embedded);
      self.shopItems = response.data._embedded.items;
      if (response.data._embedded.items.lenght === 0){
        self.servError = true;
      }
    })
    .catch(function (error) {
        console.log(error);
        self.servError = true;
    });
  },
  methods: {
    //Add element to the basket case for internal use
    addToCart: function (elem){
      let data = {
        id: elem.id,
        img: elem.img,
        name: elem.name,
        price: parseFloat(elem.price).toFixed(2),
        amount: 1
      };
      this.totalCart = this.totalCart + elem.price;
      let pos = this.checkCart(elem.id);
      this.updateCart(this.searchItem(elem.id), pos);
      if (pos !== false){
        this.cart[pos].amount++;
        this.cart[pos].price = elem.price;
        return;
      }
      this.cart.push(data);	
    },

    checkCart: function(id){
      for (let i = 0; i < this.cart.length; i++){
        if (this.cart[i].id === id){
          return i;
        }
      }
      return false;
    },

    removeFromCart: function(id){
      let ele = this.checkCart(id);
      let url = `${configConst.PRO}${configConst.BASEURL}${configConst.ORDERS}/${id}`;
      services.del(url);
      this.totalCart = this.totalCart - (this.cart[ele].price * this.cart[ele].amount);
      this.cart.splice(ele, 1);
    },

    //Search and return the item into the dataset if the id exist
    searchItem: function(id){
      for (let i = 0; i < this.shopItems.length; i++){
        if (this.shopItems[i].id === id){
          return this.shopItems[i];
        }
      }
      return false;
    },
    //Finalize the buy and clean the internal and visual cart
    sendOrder: function(){
      if (this.totalCart > 0){
        console.log('Se ha comprado los items y se resetea la compra.');
        this.totalCart = 0;
        this.cart = [];
        return;
      }
      console.log('El carrito está vacio');
      return;
    },
    toggleCart: function(){
      this.showCart = !this.showCart;
    },
    //Add item to backend cart
    updateCart: function(item, isOrdered){   
      if (isOrdered === false){
        item.quantity = 1;
        this.order.id = utils.makeid(24);
        this.order.orderLines.push(item);
        let url = `${configConst.PRO}${configConst.BASEURL}${configConst.ORDERS}`;
        services.add(url, this.order);
      }
      else{
          item.quantity = this.cart[isOrdered].amount + 1;
          let url = `${configConst.PRO}${configConst.BASEURL}${configConst.ORDERS}/${item.id}`;
          services.update(url, this.order);
      }	
      return;
    }
  }
}
</script>

<style>
@import './assets/css/w3.css';
@import './assets/css/main.css';

body,h1,h2,h3,h4,h5 {font-family: "Roboto", sans-serif}
body {font-size:16px;}
.w3-half img{margin-bottom:-6px;margin-top:16px;opacity:0.8;cursor:pointer}
.w3-half img:hover{opacity:1}
</style>
