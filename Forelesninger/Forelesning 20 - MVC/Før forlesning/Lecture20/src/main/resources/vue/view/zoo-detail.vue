<template id="zoo-detail-template">
  <h1>{{zoo.name}}</h1>
  <ul>
    <li v-for="animal in zoo.animals">
      <h2><a :href="`/animal/${animal.id}`">{{animal.name + " - " + animal.species}}</a></h2>
    </li>
  </ul>
</template>

<script>
  app.component("zoo-detail", {
    template: "#zoo-detail-template",
    data: () => ({
      zoo: {}
    }),
    created() {
      const zooName = this.$javalin.pathParams["zoo-name"];
      fetch(`/api/zoo/${zooName}`)
          .then(res => res.json())
          .then(res => {
            this.zoo = res
          })
          .catch(() => alert("Error when retrieving Zoo information"))
    }
  })
</script>