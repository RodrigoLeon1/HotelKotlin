import React from 'react';
import { Switch, Route } from "react-router-dom";

import Login from './pages/Login/Login';
import Home from './pages/Home/Home';
import Dashboard from './components/Dashboard/Dashboard';

const App = () => {
  return (    
    <Switch>
      <Route exact path="/" component={Login} />
      <Route path="/dashboard" component={Dashboard} />      
      {/* <Route component={Login} /> */}
    </Switch>        
  );
}

export default App;
