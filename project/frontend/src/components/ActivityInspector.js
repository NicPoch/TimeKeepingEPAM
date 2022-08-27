import { useState } from "react";
import axios from "axios";

const ActivityInspector = ()=>{
    const [username, setUsername] = useState("");
    const [password, setPassword] = useState("");
    const handleSubmit = (e) => {
        console.log(username);
        console.log(password);
        e.preventDefault();
        const jsonData = {
            "username": username,
            "password": password}

        axios.post('http://localhost:8080/api/auth/signin',  jsonData, {withCredentials: true, headers: { 'Access-Control-Allow-Origin':'http://localhost:3000','Access-Control-Allow-Credentials':true,'Content-Type': 'application/json' }})
        .then(function (response) {
            console.log(response.headers);
          }); 
    };

    return <article className="activity-inspector">
        <h1>Activity Info</h1>
        <div><strong>Category:</strong></div>
        <div><strong>Activity:</strong></div>
        <div><strong>Description:</strong></div>
        <div><strong>Assignee:</strong></div>
        <div><strong>Status:</strong></div>
        <div><strong>Start date:</strong></div>
        <div><strong>End date:</strong></div>
        <div><strong>Missing hours:</strong></div>
        <div><strong>Completed hours:</strong></div>
        
    </article>;
};

export default ActivityInspector;