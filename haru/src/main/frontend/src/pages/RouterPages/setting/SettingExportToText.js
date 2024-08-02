import React from "react";
import { useNavigate } from "react-router-dom";


export default function SettingExportToText() {
    const history = useNavigate();
    const goBack = () => {
        history('/setting');
    }
    return (
        <div className="settingExportToTextContainer" id="settingExportToTextContainer">
            <div className="settingExportToTextTop">
                <h2>txt파일로 내보내기</h2>
                <button type="button" onClick={goBack}> 뒤로가기</button>
            </div>
            <section>
                {/*    종류, 기간, 정렬, 내보내기*/}
                <div className="selectExportWrap">
                    <button className="exportMemo">메모 내보내기</button>
                    <button className="exportDairy">일기 내보내기</button>
                </div>
                <button className="exportAll"> 전체내보내기</button>
            </section>
        </div>
    )
}