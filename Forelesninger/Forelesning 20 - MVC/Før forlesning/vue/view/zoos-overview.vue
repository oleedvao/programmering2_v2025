<template id="zoos-overview-template">
  <h1>All Zoos</h1>
  <ul>
    <li v-for="zoo in listOfZoos" class="list-element">
      <h2><a :href="`/zoo/${zoo.name}`">{{zoo.name}}</a></h2>
    </li>
  </ul>
</template>

<script>
  app.component("zoos-overview", {
    template: "#zoos-overview-template",
    data: () => ({
      listOfZoos: []
    }),
    created() {
      fetch(`/api/all-zoos`)
          .then(res => res.json())
          .then(res => {
            this.listOfZoos = res
          })
          .catch(() => alert("Error while fetching all Zoos"))
    }
  })
</script>

<script>

</script>