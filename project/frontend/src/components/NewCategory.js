import { useState } from "react";
import axios from "axios";

const NewCategory = () => {
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

    

    return <article className="new-category">
        <h1>Create new category</h1>
        <form onSubmit={handleSubmit}>
            <label>
                Name&nbsp;
                <input  value={username} onChange={(e)=>{setUsername(e.target.value)}} type="text" />
            </label>
            <label style={{display:"flex"}}>
                <div>Description&nbsp;</div>
                <textarea rows={5} value={password} onChange={(e)=>{setPassword(e.target.value)}} 
          />
            </label>
            <button type="submit">Create</button>
        </form>
        <br/>
    </article>;
}

export default NewCategory;