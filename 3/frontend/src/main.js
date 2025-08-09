import Vue from 'vue'
import App from './App.vue'
import router from './router'
import axios from 'axios'

// Configuración global de axios
axios.defaults.baseURL = process.env.VUE_APP_API_URL || 'http://localhost:8080/api'
axios.defaults.headers.common['Accept'] = 'application/json'

Vue.config.productionTip = false

// Filtro global para formatear distancias
Vue.filter('formatDistance', function(value) {
  if (!value) return '0 km'
  return `${(value / 1000).toFixed(1)} km`
})

new Vue({
  router,
  render: h => h(App),
}).$mount('#app')