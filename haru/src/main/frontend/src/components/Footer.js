export default function Footer() {
    return (
        <footer className="footer">
            <ul className="footer__list">
                <li className="diaryTab">
                    <a href="#">일기
                        <img src="#" alt=""/>
                    </a>
                </li>
                <li className="memoTab">
                    <a href="#">메모
                        <img src="#" alt=""/>
                    </a>
                </li>
                <li className="mainTab">
                    <a href="#">main
                        <img src="#" alt=""/>
                    </a>
                </li>
                <li className="calendarTab">
                    <a href="#">calendar
                        <img src="#" alt=""/>
                    </a>
                </li>
                <li className="DdayTab">
                    <a href="#">d-day
                        <img src="#" alt=""/>
                    </a>
                </li>
            </ul>
        </footer>
    )
}