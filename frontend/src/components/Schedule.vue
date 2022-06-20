<template>

    <v-card style="width:300px;" outlined>
        <template slot="progress">
            <v-progress-linear
                    color="deep-purple"
                    height="10"
                    indeterminate
            ></v-progress-linear>
        </template>

        <v-img
            style="width:290px; height:150px; border-radius:10px; position:relative; margin-left:5px; top:5px;"
            :style="editMode ? 'cursor:pointer;':''"
            :src="value.photo ? value.photo:'https://cdn.vuetifyjs.com/images/cards/cooking.png'"
            @click="selectFile()"
        ></v-img>

        <v-card-title v-if="value._links">
            Schedule # {{value._links.self.href.split("/")[value._links.self.href.split("/").length - 1]}}
        </v-card-title >
        <v-card-title v-else>
            Schedule
        </v-card-title >

        <v-card-text>
            <div>
                <String label="Title" v-model="value.title" :editMode="editMode"/>
            </div>
            <div>
                <String label="Content" v-model="value.content" :editMode="editMode"/>
            </div>
            <div>
                <String label="Uploader" v-model="value.uploader" :editMode="editMode"/>
            </div>
            <div>
                <Number label="CommentCnt" v-model="value.commentCnt" :editMode="editMode"/>
            </div>
            <div>
                <Number label="BookmarkCnt" v-model="value.bookmarkCnt" :editMode="editMode"/>
            </div>
            <div>
                <Number label="LikeCnt" v-model="value.likeCnt" :editMode="editMode"/>
            </div>
            <div>
                <Boolean label="ReviewWriteYn" v-model="value.reviewWriteYn" :editMode="editMode"/>
            </div>
            <div>
                <Number label="ReviewCnt" v-model="value.reviewCnt" :editMode="editMode"/>
            </div>
        </v-card-text>

        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
                    color="deep-purple lighten-2"
                    text
                    @click="edit"
                    v-if="!editMode"
            >
                Edit
            </v-btn>
            <v-btn
                    color="deep-purple lighten-2"
                    text
                    @click="save"
                    v-else
            >
                Save
            </v-btn>
            <v-btn
                    color="deep-purple lighten-2"
                    text
                    @click="remove"
                    v-if="!editMode"
            >
                Delete
            </v-btn>
            <v-btn
                    color="deep-purple lighten-2"
                    text
                    @click="editMode = false"
                    v-if="editMode && !isNew"
            >
                Cancel
            </v-btn>
        </v-card-actions>
        <v-card-actions>
            <v-spacer></v-spacer>                        
        </v-card-actions>
    </v-card>

</template>

<script>
    const axios = require('axios').default;

    import String from './primitives/String.vue';
    import Number from './primitives/Number.vue';
    import Boolean from './primitives/Boolean.vue';
    import Date from './primitives/Date.vue';

    
    export default {
        name: 'Schedule',
        components:{
            String,
            Number,
            Boolean,
            Date,
        },
        props: {
            value: [Object, String, Number, Boolean, Array],
            editMode: Boolean,
            isNew: Boolean,
            offline: Boolean
        },
        data: () => ({
        }),
        created(){
            if(!this.value) {
                this.value = {};
            }

            if(typeof this.value === 'object') {
                if(!('title' in this.value)) {
                    this.value.title = null;
                }
                if(!('content' in this.value)) {
                    this.value.content = null;
                }
                if(!('uploader' in this.value)) {
                    this.value.uploader = null;
                }
                if(!('commentCnt' in this.value)) {
                    this.value.commentCnt = null;
                }
                if(!('bookmarkCnt' in this.value)) {
                    this.value.bookmarkCnt = null;
                }
                if(!('likeCnt' in this.value)) {
                    this.value.likeCnt = null;
                }
                if(!('reviewWriteYn' in this.value)) {
                    this.value.reviewWriteYn = null;
                }
                if(!('reviewCnt' in this.value)) {
                    this.value.reviewCnt = null;
                }
            }            
        },

        methods: {
            selectFile(){
            if(this.editMode == false) {
                return false;
            }
                var me = this
                var input = document.createElement("input");
                input.type = "file";
                input.accept = "image/*";
                input.id = "uploadInput";
                
                input.click();
                input.onchange = function (event) {
                    var file = event.target.files[0]
                    var reader = new FileReader();

                    reader.onload = function () {
                        var result = reader.result;
                        me.imageUrl = result;
                        me.value.photo = result;
                        
                    };
                    reader.readAsDataURL( file );
                };
            },
            edit() {
                this.editMode = true;
            },
            async save(){
                try {
                    var temp = null;

                    if(!this.offline) {
                        if(this.isNew) {
                            temp = await axios.post(axios.fixUrl('/schedules'), this.value)
                        } else {
                            temp = await axios.put(axios.fixUrl(this.value._links.self.href), this.value)
                        }
                    }

                    if(this.value!=null) {
                        for(var k in temp.data) this.value[k]=temp.data[k];
                    } else {
                        this.value = temp.data;
                    }

                    this.editMode = false;
                    this.$emit('input', this.value);

                    if (this.isNew) {
                        this.$emit('add', this.value);
                    } else {
                        this.$emit('edit', this.value);
                    }

                } catch(e) {
                    alert(e.message)
                }
                location.reload()
            },
            async remove(){
                try {
                    if (!this.offline) {
                        await axios.delete(axios.fixUrl(this.value._links.self.href))
                    }

                    this.editMode = false;
                    this.isDeleted = true;

                    this.$emit('input', this.value);
                    this.$emit('delete', this.value);

                } catch(e) {
                    alert(e.message)
                }
            },
            change(){
                this.$emit('input', this.value);
            },
        },
    }
</script>

