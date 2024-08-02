import React, { useState } from 'react';
import FullCalendar from '@fullcalendar/react';
import dayGridPlugin from '@fullcalendar/daygrid';

export default function Home() {
    const [calenderOpenState, setCalenderOpenState] = useState(false);

    return (
        <div className={calenderOpenState ? "homeContainer active" : "homeContainer"} id="homeContainer">
            <section className="calendarWrap" onClick={() => { setCalenderOpenState(true) }}>
                <FullCalendar
                    plugins={[dayGridPlugin]}
                    initialView="dayGridMonth"
                    height="90%"
                    events={[
                        { date: '2024-08-01', extendedProps: { stamp: '✔️' } },
                        { date: '2024-08-02', extendedProps: { stamp: '❌' } }
                    ]}
                    eventContent={renderEventContent}
                />
            </section>
            <section className="infoWrap">
                <div className="recentSchedule">schedule</div>
                <div className="infoMiddleWrap">
                    <div className="recentMemo">memo</div>
                    <div className="recentDiary">diary</div>
                </div>
            </section>

            <div className='scheduleBtnWrap'>
                <button type='button' className='showSchedule' onClick={() => { setCalenderOpenState(false) }}>X</button>
            </div>
        </div>
    )
}

function renderEventContent(eventInfo) {
    return (
        <>
            <i>{eventInfo.event.extendedProps.stamp}</i>
        </>
    );
}