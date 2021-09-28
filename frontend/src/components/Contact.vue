<template>
  <div class="w3-container w3-display-container" id="contact" style="margin-top:75px">
    <div class="para-comp-hl para-comp-hl-contact"></div>
    <h1 class="w3-xxxlarge para-text-blue"><b>Contacto</b><b class="para-text-red"> - </b><b class="para-manda-font para-manda-size">Contacto</b><b class="para-text-red">.</b></h1>
    <hr style="width:50px;border:5px solid #FF4543" class="w3-round">
    <p>¿Quieres ponerte en contacto? Recuerda que Watto no admite devoluciones, no se hace responsable del malfuncionamiento de las piezas y no tramitamos garantías. Después de todo, es material de vertedero.</p>
    <form action="/action_page.php" target="_blank">
      <div class="w3-section">
        <input class="w3-input" type="text" name="Nombre" placeholder="Nombre" required>
      </div>
      <div class="w3-section">
        <input class="w3-input" type="text" name="Correo" placeholder="Correo" required>
      </div>
      <div class="w3-section">
        <input class="w3-input" type="text" name="Mensaje" placeholder="Mensaje" required>
      </div>
      <button type="submit" class="w3-button w3-block w3-padding-large w3-red w3-margin-bottom">Enviar Mensaje</button>
    </form>  
  </div>
</template>

<script>
export default {
  name: 'Contact',
}
</script>