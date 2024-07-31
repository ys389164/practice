import { useState } from "react";

export default function MemoWriting() {
    const [inputTextVlaue, setInputTextVlaue] = useState('');

    function searchInputValue(evt){
        setInputTextVlaue(evt.target.value);
    }

    return (
        <div className="memoWritingContainer" id="memoWritingContainer">
            <div className="memoWbuttonWraps">
                <button className="memoWBackRouter" id="memoWBackRouter">뒤로가기</button>
                <button className="uploadBtn" id="uploadBtn">완룟</button>
            </div>

            <div className="container" id="container">
                <div className="memotitle" id="memotitle">
                    <input id="inputMemoTitme" className={ inputTextVlaue ? "inputMemoTitme active" : "inputMemoTitme"} type="text" onKeyUp={searchInputValue} />
                    <label for="inputMemoTitme">제목</label>
                </div>

                <div className="memoContents" id="memoContents">
                    <textarea defaultValue="" placeholder="내용을 입력해주세요." />
                </div>
            </div>
        </div>
    )
}