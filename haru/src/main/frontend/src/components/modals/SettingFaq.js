export default function SettingFaq() {
    return (
        <div class="main" id="main">
        <h2> FAQ</h2>
        <section>
            <div className="Kinds">
                <button>계정</button>
                <button>메모</button>
                <button>일기</button>
                <button>기타</button>
            </div>

            <div className="faqList" id="faqList">
                <ul id="qaList">
                    <li>
                        <button type="button" onClick="onClickEvt(this)" className="">
                            <div className="qIcon">Q</div>
                            <div>
                                <p className="qText">
                                    하이
                                </p>
                            </div>
                        </button>
                        <div className="answer">
                            <div className="answerWrap">
                                <div className="aIcon">A</div>
                                <div>
                                    <div className="aText">
                                        <p>해위</p>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </li>
                </ul>
            </div>
        </section>
        </div>
    )
}