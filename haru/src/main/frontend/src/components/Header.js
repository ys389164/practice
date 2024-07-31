import React from "react";
import { Link } from 'react-router-dom';
import logo from "../assets/imgs/logo.png";

export default function Header() {
    return (
        <header className="header" id="header">
            <h1 className="logo" id="logo">
                <Link to="/">
                    {/* header */}
                    <img src={logo} alt="로고이미지" />
                </Link>
            </h1>

            <div className="goSettingBtnWrap">
                <Link to="/setting" className="settingBtnLink">
                    <button type="button" className="settingBtn"  id="settingBtn">Setting</button>
                </Link>
            </div>
        </header>
    )
}
