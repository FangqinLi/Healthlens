<template>
  <div class="login-page container">
    <h2 class="text-center">Login</h2>
    <form @submit.prevent="handleLogin" class="login-form">
      <div class="form-group">
        <label for="username">Username</label>
        <input
          type="text"
          id="username"
          v-model="username"
          class="form-control"
          placeholder="Enter your username"
          required
        />
      </div>
      <div class="form-group">
        <label for="password">Password</label>
        <input
          type="password"
          id="password"
          v-model="password"
          class="form-control"
          placeholder="Enter your password"
          required
        />
      </div>
      <button type="submit" class="btn btn-primary btn-block">Log In</button>
    </form>
  </div>
</template>

<script>
export default {
  data() {
    return {
      username: '',
      password: '',
    };
  },
  methods: {
    handleLogin() {
      // Basic login validation (this would be more complex in real apps)
      if (this.username === 'admin' && this.password === 'password') {
        // Redirect to the home page after successful login
        this.$router.push('/home');
      } else {
        alert('Invalid username or password');
      }
    },
  },
};
</script>

<style scoped>
html, body {
  height: 100%;
  margin: 0;
  display: flex;
  justify-content: center;
  align-items: center;
  background-color: #f7f7f723;
}

.login-page {
  position: absolute; /* Centering the login page */
  top: 50%; /* Position from the top */
  left: 50%; /* Position from the left */
  width: 100%;
  max-width: 400px;
  padding: 50px;
  background-color: #fff;
  border-radius: 5px;
  box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
  transform: translate(-50%, -50%);
}

h2 {
  margin-bottom: 30px;
  text-align: center;
}

button {
  margin-top: 15px;
  display: block;
  width: 100%;
}
</style>
