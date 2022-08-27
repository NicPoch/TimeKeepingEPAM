import { useState } from "react";
import axios from "axios";
const Signup = () => {
    const [username, setUsername] = useState("");
    const [password, setPassword] = useState("");
    const [repeatedPassword, setRepeatedPassword] = useState("");

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
    return <article className="login">
        <h1>Sign up</h1>
        <form onSubmit={handleSubmit}>
            <label>
                username&nbsp;
                <input  value={username} onChange={(e)=>{setUsername(e.target.value)}} type="text" />
            </label>
            <label>
                mail&nbsp;
                <input  value={username} onChange={(e)=>{setUsername(e.target.value)}} type="text" />
            </label>
            <label>
                password&nbsp;
                <input  value={password} onChange={(e)=>{setPassword(e.target.value)}} type="password" />
            </label>
            <label>
                repeat password&nbsp;
                <input  value={repeatedPassword} onChange={(e)=>{setRepeatedPassword(e.target.value)}} type="password" />
            </label>
            
            <button type="submit">Sign up</button>
        </form>
        <br/>
    </article>;
};

export default Signup;