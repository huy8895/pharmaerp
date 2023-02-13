<script lang="ts" setup>
import {ref} from "vue";

let isShow = ref<boolean>(false);

const props = defineProps<{
  dropdownClass?: string
}>()

const openDropdown = () => {
  if (!isShow.value) {
    isShow.value = true;
    window.addEventListener('mouseup', closeDropdown)
  }
}

const closeDropdown = () => {
  isShow.value = false;
  window.removeEventListener('mouseup', closeDropdown)
}

</script>

<template>
  <div class="dropdown ms-1 topbar-head-dropdown header-item">
    <button
      type="button"
      :class="[
        'btn btn-icon btn-topbar btn-ghost-secondary rounded-circle',
        isShow ? 'show' : ''
      ]"
      @click="openDropdown()"
    >
      <slot name="button"/>
    </button>
    <div
      :class="[
        'dropdown-menu dropdown-menu-end',
        dropdownClass || '',
        isShow ? 'show' : ''
      ]"
      style="position: absolute; inset: 0 0 auto auto; margin: 0; transform: translate(0px, 58px);"
    >
      <slot name="dropdown"/>
    </div>
  </div>
</template>
