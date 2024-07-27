import { useState } from "react"

export default function SettingAnnounce() {
    const [announceItemList, setAnnounceItemList] = useState([
        {
            id:1,
            version: "0.0.1v",
            title: "제목1",
            contents: "내용1",
            active: false
        },
        {
            id:2,
            version: "0.0.2v",
            title: "제목2",
            contents: "내용2",
            active: false
        },
        {
            id:3,
            version: "0.0.3v",
            title: "제목3",
            contents: "내용3",
            active: false
        },

    ]);
    
    function changeActiveState(listItem, listIdx){
        const newAnnounceItemList = [...announceItemList];
        newAnnounceItemList[listIdx].active = !announceItemList[listIdx].active
        setAnnounceItemList(newAnnounceItemList)
    }
    return (
        <div className="settingAnnounceContainer" id="settingAnnounceContainer">
            <div className="settingAnnounceTop">
                <h2> 공지사항</h2>
                <button type="button"> 뒤로가기</button>
            </div>

            <section>
                <div className="announceWrap" id="announceWrap">
                    <ul className="announceList" id="announceList">

                        {
                            announceItemList.map((listItem, listIdx)=>(
                                <li key={listItem + listIdx + listItem.id} className={ listItem.active ? "announceItem active" : "announceItem"}>
                                    <button type="button" onClick={()=>{changeActiveState(listItem, listIdx)}} className="openAnnounceContents">
                                        <h3>{listItem.title}</h3>
                                    </button>
                                    <div className="contents">
                                        <p>{listItem.contents}</p>
                                    </div>
                                </li>   
                            ))
                        }
                        {/* <li className={ announceItemList[0].active ? "announceItem active" : "announceItem"}>
                            <button type="button" onClick={()=>{changeActiveState(announceItemList[0], 0)}} className="openAnnounceContents">
                                <h3>0.0.1v 제목</h3>
                            </button>
                            <div className="contents">
                                <p>0.0.1v 내용</p>
                            </div>
                        </li> */}
                    </ul>
                </div>
            </section>
        </div>
    )
}