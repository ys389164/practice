import React from "react";
import {useNavigate} from "react-router-dom";


export default function SettingBackup(){
    const history = useNavigate();
    const goBack = () =>{
        history('/setting');
    }

    return (
        <div className="settingBackupContainer" id="settingBackupContainer">
            <div className="settingUserBackupTop">
                <h2> 계정</h2>
                <button type="button" onClick={goBack}> 뒤로가기</button>
            </div>

            <section className="settingUserBackupMid">
                <p>google Drive에 데이터를 수동으로 백업하여 기기가 변경되어도 간편하게 복구할 수 있습니다.</p>

                <div className="buttonWrap" id="buttonWrap">
                    <button>백업</button>
                    <button>복구</button>
                </div>
            </section>
        </div>
    )
}