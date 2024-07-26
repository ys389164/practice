import React, {useEffect, useState} from "react";
// import userSetting from './userSetting'

export default function Setting() {

    const [isLoggedIn, setIsLoggedIn] = useState(false)
    const [nickname, setNickname] = useState('')

    useEffect(() => {
        // checkLoginStatus().then(status => setIsLoggedIn(status));
        // getNickname().then(name => setNickname(name));
    }, []);

    return (
        <div class="main" id="main">
            <section className="userInfo" id="userInfo">
                <h3>계정</h3>
                <div>
                    <p>{isLoggedIn ? `${nickname} :` : '게스트'}</p>
                    <p>#random : </p>

                    {isLoggedIn ? <button>계정 관리</button> : <button>가입 / 로그인</button>}
                </div>
            </section>
            <section className="options" id="options">
                <h3>설정</h3>
                <button>백업 및 복구</button>
                <button>txt 파일로 내보내기</button>
                <button>FAQ</button>
                <button>피드백 보내기</button>
                <button>공지사항</button>
                {isLoggedIn && <button>로그아웃</button>}
                <div>'앱 정보' version : 0.0.1v</div>
            </section>
        </div>
    );
}