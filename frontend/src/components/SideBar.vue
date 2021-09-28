<template>
  <nav class="w3-sidebar para-blue w3-collapse w3-top w3-large w3-padding" style="z-index:3;width:300px;" id="mySidebar"><br>
		<div class="para-comp-hl"></div>
		<a href="javascript:void(0)" v-on:click="w3_close()" class="w3-button w3-hide-large w3-display-topleft" style="width:100%;font-size:22px">Close Menu</a>
		<div class="w3-container">
			<p class="w3-center" style="margin-bottom: 0px;"><img src="../assets/img/Watto-Silohuette-White.png"/></p>
			<h3 class="para-logo-padding para-logo-font para-logo-sidebar">watto shop</h3>
		</div>
		<div class="w3-bar-block">
			<a href="#showcase" v-on:click="w3_close()" class="w3-bar-item w3-button w3-hover-white">Muestrario <b class="para-text-red">-</b> <span class="para-manda-font">Muestrario</span><b class="para-text-red">.</b></a> 
			<a href="#services" v-on:click="w3_close()" class="w3-bar-item w3-button w3-hover-white">Servicios <b class="para-text-red">-</b> <span class="para-manda-font">Servicios</span><b class="para-text-red">.</b></a> 
			<a href="#packages" v-on:click="w3_close()" class="w3-bar-item w3-button w3-hover-white">Paquetes Especiales <b class="para-text-red">-</b> <span class="para-manda-font">Paquetes Especiales</span><b class="para-text-red">.</b></a> 
			<a href="#contact" v-on:click="w3_close()" class="w3-bar-item w3-button w3-hover-white">Contacto <b class="para-text-red">-</b> <span class="para-manda-font">Contacto</span><b class="para-text-red">.</b></a>
		</div>
	</nav>
</template>

<script>
export default {
  name: 'SideBar',
  methods: {
	w3_close: function() {
		document.getElementById("mySidebar").style.display = "none";
		document.getElementById("myOverlay").style.display = "none";
	}
  }
}
</script>