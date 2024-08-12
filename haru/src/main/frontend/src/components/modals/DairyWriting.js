import React, { useEffect, useState } from 'react';
import Modal from './DairyModal';

import { changeModalName, modalStateOff } from "../../slices/modalState";
import { useDispatch } from 'react-redux';

export default function DairyWriting(props) {
    const dispatch = useDispatch();
    const [src1, setSrc1] = useState('');
    const [src2, setSrc2] = useState('');
    const [src3, setSrc3] = useState('');
    const [input1, setInput1] = useState(null);
    const [input2, setInput2] = useState(null);
    const [input3, setInput3] = useState(null);
    const [show, setShow] = useState(false);
    const [modal2Comp, setModal2Comp] = useState(<></>);

    const hideModal = () => {
        setShow(false);
    };

    function readURL(input, num) {
        if (input.files && input.files[0]) {
          var reader = new FileReader();
          reader.onload = function(e) {
            settingSrc(e.target.result, num);
          };
          reader.readAsDataURL(input.files[0]);
        } else {
          settingSrc("",num)
        }
      }

      function settingSrc(str, num) {
        if(num === 1){
            setSrc1(str);
        }else if(num === 2){
            setSrc2(str);
        }else if(num === 3){
            setSrc3(str);
        }
      }

      function closeDairyWritingModal(){
        dispatch(changeModalName(''))
        dispatch(modalStateOff());
      }

      useEffect(()=>{
        if(show){
            setModal2Comp(<Modal handleClose={hideModal}></Modal>)
        }else if(!show){
            setModal2Comp(<></>)
        }
      },[show])
    

    return (
        <div className="dairyWritingContainer" id="dairyWritingContainer">
            <section className="dairyFormWrap">
                <button className="dairyCancelBtn" id="dairyCancelBtn" onClick={closeDairyWritingModal}>취소</button>
                <p className="dairyDay" id="dairyDay">2024.07.27</p>
                <button className="dairyWriteBtn" id="dairyWriteBtn" onClick={()=>{setShow(true)}}>작성</button>
            </section>

            <section className="writingBox" id="writingBox">
                <textarea className="writingContents" id="writingContents" defaultValue="" placeholder='내용을 입력해주세요.' />
                <div>
                    <div>
                        <input style={src1 ? {display: 'none'} : {display: 'block'}} type="file" className='imgfile1' id="imgfile1" onChange={(evt)=>{readURL(evt.target,1); setInput1(evt.target)}}></input>
                        <img style={!src1 ? {display: 'none'} : {display: 'block'}} src={src1} alt='파일이미지1' onClick={()=>{input1.click()}}></img>
                    </div>
                    <div>
                        <input style={src2 ? {display: 'none'} : {display: 'block'}} type="file" className='imgfile2' id="imgfile2" onChange={(evt)=>{readURL(evt.target,2); setInput2(evt.target)}}></input>
                        <img style={!src2 ? {display: 'none'} : {display: 'block'}} src={src2} alt='파일이미지2' onClick={()=>{input2.click()}}></img>
                    </div>
                    <div>
                        <input style={src3 ? {display: 'none'} : {display: 'block'}} type="file" className='imgfile3' id="imgfile3" onChange={(evt)=>{readURL(evt.target,3); setInput3(evt.target)}}></input>
                        <img style={!src3 ? {display: 'none'} : {display: 'block'}} src={src3} alt='파일이미지3' onClick={()=>{input3.click()}}></img>
                    </div>
                </div>
            </section>

            {modal2Comp}
        </div>
    );
}
