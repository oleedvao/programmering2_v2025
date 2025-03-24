<template id="animal-detail-template">
  <h1>{{animal.name}}</h1>
  <p>Species: {{animal.species}}</p>
  <p>Birth date: {{animal.birthDate}}</p>
</template>

<script>
  app.component("animal-detail", {
    template: "#animal-detail-template",
    data: () => ({
      animal: {}
    }),
    created() {
      const animalId = this.$javalin.pathParams["animal-id"];
      fetch(`/api/animal/${animalId}`)
          .then(res => res.json())
          .then(res => {
            this.animal = res
          })
          .catch(() => alert("Error when retrieving Animal information."))
    }
  })
</script>

<style>

</style>