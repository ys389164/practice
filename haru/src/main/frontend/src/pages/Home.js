export default function home() {
    return (
        <div class="main" id="main">
            <section className="calendarWrap">
                <div className="calendar">calendar</div>
            </section>
            <section className="infoWrap">
                <div className="recentSchedule">schedule</div>
                <div className="infoMiddleWrap">
                    <div className="recentMemo">memo</div>
                    <div className="recentDiary">diary</div>
                </div>
            </section>
        </div>
    )
}