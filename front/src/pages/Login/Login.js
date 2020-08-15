import React from 'react';
import "./Login.css"

const Login = () => {

  const handleSubmit = (e) => {
    alert("Go to backend")
    e.preventDefault()
  }

  return (
    <div className="login-container">
      <div className="login-container__content">
        <h2>          
          <span>¡Hola!</span>
        </h2>
        <p>
          Ingrese sus datos para ingresar al sistema.
        </p>
        <div>
          <form className="login-container__form" onSubmit={handleSubmit}>              
            <input className="input-primary" type="text" placeholder="Email" />
            <input className="input-primary" type="text" placeholder="Contraseña" />            
            <input className="btn-primary btn-scs" type="submit" value="Acceder" />
          </form>
        </div>
      </div>
      <div className="login-container__picture" />              
    </div>
  )

}

export default Login