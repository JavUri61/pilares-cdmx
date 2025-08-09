<template>
  <div id="app">
    <header class="app-header">
      <img alt="PILARES Logo" src="./assets/logo.png" class="logo">
      <h1>Sistema de Recomendación PILARES CDMX</h1>
    </header>
    
    <main class="app-main">
      <router-view/>
    </main>

    <footer class="app-footer">
      <p>© 2023 Gobierno de la Ciudad de México</p>
    </footer>
  </div>
</template>

<script>
export default {
  name: 'App'
}
</script>

<style>
/* Estilos base */
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  display: flex;
  flex-direction: column;
  min-height: 100vh;
}

.app-header {
  background-color: #2c3e50;
  color: white;
  padding: 1rem;
}

.app-main {
  flex: 1;
  padding: 2rem;
}

.app-footer {
  background-color: #2c3e50;
  color: white;
  padding: 1rem;
}

.logo {
  height: 60px;
  margin-bottom: 1rem;
}
</style>