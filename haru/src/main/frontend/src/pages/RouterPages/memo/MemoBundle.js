import { useState } from "react"

export default function MemoBundle() {
    const [testMemoDate, setTestMemoDate] = useState(["2024-07-27","2024-07-26","2024-07-25"])
    const [testMemoList, setTestMemoList] = useState([
        {
            date:"2024-07-27",
            title: "제목1",
            contents: "내용1"
        },
        {
            date:"2024-07-27",
            title: "제목2",
            contents: "내용2"
        },
        {
            date:"2024-07-26",
            title: "제목3",
            contents: "내용3"
        },
        {
            date:"2024-07-26",
            title: "제목4",
            contents: "내용5"
        },
        {
            date:"2024-07-26",
            title: "제목6",
            contents: "내용6"
        },
        {
            date:"2024-07-25",
            title: "제목7",
            contents: "내용7"
        },
        {
            date:"2024-07-25",
            title: "제목8",
            contents: "내용8"
        },
        {
            date:"2024-07-25",
            title: "제목9",
            contents: "내용9"
        }
    ])

    return (
        <div className="memoBundleContainer" id="settingBundleOfMemoContainer">
            <section className="searchContainer">
                <button type="button">뒤로가기 </button>
                <div>
                    <div className="inputBox">
                        <input type="text" id="inputText" className="inputText" name="searchKeyword"
                            maxlength="20" placeholder="검색어를 입력하세요" value=""/>
                        <button type="button" id="searchBtn" className="searchBtn">검색</button>
                    </div>
                </div>
            </section>

            <section className="bundleContainer">
                {/* class writingDayBox for문으로 돌려야함 (날짜) */}

                {
                    testMemoDate.map((dateItems, dateIndex)=>(
                        <div key={dateItems + dateIndex} className="writingDayBox">
                            <h3>{dateItems}</h3>
                            <ul>
                            {
                                testMemoList.filter(listItems=> listItems.date === dateItems)
                                .map((mapListItem, mapListItemIdx)=>(
                                    <li key={dateItems + mapListItemIdx + mapListItem}>
                                        <p className="title" id="title">{mapListItem.title}</p>
                                        <p className="contents" id="contents">{mapListItem.contents}</p>
                                    </li>
                                ))
                            }
                            </ul>
                        </div>
                    ))
                }
                {/* <div className="writingDayBox">
                    <h3 className="writingDay" id="writingDay">2024-07-27</h3>
                    <ul>
                        <li>
                            <p className="title" id="title">fdsafdsafdsafdsaf</p>
                            <p className="contents" id="contents">내용</p>
                        </li>
                        <li>
                            <p className="title" id="title">제목</p>
                            <p className="contents" id="contents">내용</p>
                        </li>
                    </ul>
                </div> */}
            </section>

            <section className="bundleInfo" id="bundleInfo">
                <p className="bundleCount" id="bundleCount">메모 개수 : {testMemoList.length}개</p>
                <button className="addMemo" id="addMemo">메모 작성</button>
            </section>
        </div>
    )
}