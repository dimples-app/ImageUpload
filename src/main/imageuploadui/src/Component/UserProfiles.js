import React, {useState, useEffect} from "react";
import axios from 'axios'
import DropZone from './DropZone';

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
          <br />
          <br />
          <h3>{userProfile.userName}</h3>
          <p>{userProfile.userProfileID}</p>
          <DropZone userProfileId={userProfile.userProfileId}/>
          <br />
      </div>)
    })
}

export default UserProfiles
