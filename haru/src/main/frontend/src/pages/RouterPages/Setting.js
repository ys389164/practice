import React, {useEffect, useState} from "react";
import { Link } from 'react-router-dom';
// import userSetting from './userSetting'

export default function Setting() {

    const [isLoggedIn, setIsLoggedIn] = useState(false)
    const [nickname, setNickname] = useState('유우저')

    useEffect(() => {
        // checkLoginStatus().then(status => setIsLoggedIn(status));
        // getNickname().then(name => setNickname(name));
    }, []);

    return (
        <div className="settingContainer" id="settingContainer">
            <section className="userInfo" id="userInfo">
                <h3>계정</h3>
                <div>
                    <img src="#" alt="프로필 이미지"></img>
                    <div className="accountText">
                        <p>{isLoggedIn ? `${nickname}` : '게스트'}</p>
                        <p>jhpark@the-aio.com</p>
                    </div>
                </div>
                {isLoggedIn ? <Link to="/">로그아웃</Link> : <Link to="/">가입 / 로그인</Link>}
            </section>

            <section className="options" id="options">
                <h3>설정</h3>
                <div className="optionsBtnWrap">
                    {isLoggedIn && <Link to="/setting/user">계정관리</Link>}
                    <Link to="/setting/backup">백업 및 복구</Link>
                    <Link to="/setting/export">txt 파일로 내보내기</Link>
                    <Link to="/setting/faq">FAQ</Link>
                    <Link to="/setting/announce">공지사항</Link>
                </div>
                <div className="appVersion">'앱 정보' version : 0.0.1v</div>
            </section>
        </div>
    );
}
