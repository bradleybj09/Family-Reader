<template>
<div>
    <input v-model="familyName" placeholder="name e.g. 'The Smiths', 'The Robinson Family'"/>
    <input v-model="email" placeholder="email"/>
    <input v-model="password" type="password" placeholder="password"/>
    <input v-model="confirmPassword" type="password" placeholder="confirm password"/>
    <div v-if="errors.length">
      <div v-for="error in errors" :key="error.id">
        {{error}}
      </div>
    </div>
    <v-btn color="primary" dark  @click="validate">Sign Up</v-btn>
    <v-btn color="secondary" light  @click="launchLogin">Back to Login</v-btn>
  </div>
</template>

<script>
import axios from 'axios'
import EventBus from './EventBus'
export default {
  name: 'SignupForm',
  data () {
    return {
      errors: [],
      email: null,
      password: null,
      confirmPassword: null,
      familyName: null
    }
  },
  methods: {
    addNewFamily () {
      console.log('add new user')
      axios({
        method: 'post',
        url: 'http://localhost:8080/capstone/signup',
        data: {
          userName: this.email,
          password: this.password,
          familyName: this.familyName,
          familyId: this.familyId
        }
      }).then(response => {
        this.$session.set('familyId', response.data)
        this.$session.set('personId', null)
        this.$router.push('/homepage')
      }).catch(e => console.log(e))
    },
    launchLogin () {
      this.$router.push('/login')
    },
    validate () {
      this.errors = []
      let emailIsValid = false
      let passwordsMatch = false
      let familyIsValid = false
      if (this.email) {
        let re = /^(([^<>()[\]\\.,;:\s@"]+(\.[^<>()[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/
        emailIsValid = re.test(this.email)
      }
      if (this.familyName) {
        familyIsValid = true
      }
      if (this.password && this.confirmPassword) {
        passwordsMatch = this.password === this.confirmPassword
      }
      if (emailIsValid && passwordsMatch && familyIsValid) {
        this.addNewFamily()
      } else {
        if (!familyIsValid) {
          this.errors.push('Your family name is not valid.')
        }
        if (!emailIsValid) {
          this.errors.push('Email is not in a valid format.')
        }
        if (!passwordsMatch) {
          this.errors.push('Passwords do not match.')
        }
      }
    }
  },
  created () {
    EventBus.$emit('navEvent', 'Sign Up')
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
  div {
    margin: auto;
    max-width: 400px;
    display: flex;
    justify-content: center;
    flex-direction: column;
  }
  input {
    margin: 5px;
  }
  button {
    margin: 5px;
  }
</style>
