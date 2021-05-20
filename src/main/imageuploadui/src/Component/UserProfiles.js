import React, {useState, useEffect} from "react";
import axios from 'axios'

function UserProfiles(props) {
    const fetchUserProfiles =() => {
        axios.get("http://localhost:8080/api/v1/user-profile")
        .then(resp => {
          console.log(resp);
        })
      }
    
      useEffect(() => {
        fetchUserProfiles();
      }, [])

    return (
        <React.Fragment>
            <h1>Hello Image</h1>
        </React.Fragment>
    )
}

export default UserProfiles
