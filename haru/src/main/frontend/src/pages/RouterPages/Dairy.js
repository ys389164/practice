import React, { useEffect, useState } from "react";
import { useDispatch } from "react-redux";
import { changeModalName, modalStateOn } from "../../slices/modalState";
import FullCalendar from "@fullcalendar/react";
import dayGridPlugin from '@fullcalendar/daygrid';
import { getCalenderSomeNone } from '../../composable/api/homeAPI';
import { getDate, getConsecutiveDate, goToWrite } from '../../composable/api/dairyAPI'; // 날짜 정보를 가져오는 함수 가져오기

export default function Dairy() {
    const dispatch = useDispatch();
    const [openCalenderState, setOpenCalenderState] = useState(false);
    const [homeData, setHomeData] = useState([]);
    const [homeObjData, setHomeObjData] = useState([]);
    const [currentYear, setCurrentYear] = useState(new Date().getFullYear());
    const [currentMonth, setCurrentMonth] = useState(new Date().getMonth() + 1);
    const [changeState, setChangeState] = useState(false);
    const [clickedDateData, setClickedDateData] = useState(null); // 클릭된 날짜의 정보 저장
    const [clickedDate, setClickedDate] = useState(''); // 클릭된 날짜를 저장
    const [consecutiveDays, setConsecutiveDays] = useState(0); // 연속 작성 일수 저장

    // 초기 데이터 로딩을 위해 현재 날짜로 데이터 가져오기
    useEffect(() => {
        const fetchData = async () => {
            try {
                const calenderDataTF = await getCalenderSomeNone(currentYear, currentMonth);
                setHomeData(calenderDataTF);
                setChangeState(prevState => !prevState);

                // 현재 날짜의 일기 내용도 가져오기
                const today = new Date();
                const todayStr = formatDateToISO(today);
                setClickedDate(todayStr);

                const dateData = await getDate(todayStr);
                setClickedDateData(dateData);

                // 연속 작성 일 수 가져오기
                const consecutiveData = await getConsecutiveDate();
                setConsecutiveDays(consecutiveData ? consecutiveData : 0);
            } catch (error) {
                console.error('Error fetching data:', error);
            }
        };
        fetchData();
    }, [currentYear, currentMonth]);

    // 날짜 데이터 포맷팅 함수
    function formatDateToISO(date) {
        const year = date.getFullYear();
        const month = String(date.getMonth() + 1).padStart(2, '0');
        const day = String(date.getDate()).padStart(2, '0');
        return `${year}-${month}-${day}`;
    }

    const changeDate = async (datesSetInfo) => {
        const newYear = datesSetInfo.view.currentStart.getFullYear();
        const newMonth = datesSetInfo.view.currentStart.getMonth() + 1;

        if (newYear === currentYear && newMonth === currentMonth) {
            return;
        }

        setCurrentYear(newYear);
        setCurrentMonth(newMonth);

        try {
            const calenderDataTF = await getCalenderSomeNone(newYear, newMonth);
            setHomeData(calenderDataTF);
            setChangeState(prevState => !prevState);
        } catch (error) {
            console.error('Error fetching calendar data:', error);
        }
    };

    function setNewHomeData(year, month) {
        const today = new Date();
        const todayYear = today.getFullYear();
        const todayMonth = today.getMonth() + 1;
        const todayDate = today.getDate();

        const newHomeData = homeData.map((item, idx) => {
            const day = idx + 1;
            const dateStr = `${year}-${month < 10 ? "0" + month : month}-${day < 10 ? "0" + day : day}`;
            const isFutureDate = (year > todayYear) ||
                                 (year === todayYear && month > todayMonth) ||
                                 (year === todayYear && month === todayMonth && day > todayDate);

            if (isFutureDate) {
                return { date: dateStr, extendedProps: { stamp: '' } };
            }

            return {
                date: dateStr,
                extendedProps: { stamp: item === 'F' ? '❌' : '✔️' }
            };
        });
        setHomeObjData(newHomeData);
    }

    useEffect(() => {
        setNewHomeData(currentYear, currentMonth);
    }, [changeState, currentYear, currentMonth]);

    const changeModal = (modalName) => {
        dispatch(modalStateOn());
        dispatch(changeModalName(modalName));
    };

    const handleDateClick = async (info) => {
        const date = new Date(info.event.start); // FullCalendar에서 받은 start 날짜를 Date 객체로 변환
        const dateStr = formatDateToISO(date); // YYYY-MM-DD 형식으로 변환
    
        if (!dateStr) {
            console.error('클릭된 날짜가 유효하지 않습니다.');
            return;
        }
    
        console.log(`클릭된 날짜: ${dateStr}`);
        setClickedDate(dateStr); // 클릭된 날짜 상태 업데이트
    
        try {
            // 클릭된 날짜의 일기 데이터를 가져오기
            const dateData = await getDate(dateStr);
            setClickedDateData(dateData); // 가져온 데이터 상태에 저장
    
            const todayStr = formatDateToISO(new Date()); // 현재 날짜를 YYYY-MM-DD 형식으로 변환
            
            if (!dateData && dateStr === todayStr) {
                // 일기 내용이 없고, 클릭된 날짜가 오늘 날짜인 경우
                const writeStatus = await goToWrite(); // 작성 모달로 넘어가기 전 작성 여부 확인
                if (writeStatus) {
                    changeModal('DairyWriting');
                } else {
                    console.log('일기 작성 여부 확인 실패');
                }
            } else {
                // 일기 내용이 있는 경우 또는 날짜가 오늘이 아닌 경우
                changeModal('DairyDetail'); // 자세히 보기 모달로 넘어가기
            }
        } catch (error) {
            console.error('Error fetching date data:', error);
        }
    };
    

    return (
        <div className={openCalenderState ? "dairyContainer active" : "dairyContainer"} id="dairyContainer">
            <section className="dairyCalendarWrap" onClick={() => { setOpenCalenderState(true) }}>
                <FullCalendar
                    plugins={[dayGridPlugin]}
                    initialView="dayGridMonth"
                    height="90%"
                    events={homeObjData}
                    datesSet={changeDate}
                    eventContent={renderEventContent}
                    eventClick={handleDateClick} // 날짜 클릭 핸들러 추가
                />
            </section>

            <section className="diaryInfo" id="diaryInfo">
                <div className="continuityDay" id="continuityDay">
                    {consecutiveDays}일 연속 작성 중!
                </div>
                <div className="clickedContents" id="clickedContents" onClick={() => { changeModal('DairyWriting') }}>
                    <div>{clickedDate}</div>
                    <div>{clickedDateData ? clickedDateData.contents : "기록이 없습니다"}</div> {/* contents 필드로 업데이트 */}
                </div>
            </section>

            <div className="dairyCalenderCloseBtnWrap">
                <button type="button" className="calenderCloseBtn" onClick={() => { setOpenCalenderState(false) }}>X</button>
            </div>
        </div>
    );
}

function renderEventContent(eventInfo) {
    return (
        <>
            <i>{eventInfo.event.extendedProps.stamp}</i>
        </>
    );
}
