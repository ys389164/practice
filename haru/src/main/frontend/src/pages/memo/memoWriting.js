export default function MemoWriting() {
    return (
        <body>
        <button className="uploadBtn" id="uploadBtn">완룟</button>

        <div className="container" id="container">
            <div className="memotitle" id="memotitle">
                <input type="text"/> 제목
            </div>
            <div className="memoContents" id="memoContents">
                <textarea>내용</textarea>
            </div>
        </div>
        </body>
    )
}