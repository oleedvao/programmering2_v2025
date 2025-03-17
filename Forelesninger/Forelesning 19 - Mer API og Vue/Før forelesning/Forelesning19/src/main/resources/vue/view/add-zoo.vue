<template id="add-zoo-template">
  <h1>Add Zoo</h1>
  <form action="/api/add-zoo" method="post">
    <label for="name">Name:</label><br>
    <input type="text" id="name" name="zoo-name"><br>
    <input type="submit" value="Create">
  </form>
</template>

<script>
  app.component("add-zoo", {
    template: "#add-zoo-template"
  })
</script>