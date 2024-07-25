import React, { useState } from 'react';
import Modal from '../../components/diaryModal';

export default function DairyWriting() {
    const [show, setShow] = useState(false);

    const showModal = () => {
        setShow(true);
    };

    const hideModal = () => {
        setShow(false);
    };

    return (
        <body>
        <section className="dairyFormWrap">
            <button className="dairyCancelBtn" id="dairyCancelBtn"></button>
            <p className="dairyDay" id="dairyDay">해당 일</p>
            <button className="dairyWriteBtn" id="dairyWriteBtn" onClick={showModal}></button>
        </section>
        <section className="writingBox" id="writingBox">
            <textarea className="writingContents" id="writingContents"></textarea>
            <div>
                <input type="file imgfile1" id="imgfile1"></input>
                <input type="file imgfile2" id="imgfile2"></input>
                <input type="file imgfile3" id="imgfile3"></input>
            </div>
        </section>
        <Modal show={show} handleClose={hideModal}>
            <p>한 번 등록되면 수정이 불가능 합니다. 작성하시겠습니까?</p>
            <input type="checkbox" id="doNotShowAgain" name="doNotShowAgain" value="doNotShowAgain"/>
            <label for="doNotShowAgain"> 다시 보지 않기</label><br/>
            <button onClick={hideModal}>확인</button>
            <button onClick={hideModal}>취소</button>
        </Modal>
        </body>
    );
}
