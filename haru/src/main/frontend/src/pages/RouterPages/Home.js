export default function home() {
    return (
        <div className="homeContainer" id="homeContainer">
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