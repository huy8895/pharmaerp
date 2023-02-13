<script lang="ts" setup>
import {ref} from "vue";
import {IMenuItem} from "~/utils/models/other";

const items = ref<IMenuItem[]>([
  {
    label: 'Layouts',
    type: 'nav-link',
    to: '/',
    icon: 'bx bx-layout',
    children: [],
    extra: {
      badge: {
        label: 'Hot',
        class: 'badge badge-pill bg-dangers'
      }
    }
  },
  {
    label: 'Pages',
    type: 'collapse',
    icon: 'bx bx-file',
    children: [
      {
        label: 'Pages',
        type: 'collapse',
        children: [
          {
            label: 'Simple Page',
            type: 'nav-link',
            to: '/d'
          },
          {
            label: 'Settings',
            type: 'nav-link',
            to: '/e'
          },
          {
            label: 'Team',
            type: 'nav-link',
            to: '/f'
          },
          {
            label: 'Timeline',
            type: 'nav-link',
            to: '/g'
          },
        ],
      },
      {
        label: 'Starter',
        type: 'nav-link',
        to: '/b'
      },
      {
        label: 'Profile',
        type: 'nav-link',
        to: '/c'
      },
      {
        label: 'Simple Page',
        type: 'nav-link',
        to: '/d'
      },
      {
        label: 'Settings',
        type: 'nav-link',
        to: '/e'
      },
      {
        label: 'Team',
        type: 'nav-link',
        to: '/f'
      },
      {
        label: 'Timeline',
        type: 'nav-link',
        to: '/g'
      },
    ],
    extra: {
      badge: {
        label: 'Hot',
        class: 'badge badge-pill bg-danger'
      }
    }
  }
])

</script>

<template>
  <div class="app-menu navbar-menu">
    <!-- LOGO -->
    <div class="navbar-brand-box">
      <!-- Dark Logo-->
      <a href="index.html" class="logo logo-dark">
        <span class="logo-sm">
          <img src="~/static/velzon/assets/images/logo-sm.png" alt="" height="22">
        </span>
        <span class="logo-lg">
          <img src="~/static/velzon/assets/images/logo-dark.png" alt="" height="17">
        </span>
      </a>
      <!-- Light Logo-->
      <a href="index.html" class="logo logo-light">
        <span class="logo-sm">
          <img src="~/static/velzon/assets/images/logo-sm.png" alt="" height="22">
        </span>
        <span class="logo-lg">
          <img src="~/static/velzon/assets/images/logo-light.png" alt="" height="17">
        </span>
      </a>
      <button type="button" class="btn btn-sm p-0 fs-20 header-item float-end btn-vertical-sm-hover"
              id="vertical-hover">
        <i class="ri-record-circle-line"></i>
      </button>
    </div>

    <div id="scrollbar">
      <div class="container-fluid">
        <div id="two-column-menu"></div>
        <ul class="navbar-nav" id="navbar-nav">
          <template v-for="item in items">
            <LayoutsDefaultAppMenuItem :item="item"/>
          </template>
        </ul>
      </div>
      <!-- Sidebar -->
    </div>

    <div class="sidebar-background"></div>
  </div>
</template>

