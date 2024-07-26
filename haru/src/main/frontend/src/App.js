import Header from "./components/Header";
import Footer from "./components/Footer";
// import Dairy from "./pages/dairy/dairy";
// import Main from "./pages/Main"
import Setting from "./pages/setting"

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
        {/*<Dairy></Dairy>*/}
        <Setting></Setting>
      <Footer></Footer>
    </div>
  );
}

export default App;
