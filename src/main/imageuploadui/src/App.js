import React, {useState, useEffect} from "react";
import './App.css';
import axios from 'axios'

const UserProfiles = () => {
  const fetchUserProfiles =() => {
    axios.get("http://localhost:8080/api/v1/user-profile")
    .then(resp => {
      console.log(resp);
    })
  }

  useEffect(() => {
    fetchUserProfiles();
  }, [])

  return <h1>Hello Image</h1>
}

function App() {
  return (
    <div className="App">
      <UserProfiles />
    </div>
  );
}

export default App;
