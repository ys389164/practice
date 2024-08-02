import { useDispatch } from "react-redux";
import { changeModalName, modalStateOn } from "../../slices/modalState";
import { useState } from "react";
import FullCalendar from "@fullcalendar/react";
import dayGridPlugin from '@fullcalendar/daygrid';
export default function Dairy() {
    const [openClaenderState, setOpenClaenderState] = useState(false);

    const dispatch = useDispatch();

    const changeModal = (modalName) => {
        dispatch(modalStateOn());
        dispatch(changeModalName(modalName))
    }

    return (
        <div className={openClaenderState ? "dairyContainer active" : "dairyContainer"} id="dairyContainer">
            <section className="dairyCalendarWrap" onClick={() => { setOpenClaenderState(true) }}>
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

            <section className="diaryInfo" id="diaryInfo">
                <div className="continuityDay" id="continuityDay">N일 연속 작성 중!</div>
                <div className="clickedContents" id="clickedContents" onClick={() => { changeModal('DairyWriting') }}>클릭된 날 일기 내용</div>
            </section>

            <div className="dairyCalenderCloseBtnWrap">
                <button type="button" className="calenderCloseBtn" onClick={() => { setOpenClaenderState(false) }}>X</button>
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