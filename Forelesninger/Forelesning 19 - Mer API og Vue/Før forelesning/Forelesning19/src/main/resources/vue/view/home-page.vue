<template id="home-page-template">
  <h1 class="header">Welcome to the Zoo Register!</h1>
</template>

<script>
  app.component("home-page", {
    template: "#home-page-template"
  })
</script>

<style>
  .header {
    color: darkred;
    font-size: 50px;
  }
</style>