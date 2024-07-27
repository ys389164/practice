// props.handleClose
const Modal = ({handleClose}) => {
    function backEndBridge(){
        console.log('백엔드코드 작성');
    }
    return (
        <div className="dairyModalContainer">
            <div className="reQuestion">
                <p>한 번 등록되면<br />수정이 불가능 합니다.<br /> 작성하시겠습니까?</p>
                <div className="checkBoxWrap">
                    <input type="checkbox" id="doNotShowAgain" name="doNotShowAgain" value="doNotShowAgain"/>
                    <label for="doNotShowAgain"> 다시 보지 않기</label>
                </div>
            </div>
            
        

            <section className="modal-main">
                <button className="uploadBtn" onClick={()=>{backEndBridge()}}>등록</button>
                <button className="cancleBtn" onClick={handleClose}>취소</button>
            </section>
        </div>
    );
};

export default Modal;
