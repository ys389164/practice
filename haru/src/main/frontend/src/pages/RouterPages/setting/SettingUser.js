export default function SettingUser() {
    return (
        <div className="settingUserContainer" id="settingUserContainer">
            <div className="settingUserContainerTop">
                <button type="button"> 뒤로가기</button>
                <h2> 계정</h2>
            </div>

            <section className="accountManagements">
                <div>
                    <button>닉네임 변경하기</button>
                    <button>로그인 정보</button>
                    <button>이메일 변경하기</button>
                </div>
                <div><button>데이터 삭제</button></div>
                <div>
                    <button>로그아웃</button>
                    <button>회원 탈퇴</button>
                </div>
            </section>
        </div>
    )
}