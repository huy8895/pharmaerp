export default {
  // Disable server-side rendering: https://go.nuxtjs.dev/ssr-mode
  ssr: false,

  // Target: https://go.nuxtjs.dev/config-target
  target: 'static',

  // Global page headers: https://go.nuxtjs.dev/config-head
  head: {
    title: 'PhamarERP',
    meta: [
      {charset: 'utf-8'},
      {name: 'viewport', content: 'width=device-width, initial-scale=1'},
      {hid: 'description', name: 'description', content: ''},
      {name: 'format-detection', content: 'telephone=no'},
    ],
    link: [{rel: 'icon', type: 'image/x-icon', href: '/favicon.ico'}],
    style: [],
    script: [
      {src: '/velzon/assets/libs/bootstrap/js/bootstrap.bundle.min.js'},
      {src: '/velzon/assets/libs/simplebar/simplebar.min.js'},
      {src: '/velzon/assets/libs/node-waves/waves.min.js'},
      {src: '/velzon/assets/libs/feather-icons/feather.min.js'},
      {src: '/velzon/assets/js/pages/plugins/lord-icon-2.1.0.js'},

      {src: '/velzon/assets/js/plugins.js'},
      {src: '/velzon/assets/libs/dropzone/dropzone-min.js'},
      {src: '/velzon/assets/js/layout.js'},
      {src: '/velzon/assets/js/app.js'},

      {src: '/velzon/assets/libs/list.js/list.min.js'},
      {src: '/velzon/assets/libs/list.pagination.js/list.pagination.min.js'},
      {src: '/velzon/assets/libs/apexcharts/apexcharts.min.js'},
      {src: '/velzon/assets/libs/gridjs/gridjs.umd.js'},
      {src: '/velzon/assets/libs/jsvectormap/js/jsvectormap.min.js'},
      {src: '/velzon/assets/libs/jsvectormap/maps/world-merc.js'},
    ],
    htmlAttrs: {
      // Theme customize
      'data-layout': 'horizontal',
      'data-layout-mode': 'light',
      'data-layout-width': 'fluid',
      'data-layout-position': 'fixed',
      'data-topbar': 'light',
      'data-sidebar-size': 'lg',
      'data-layout-style': 'default',
      'data-sidebar': 'light',
      'data-sidebar-image': 'none',
    }
  },

  // Global CSS: https://go.nuxtjs.dev/config-css
  css: [
    "~/static/velzon/assets/libs/jsvectormap/css/jsvectormap.min.css",
    "~/static/velzon/assets/libs/gridjs/theme/mermaid.min.css",
    "~/static/velzon/assets/libs/dropzone/dropzone.css",
    "~/static/velzon/assets/css/bootstrap.min.css",
    "~/static/velzon/assets/css/icons.min.css",
    "~/static/velzon/assets/css/app_fix.min.css",
    "~/static/velzon/assets/css/custom.min.css",
  ],

  // Plugins to run before rendering page: https://go.nuxtjs.dev/config-plugins
  plugins: [],

  // Auto import components: https://go.nuxtjs.dev/config-components
  components: true,

  // Modules for dev and build (recommended): https://go.nuxtjs.dev/config-modules
  buildModules: [
    // https://go.nuxtjs.dev/typescript
    '@nuxt/typescript-build',
  ],

  // Modules: https://go.nuxtjs.dev/config-modules
  modules: [
    // https://go.nuxtjs.dev/axios
    '@nuxtjs/axios',
    // https://go.nuxtjs.dev/pwa
    '@nuxtjs/pwa',
    // https://go.nuxtjs.dev/content
    '@nuxt/content',
  ],

  // Axios module configuration: https://go.nuxtjs.dev/config-axios
  axios: {
    // Workaround to avoid enforcing hard-coded localhost:3000: https://github.com/nuxt-community/axios-module/issues/308
    baseURL: '/',
  },

  // PWA module configuration: https://go.nuxtjs.dev/pwa
  pwa: {
    manifest: {
      lang: 'en',
    },
  },

  // Content module configuration: https://go.nuxtjs.dev/config-content
  content: {},

  // Build Configuration: https://go.nuxtjs.dev/config-build
  build: {},
}
