import './App.css';
// import TestF from "./api/test";
// import wal from "./components/wal"
import Header from "./components/Header";
import Footer from "./components/Footer";
// import Main from "./Main";
import Dairy from "./dairy/dairy";

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


  return (
    <div className="App">
      <Header></Header>
        {/*<Main></Main>*/}
        <Dairy></Dairy>
      <Footer></Footer>
    </div>
  );
}

export default App;
