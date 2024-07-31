import React from 'react';
import FullCalendar from '@fullcalendar/react';
import dayGridPlugin from '@fullcalendar/daygrid';

export default function home() {
    return (
        <div className="homeContainer" id="homeContainer">
            <section className="calendarWrap">
                <FullCalendar
                    plugins={[dayGridPlugin]}
                    initialView="dayGridMonth"
                    height="100%"
                    contentHeight='100px'
                    events={[
                        {date: '2024-08-01', extendedProps: {stamp: '✔'}},
                        {date: '2024-08-02', extendedProps: {stamp: '❌'}}
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
