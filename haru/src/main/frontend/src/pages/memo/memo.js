export default function Memo() {
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
        <section className="memoFolderContainer">
            <ul>
                <li className="normalMemo">normalMemo</li>
                <li className="calenderMemo">calenderMemo</li>
                <li className="dDayMemo">dDayMemo</li>
                <li className="deletedMemo">deletedMemo</li>
            </ul>

        </section>

        <section className="addContainer" id="addContainer">
            <button className="addFolder" id="addFolder"></button>
            <button className="addMemo" id="addMemo"></button>
        </section>
        </body>
    )
}