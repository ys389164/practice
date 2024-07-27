import { useState } from "react"

export default function SettingFaq() {
    const [qnaList, setQnaList] = useState({
        qustion1:false,
        qustion2:false,
        qustion3:false,
        qustion4:false
    })

    const clickBtnEvt = (qustions) => {
        setQnaList({...qnaList, [qustions]:!qnaList[qustions]})
    }
    
    return (
        <div className="settingFaqContainer" id="settingFaqContainer">
            <div className="settingFaqTop">
                <h2>FAQ</h2>
                <button type="button"> 뒤로가기</button>
            </div>

            <section>
                <div className="Kinds">
                    <button>계정</button>
                    <button>메모</button>
                    <button>일기</button>
                    <button>기타</button>
                </div>

                <div className="faqList" id="faqList">
                    <ul className="qaList" id="qaList">
                        {
                            Object.keys(qnaList).map((mapItem, mapIndex)=>(
                                <li key={mapItem + mapIndex} className={ qnaList[mapItem] ? "qaItem active" : "qaItem"}>
                                    <button type="button" onClick={()=>{clickBtnEvt(mapItem);}} className="">
                                        <img src="#" alt="QIcon" />
                                        <span className="qText">Q</span>
                                        <img src="#" alt="showAnswer" />
                                    </button>

                                    <div className="answerWrap">
                                        <img src="#" alt="aIcon" className="aIcon" />

                                        <div className="aText">
                                            <p>해위</p>
                                        </div>
                                    </div>
                                </li>
                            ))
                        }
                        {/* <li className={ qnaList.qustion1 ? "qaItem active" : "qaItem"}>
                            <button type="button" onClick={()=>{clickBtnEvt("qustion1");}} className="">
                                <img src="#" alt="QIcon" />
                                <span className="qText">Q</span>
                                <img src="#" alt="showAnswer" />
                            </button>

                            <div className="answerWrap">
                                <img src="#" alt="aIcon" className="aIcon" />

                                <div className="aText">
                                    <p>해위</p>
                                </div>
                            </div>
                        </li> */}
                    </ul>
                </div>
            </section>
        </div>
    )
}