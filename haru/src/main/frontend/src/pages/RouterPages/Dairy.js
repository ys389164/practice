import { useDispatch } from "react-redux";
import { changeModalName, modalStateOn } from "../../slices/modalState";
export default function Dairy() {
    const dispatch = useDispatch();

    const changeModal = (modalName) => {
        dispatch(modalStateOn());
        dispatch(changeModalName(modalName))
    }

    return (
        <div className="dairyContainer" id="dairyContainer">
            <section className="dairyCalendarWrap">
                <div className="dairyCalendar">calendar</div>
            </section>
            <section className="diaryInfo" id="diaryInfo">
                <div className="continuityDay" id="continuityDay">N일 연속 작성 중!</div>
                <div className="clickedContents" id="clickedContents" onClick={()=>{changeModal('DairyWriting')}}>클릭된 날 일기 내용</div>
            </section>
        </div>
    )
}