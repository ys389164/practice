export default function MemoDetail() {
    return (
        <div className="memoDetailContainer" id="memoDetailContainer">
            <div className="memoDetailTop">
                <button type="button" className="goBack">뒤로가기</button>
                <p className="writedTime">작성(수정)된 시간</p>
            </div>
            <div className="detaliContentsBox">
                <p className="memotitle" id="memotitle">제목</p>
                <p className="memocontents" id="memocontents">내용</p>
            </div>
        </div>
    )
}