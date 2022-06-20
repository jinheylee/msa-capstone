<template>

<v-data-table
    :headers="headers"
    :items="scheduleView"
    :items-per-page="5"
    class="elevation-1"
  ></v-data-table>

</template>

<script>
  const axios = require('axios').default;

  export default {
    name: 'ScheduleView',
    props: {
      value: Object,
      editMode: Boolean,
      isNew: Boolean
    },
    data: () => ({
        headers: [
            { text: "id", value: "id" },
            { text: "commentCnt", value: "commentCnt" },
            { text: "bookmarkCnt", value: "bookmarkCnt" },
            { text: "likeCnt", value: "likeCnt" },
            { text: "reviewCnt", value: "reviewCnt" },
        ],
        scheduleView : [],
    }),
    async created() {
      var temp = await axios.get(axios.backend + '/scheduleviews')

      this.scheduleView = temp.data._embedded.scheduleviews;

    },
    methods: {
    }
  }
</script>

