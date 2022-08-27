import logoEpam from '../resources/logoEpam.svg';
import { useState } from 'react';
import { useNavigate } from "react-router-dom";

const Header = (props) => {
    const [isActive, setIsActive] = useState();
    const navigate = useNavigate();
    let menuSection;
    if (props.userAccess == "admin") {
        menuSection = <>
                        <div onClick={()=>{setIsActive("users"); navigate("/users")}} className={`header__link ${isActive == "users" ? "header__link--active": null}`}>Users</div>
                        <div onClick={()=>{setIsActive("categories"); navigate("/categories")}} className={`header__link ${isActive == "categories" ? "header__link--active": null}`}>Categories</div>
                        <div onClick={()=>{setIsActive("activities"); navigate("/activities")}} className={`header__link ${isActive == "activities" ? "header__link--active": null}`}>Activities</div>
                        <div onClick={()=>{setIsActive("requests"); navigate("/requests")}} className={`header__link ${isActive == "requests" ? "header__link--active": null}`}>Requests</div>
                    </>
    }
    else if (props.userAccess == "user") {
        menuSection = <>
            <div onClick={()=>{setIsActive("dashboard"); navigate("/dashboard")}} className={`header__link ${isActive == "dashboard" ? "header__link--active": null}`}>Dashboard</div>
            <div onClick={()=>{setIsActive("requests"); navigate("/requests")}} className={`header__link ${isActive == "requests" ? "header__link--active": null}`}>Requests</div>
        </>
    }
    else menuSection = "";
    return <header className="header">
        <section className="header__logo"><img className="header__logoEpam" src={logoEpam} />
        <span className='header__title'>Timekeeping</span>
        
        </section>
        <menu className='header__menu'>
        {menuSection}
        </menu>
        </header>
};

export default Header;