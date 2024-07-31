import {useDispatch} from "react-redux";
import {changeModalName, modalStateOn} from "../../slices/modalState";
import dayGridPlugin from "@fullcalendar/daygrid";
import FullCalendar from "@fullcalendar/react";
import React from "react";

export default function Dairy() {
    const dispatch = useDispatch();

    const changeModal = (modalName) => {
        dispatch(modalStateOn());
        dispatch(changeModalName(modalName))
    }

    return (
        <div className="dairyContainer" id="dairyContainer">
            <section className="dairyCalendarWrap">
                <div className="dairyCalendar"><FullCalendar
                    plugins={[dayGridPlugin]}
                    initialView="dayGridMonth"
                    height="100%"
                    contentHeight='100px'
                    events={[
                        {date: '2024-08-01', extendedProps: {stamp: '✔'}},
                        {date: '2024-08-02', extendedProps: {stamp: '❌'}}
                    ]}
                    eventContent={renderEventContent}
                /></div>
            </section>
            <section className="diaryInfo" id="diaryInfo">
                <div className="continuityDay" id="continuityDay">N일 연속 작성 중!</div>
                <div className="clickedContents" id="clickedContents" onClick={() => {
                    changeModal('DairyWriting')
                }}>클릭된 날 일기 내용
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
