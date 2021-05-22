import React, {useState, useEffect} from "react";
import axios from 'axios'
import DropZone from './DropZone';

function UserProfiles(props) {

   const {userProfileId} = props;
 
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
        {userProfile.userProfileID ? ( < img src={`http://localhost:8080/api/v1/user-profile/${userProfileId}/image/upload`}
        />) : null }
          <br />
          <br />
          <h3>Profile Name</h3> 
          <p>{userProfile.userName}</p>
          <h3>Profile ID</h3>
          <p>{userProfile.userProfileID}</p>
          <DropZone {...userProfile}/>
          <br />
      </div>)
    })
}

export default UserProfiles
