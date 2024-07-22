import logo from './logo.svg';
import './App.css';
import TestF from "./api/test";
import TestT from "./components/TestT";
import wal from "./components/wal"
function App() {

  // 비동기 함수
  async function startApi(){
    console.log(await TestF())
  }

  startApi()

  async function test(){
    console.log((await wal()))
  }

  test()


  return (
    <div className="App">

      <TestT></TestT>

      <header className="App-header">
        <img src={logo} className="App-logo" alt="logo" />
        <p>
          Edit <code>src/App.js</code> and save to reload.
        </p>
        <a
          className="App-link"
          href="https://reactjs.org"
          target="_blank"
          rel="noopener noreferrer"
        >
          Learn React
        </a>
      </header>
    </div>
  );
}

export default App;
