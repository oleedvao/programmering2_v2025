<template id="home-page-template">
  <h1 class="header">Welcome to the Zoo Register!</h1>
  <p>Who let the dogs out?!</p>
</template>

<script>
  app.component("home-page", {
    template: "#home-page-template"
  })
</script>

<style>
  .header {
    color: goldenrod;
    font-size: 50px;
  }
</style>