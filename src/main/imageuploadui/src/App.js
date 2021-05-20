import React, {useState, useEffect} from "react";
import './App.css';
import axios from 'axios'
import UserProfiles from './Component/UserProfiles';

function App() {
  return (
    <div className="App">
      <UserProfiles />
    </div>
  );
}

export default App;
