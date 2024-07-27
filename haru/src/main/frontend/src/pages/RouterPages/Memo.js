export default function Memo() {
    return (
        <div className="memoContainer" id="memoContainer">
            
            <div class="memoRelatedWrap">
                <section className="searchContainer">
                    <div>
                        <div className="inputBox">
                            <input type="text" id="inputText" className="inputText" name="searchKeyword"
                                   maxlength="20" placeholder="검색어를 입력하세요" value=""/>
                            <button type="button" id="searchBtn" className="searchBtn">검색</button>
                        </div>
                    </div>
                </section>
                <section className="memoFolderContainer">
                    <ul>
                        <li className="memoD normalMemo">normalMemo</li>
                        <li className="memoD calenderMemo">calenderMemo</li>
                        <li className="memoD dDayMemo">dDayMemo</li>
                        <li className="memoD deletedMemo">deletedMemo</li>
                    </ul>
                </section>
            </div>

            <section className="addContainer" id="addContainer">
                <button className="addFolder" id="addFolder">폴더추가</button>
                <button className="addMemo" id="addMemo">메모 작성</button>
            </section>
        </div>
    )
}