import logoEpam from './resources/logoEpam.svg';

const Header = () => {
    return <header className="header">
        <img className="header__logoEpam" src={logoEpam} /><span className='header__title'>TimeKeeping</span>
        </header>;
};

export default Header;