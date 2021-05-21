import React, {useState, useEffect} from "react";
import axios from 'axios'

function UserProfiles(props) {

    const [userProfiles, setUserProfiles] = useState([]);

    const fetchUserProfiles =() => {
        axios.get("http://localhost:8080/api/v1/user-profile")
        .then(resp => {
          console.log(resp);
          setUserProfiles(resp.data);
        });
      }
    
      useEffect(() => {
        fetchUserProfiles();
      }, [])

    return userProfiles.map((userProfile, index) => {
      return (
      <div key={index}>
          <h3>{userProfile.userName}</h3>
           <p>{userProfile.userProfileID}</p>
      </div>)
    })
}

export default UserProfiles
