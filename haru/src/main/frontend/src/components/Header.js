export default function header() {
    return (
    <header className="header" id="header">
        <h1 className="logo" id="logo">
            <a href="#">
                header
                {/*<img src="/assets/img/logo.png"/>*/}
            </a>
        </h1>

        <nav className="option" id="option">
            <ul>
                <li className="userSetting" id="userSetting">
                    <a href="#"><img src=""/></a>
                </li>
                <li className="Setting" id="Setting">
                    <a href="#"> <img src=""/></a>
                </li>
            </ul>
        </nav>
    </header>)
}