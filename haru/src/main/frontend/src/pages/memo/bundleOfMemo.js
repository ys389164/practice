export default function BundleOfMemo() {
    return (
        <body>
        <section className="searchContainer">
            <div>
                <div class="inputBox">
                    <input type="text" id="inputText" class="inputText" name="searchKeyword"
                           maxlength="20" placeholder="검색어를 입력하세요" value=""/>
                    <button type="button" id="searchBtn" class="searchBtn">검색</button>
                </div>
            </div>
        </section>
        <section className="bundleContainer">
            <ul>
                {/*메모 개수만큼 전부 출력*/}
                <li>
                    <div className="title" id="title"></div>
                    <div className="contents" id="contents"></div>
                    <div className="writingDay" id="writingDay"></div>
                </li>

                <li>
                    <div className="title" id="title"></div>
                    <div className="contents" id="contents"></div>
                    <div className="writingDay" id="writingDay"></div>
                </li>
            </ul>
        </section>

        <section className="bundleInfo" id="bundleInfo">
            <p className="bundleInfo" id="bundleInfo">메모 개수</p>
            <button className="addMemo" id="addMemo"></button>
        </section>
        </body>
    )
}