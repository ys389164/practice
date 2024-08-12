import React from 'react';
import { Link } from 'react-router-dom';
import home from '../assets/imgs/home.png';
import diary from '../assets/imgs/diary.png';
import memo from '../assets/imgs/memo.png';
import calendar from '../assets/imgs/canlendar.png';
import dDay from '../assets/imgs/d-day.png';

export default function Footer() {
    return (
        <footer className="footer">
            <ul className="footer__list">
                <li className="diaryTab">
                    <Link to="/dairy">
                        <img src={diary} alt="일기" />
                    </Link>
                </li>
                <li className="memoTab">
                    <Link to="/memo">
                        <img src={memo} alt="메모" />
                    </Link>
                </li>
                <li className="mainTab">
                    <Link to="/">
                        <img src={home} alt="홈" />
                    </Link>
                </li>
                <li className="calendarTab">
                    {/* <Link to="/calendar"> */}
                    <Link to="#" onClick={()=>{alert("추후 구현 예정입니다.")}}>
                        <img src={calendar} alt="캘린더" />
                    </Link>
                </li>
                <li className="DdayTab">
                    {/* <Link to="/dday"> */}
                    <Link to="#" onClick={()=>{alert("추후 구현 예정입니다.")}}>
                        <img src={dDay} alt="디데이" />
                    </Link>
                </li>
            </ul>
        </footer>
    )
}
