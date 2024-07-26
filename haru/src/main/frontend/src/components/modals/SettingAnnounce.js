export default function SettingAnnounce() {
    return (
        <div class="main" id="main">
        <h2> FAQ</h2>
        <section>
            <div className="announceWrap" id="announceWrap">
                <ul id="announceList">
                    <li>
                        <button type="button" onClick="onClickEvt(this)" className="">
                            <h3>0.0.1v 제목</h3>
                        </button>
                        <div className="contents">
                                <p>0.0.1v 내용</p>
                        </div>
                    </li>
                </ul>
            </div>
        </section>
        </div>
    )
}