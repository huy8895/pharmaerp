<script lang="ts" setup>
import { onUnmounted, ref, watch } from "vue";
import { ISidebarSize } from "~/utils/models/other";

const sidebarSize = ref<ISidebarSize>(
  (document.querySelector('html')?.getAttribute('data-sidebar-size') || 'lg') as ISidebarSize
);

const setSidebarSide = (val: ISidebarSize) => {
  sidebarSize.value = val;
}

const setSidebarSideAttribute = (val: ISidebarSize) => {
  const htmlTag = document.querySelector('html');

  if (htmlTag && htmlTag.getAttribute('data-sidebar-size') !== val) {
    htmlTag.setAttribute('data-sidebar-size', val);
  }
}

const calculateSidebarSide = () => {
  setSidebarSide(window.innerWidth >= 678 && window.innerWidth < 1025 ? 'sm' : 'lg');
}

watch(
  sidebarSize,
  setSidebarSideAttribute
)

window.addEventListener('resize', calculateSidebarSide);

onUnmounted(() => {
  window.removeEventListener('resize', calculateSidebarSide);
})

</script>

<template>
  <div>
    <div id="layout-wrapper">
      <LayoutsDefaultAppHeader :sidebar-size="sidebarSize" @setSidebarSide="setSidebarSide" />
      <LayoutsDefaultAppMenu :sidebar-size="sidebarSize" @setSidebarSide="setSidebarSide" />
      <div class="vertical-overlay"></div>
      <div class="main-content">
        <div class="page-content">
          <Nuxt />
        </div>
        <LayoutsDefaultAppFooter />
      </div>
    </div>
  </div>
</template>