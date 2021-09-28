<template>
  <div id="showcaseContainer" class="w3-row-padding w3-display-container">
    <div class='para-half' v-bind:key="item.id" v-for="item in data" >
      <img :src="item.img" v-on:click="showDetails(item, item.id)" class='para-shop-item' :alt="item.alttext">
      <div class='w3-row-padding w3-margin-top'>
        <div class='w3-half'>
          <h3 class='para-h3-font'>{{parseFloat(item.price).toFixed(2) }}€</h3>
        </div>
        <div class='w3-half' style='padding:8px'>
          <button type='button' class='w3-button w3-block w3-padding-small para-blue w3-margin-bottom' v-on:click="addToCart(item)">Añadir</button>
        </div>
      </div>
    </div>

		<div id="showcaseError" v-if="this.hasError">
      <p class="w3-center para-text-blue"><b>Vaya parece que no tenemos productos disponibles, en breve volveremos del basurero con nuevas piezas, no se desconecte.</b><b class="para-text-red">.</b></p>
      <p id="errorMessage" class="w3-center para-text-red para-manda-font para-manda-size">Error 404. No se ha podido encontrar el servicio.</p>
    </div>
  </div>
</template>

<script>
export default {
  name: 'ItemCard',
  props: {
    data: Array,
    hasError: Boolean,
  },
  methods: {

    //Search and return the item into the dataset if the id exist
    searchItem : function(id){
      for (let i = 0; i < this.data.length; i++){
        if (this.data[i].id === id){
          return this.data[i];
        }
      }
      return false;
    },

    // Modal Image Gallery
    showDetails : function(element, id) {
      document.getElementById("img01").src = element.img;
      document.getElementById("modal01").style.display = "block";
      document.getElementById("caption").innerHTML = element.alttext;
      document.getElementById("description").innerHTML = this.searchItem(id).description;
    },

    //Add element to the basket case for internal use
    addToCart: function(elem){
      this.$emit("addItemToCart", elem);  
    }
  }
}
</script>