export default function Header() {
    return (
        <header className="header" id="header">
            <h1 className="logo" id="logo">
                <a href="#">
                    {/* header */}
                    {/* <img src="/assets/img/logo.png"/> */}
                    <img src="#" alt="로고이미지" />
                </a>
            </h1>

            <div class="goSettingBtnWrap">
                <button type="button" className="settingBtn" id="settingBtn">Setting</button>
            </div>
            {/* <nav className="option" id="option">
                <ul>
                    <li className="userSetting" id="userSetting">
                        <a href="#"><img src=""/></a>
                    </li>
                    <li className="Setting" id="Setting">
                        <a href="#"> <img src=""/></a>
                    </li>
                </ul>
            </nav> */}
        </header>)
}