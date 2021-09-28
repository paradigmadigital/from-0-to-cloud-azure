<template>
  <div id="modal01" class="w3-modal w3-black" style="padding-top:0" onclick="this.style.display='none'">
    <span class="w3-button w3-black w3-xxlarge w3-display-topright">×</span>
    <div class="w3-modal-content w3-animate-zoom w3-center w3-transparent w3-padding-64">
      <img id="img01" class="w3-image">
      <p id="caption"></p>
      <p id="description"></p>
    </div>
  </div>
</template>

<script>
export default {
  name: 'ModalFullSize',
  props: {
    msg: String
  }
}
</script>