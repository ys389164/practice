export default function Dairy() {
    return (
        <div class="main" id="main">
            <section className="dairyCalendarWrap">
                <div className="dairyCalendar">calendar</div>
            </section>
            <section class="diaryInfo" id="diaryInfo">
                <div class="continuityDay" id="continuityDay">N일 연속 작성 중!</div>
                <div className="clickedContents" id="clickedContents">클릭된 날 일기 내용</div>
            </section>
        </div>
    )
}