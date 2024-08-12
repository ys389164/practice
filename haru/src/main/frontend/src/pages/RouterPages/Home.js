import React, { useEffect, useState } from 'react';
import FullCalendar from '@fullcalendar/react';
import dayGridPlugin from '@fullcalendar/daygrid';
import { getCalenderSomeNone, getRecentBundle } from '../../composable/api/homeAPI';
import { useDispatch } from 'react-redux';
import { changeModalName, modalStateOn } from '../../slices/modalState';

export default function Home() {
    const dispatch = useDispatch();
    const [changeState, setChangeState] = useState(false);

    // 캘린더 크기 변경
    const [calenderOpenState, setCalenderOpenState] = useState(false);
    // 캘린더 스탬프 API 데이터 저장
    const [homeData, setHomeData] = useState([]);
    // 스탬프 객체 저장 데이터
    const [homeObjData, setHomeObjData] = useState([]);

    // 메모 API 데이터 저장
    const [memoAndDiaryAPIData, setMemoAndDiaryAPIData] = useState({});
    // 다이어리 태그
    const [diaryTag, setDiaryTag] = useState(null);

    // 현재 연도 및 월 상태
    const [currentYear, setCurrentYear] = useState(new Date().getFullYear());
    const [currentMonth, setCurrentMonth] = useState(new Date().getMonth() + 1);

    // 날짜 변경 시 호출
    const changeDate = async (datesSetInfo) => {
        const newYear = datesSetInfo.view.currentStart.getFullYear();
        const newMonth = datesSetInfo.view.currentStart.getMonth() + 1;
        console.log(`연도: ${newYear}, 월: ${newMonth}`);
        
        if (newYear === currentYear && newMonth === currentMonth) {
            // 현재 월과 연도가 바뀌지 않았으면 데이터를 다시 가져올 필요 없음
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

    // 캘린더 데이터 생성
    function setNewHomeData(year, month) {
        const today = new Date();
        const todayYear = today.getFullYear();
        const todayMonth = today.getMonth() + 1;
        const todayDate = today.getDate();

        const newHomeData = homeData.map((item, idx) => {
            const day = idx + 1; // 1일부터
            const dateStr = `${year}-${month < 10 ? "0" + month : month}-${day < 10 ? "0" + day : day}`;
            
            // 현재 날짜 이후의 날짜는 스탬프를 추가하지 않음
            const isFutureDate = (year > todayYear) ||
                                  (year === todayYear && month > todayMonth) ||
                                  (year === todayYear && month === todayMonth && day > todayDate);

            if (isFutureDate) {
                // 미래 날짜에는 스탬프를 추가하지 않음
                return { date: dateStr, extendedProps: { stamp: '' } };
            }

            return {
                date: dateStr,
                extendedProps: { stamp: item === 'F' ? '❌' : '✔️' }
            };
        });
        setHomeObjData(newHomeData);
    }

    // 메모 및 다이어리 데이터 설정
    function setTodayMemo(mdData){
        if(mdData.diaryContents === '아직 작성 안 됨'){
            // setDiaryTag(<DiaryWriting>{mdData.diaryContents}</DiaryWriting>)
        }
        // console.log(mdData);
        // if()
    }

    // 다이어리 작성 모달 닫기
    function closeDiaryWritingModal(val){
        setDiaryTag(null);
    }

    // 데이터 fetch
    useEffect(() => {
        const fetchData = async () => {
            try {
                const calenderDataTF = await getCalenderSomeNone(currentYear, currentMonth);
                const memoAndDiaryData = await getRecentBundle();
                setHomeData(calenderDataTF);
                setMemoAndDiaryAPIData(memoAndDiaryData);
                setChangeState(prevState => !prevState);
            } catch (error) {
                console.error('Error fetching data:', error);
            }
        };
        fetchData();
    }, [currentYear, currentMonth]);

    // 상태 업데이트 시 새로운 데이터 설정
    useEffect(() => {
        setNewHomeData(currentYear, currentMonth);
        setTodayMemo(memoAndDiaryAPIData);
    }, [changeState, currentYear, currentMonth]);

    return (
        <div className={calenderOpenState ? "homeContainer active" : "homeContainer"} id="homeContainer">
            <section className="calendarWrap" onClick={() => { setCalenderOpenState(true) }}>
                <FullCalendar
                    plugins={[dayGridPlugin]}
                    initialView="dayGridMonth"
                    height="90%"
                    events={homeObjData}
                    datesSet={changeDate}
                    eventContent={renderEventContent}
                />
            </section>
            <section className="infoWrap">
                <div className="recentSchedule">schedule</div>
                <div className="infoMiddleWrap">
                    <div className="recentMemo">memo</div>
                    <div className="recentDiary" onClick={()=>{
                        if(memoAndDiaryAPIData.diaryContents === '아직 작성 안 됨'){
                            dispatch(changeModalName('DairyWriting'))
                            dispatch(modalStateOn());
                        }
                    }}>
                        {memoAndDiaryAPIData.diaryContents}
                    </div>
                </div>
            </section>

            <div className='scheduleBtnWrap'>
                <button type='button' className='showSchedule' onClick={() => { setCalenderOpenState(false) }}>X</button>
            </div>

            {diaryTag}
        </div>
    );
}

function renderEventContent(eventInfo) {
    return (
        <div>
            <i>{eventInfo.event.extendedProps.stamp}</i>
        </div>
    );
}
