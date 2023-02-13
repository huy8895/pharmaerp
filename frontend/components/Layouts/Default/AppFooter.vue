<script lang="ts" setup>
import {ref} from "vue";
import dayjs from "dayjs";

const fullYear = ref<string>(dayjs().format('YYYY'))
</script>

<template>
  <footer class="footer">
    <div class="container-fluid">
      <div class="row">
        <div class="col-sm-6">
          {{fullYear}} © PhamarERP.
        </div>
        <div class="col-sm-6">
          <div class="text-sm-end d-none d-sm-block">
            Design & Develop by Anh Đức Tống Đẹp Trai
          </div>
        </div>
      </div>
    </div>
  </footer>
</template>

