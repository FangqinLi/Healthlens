<template>
  <div class="home-page">
    <header class="navbar navbar-expand-md navbar-dark bg-dark mb-auto">
      <div class="container">
        <!-- Align "HealthLens" to the leftmost -->
        <a class="navbar-brand" href="#">HealthLens</a>
        
        <!-- Toggler for responsive design -->
        <button
          class="navbar-toggler"
          type="button"
          data-toggle="collapse"
          data-target="#navbarCollapse"
          aria-controls="navbarCollapse"
          aria-expanded="false"
          aria-label="Toggle navigation"
        >
          <span class="navbar-toggler-icon"></span>
        </button>
        
        <div class="collapse navbar-collapse" id="navbarCollapse">
          <!-- Use ml-auto to push nav items to the right -->
          <ul class="navbar-nav ml-auto"> 
            <li class="nav-item active">
              <a class="nav-link" href="#">Home</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="#">Features</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="#">Log out</a>
            </li>
          </ul>
        </div>
      </div>
    </header>

    <main role="main" class="container">
      <div class="cover-container d-flex h-100 p-3 mx-auto flex-column">
        <div class="text-center">
          <h1 class="cover-heading">Welcome to HealthLens.</h1>
          <p class="lead">
            You are now logged in. Explore the features and get started on your
            health journey.
          </p>
          <p class="lead">
            <a href="#" class="btn btn-lg btn-secondary">Get Started</a>
          </p>
        </div>
      </div>
    </main>

    <footer class="mastfoot mt-auto text-center">
    </footer>
  </div>
</template>

<script>
export default {
  name: "HomePage",
};
</script>

<style scoped>
.home-page {
  position: absolute;
  top: 0; /* Align to the top */
  left: 0; /* Align to the left */
  width: 100%; /* Full width */
  height: 100%; /* Full height */
  display: flex; /* Enable Flexbox */
  flex-direction: column; /* Arrange children vertically */
  justify-content: center; /* Center vertically */
  align-items: center; /* Center horizontally */
  background-color: #212529; 
  color: white; 
}
</style>
