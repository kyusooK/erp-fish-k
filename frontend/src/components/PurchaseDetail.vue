<template>

    <v-card outlined>
        <v-card-title>
            PurchaseDetail
        </v-card-title>

        <v-card-text>
            <Number label="UnitPrice" v-model="value.unitPrice" :editMode="editMode"/>
            <Number label="Qty" v-model="value.qty" :editMode="editMode"/>
            <ItemId offline label="ItemId" v-model="value.itemId" :editMode="editMode" @change="change"/>
        </v-card-text>

        <v-card-actions v-if="inList">
            <slot name="actions"></slot>
        </v-card-actions>
    </v-card>
</template>

<script>

    export default {
        name: 'PurchaseDetail',
        components:{},
        props: {
            value: [Object, String, Number, Boolean, Array],
            editMode: Boolean,
            isNew: Boolean,
            offline: Boolean,
            inList: Boolean,
            label: String,
        },
        data: () => ({
        }),
        async created() {
            if(!Object.values(this.value)[0]) {
                this.$emit('input', {});
                this.newValue = {
                    'unitPrice': '',
                    'qty': '',
                    'itemId': '',
                }
            }
            if(typeof this.value === 'object') {
                if(!('unitPrice' in this.value)) {
                    this.value.unitPrice = 0;
                }
                if(!('qty' in this.value)) {
                    this.value.qty = 0;
                }
            }
        },
        watch: {
            value(val) {
                this.$emit('input', val);
            },
            newValue(val) {
                this.$emit('input', val);
            },
        },

        methods: {
            edit() {
                this.editMode = true;
            },
            async add() {
                this.editMode = false;
                this.$emit('input', this.value);

                if(this.isNew){
                    this.$emit('add', this.value);
                } else {
                    this.$emit('edit', this.value);
                }
            },
            async remove(){
                this.editMode = false;
                this.isDeleted = true;

                this.$emit('input', this.value);
                this.$emit('delete', this.value);
            },
            change(){
                this.$emit('change', this.value);
            },
        }
    }
</script>

