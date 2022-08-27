import { useState } from "react";
import axios from "axios";
import { useNavigate } from "react-router-dom";

const Login = () => {
    const [username, setUsername] = useState("");
    const [password, setPassword] = useState("");
    const navigate = useNavigate(); 
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
        <h1>LOG IN</h1>
        <form onSubmit={handleSubmit}>
            <label>
                username&nbsp;
                <input  value={username} onChange={(e)=>{setUsername(e.target.value)}} type="text" />
            </label>
            <label>
                password&nbsp;
                <input  value={password} onChange={(e)=>{setPassword(e.target.value)}} type="password" />
            </label>
            <button type="submit">Log in</button>
        </form>
        <br/>
        <a href="" onClick={()=>{navigate("/signup")}}>You have not an account yet? Register here</a>
    </article>;
}

export default Login;