<script lang="ts" setup>

import {IMenuItem} from "~/utils/models/other";

const props = defineProps<{
  item: IMenuItem
}>()

</script>

<template>
  <li class="nav-item">
    <NuxtLink
      v-if="item.type === 'nav-link'"
      :to="item.to"
      :class="[
        'nav-link menu-link',
      ]"
      active-class="active"
    >
      <i v-if="item.icon" :class="item.icon"></i>
      {{ item.label }}
      <template v-if="!!item.extra">
        <span v-if="item.extra.badge" :class="item.extra.badge.class">
          {{ item.extra.badge.label }}
        </span>
      </template>
    </NuxtLink>
    <a
      v-if="item.type === 'collapse'"
      class="nav-link menu-link cursor-pointer"
      data-bs-toggle="collapse"
    >
      <i v-if="item.icon" :class="item.icon"></i>
      {{ item.label }}
      <template v-if="!!item.extra">
        <span v-if="item.extra.badge" :class="item.extra.badge.class">
          {{ item.extra.badge.label }}
        </span>
      </template>
    </a>

    <div
      v-if="item.children?.length > 0"
      :class="['menu-dropdown']"
      id="sidebarLayouts"
    >
      <ul class="nav nav-sm flex-column">
        <template v-for="child in item.children">
          <LayoutsDefaultAppMenuItem :item="child"/>
        </template>
      </ul>
    </div>
  </li>
</template>
