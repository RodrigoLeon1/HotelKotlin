import React from 'react';
import "./Login.scss"

const Login = () => {

  const handleSubmit = (e) => {
    alert("Go to backend")
    e.preventDefault()
  }

  return (
    <div className="login-container">
      <div className="login-container__content">
        <h2>          
          <span>¡Bievenido!</span>
        </h2>
        <p>
          Ingrese sus datos para ingresar al sistema.
        </p>
        <div>
          <form className="login-container__form" onSubmit={handleSubmit}>              
            <input className="input-primary" type="email" name="email" placeholder="Email" required />
            <input className="input-primary" type="password" name="password" placeholder="Contraseña" required />                    
            <input className="btn-primary" type="submit" value="Acceder" />             
          </form>
        </div>
      </div>
      <div className="login-container__picture" />              
    </div>
  )

}

export default Login