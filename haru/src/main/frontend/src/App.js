import Header from "./components/Header";
import Main from "./pages/Main"
import Footer from "./components/Footer";
// 해당 페이지에 있던 Dairy, Setting페이지는 Main.js에 옮겨두었음
// css연동
import './assets/styles/style.scss';

//모달 추가
import DairyWriting from "./components/modals/DairyWriting";
import { useEffect, useState } from "react";
import { useSelector } from "react-redux";





// const sendDataToBackend = async (value) => {
//     try {
//         const response = await axios.post('http://localhost:8090/api/your-endpoint', {
//             data: value
//         });
//
//         console.log(response.data);} catch (error) {
//         console.error(error);
//     }
// };

function App() {
  // 비동기 함수
  // async function startApi(){
  //   console.log(await TestF())
  // }
  // startApi()
  //   sendDataToBackend(10)
  // async function test(){
  //   console.log((await wal()))
  // }
  // test()

  const [modalComponents, setModalComponents] = useState(<></>);
  const modalName = useSelector(state => state.modalState.modalName);
  /* 
  modal 이름 종류
  DairyWriting
  */


  useEffect(()=>{
    if(modalName === 'DairyWriting'){
      setModalComponents(<DairyWriting></DairyWriting>);
    }if(!modalName){
      setModalComponents(<></>);
    }
  },[modalName])


  return (
    <div className="App">
      <Header></Header>
      <Main></Main>
      <Footer></Footer>
      {modalComponents}
    </div>
  );
}

export default App;
