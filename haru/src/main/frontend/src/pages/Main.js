import Home from './RouterPages/Home';
import Dairy from './RouterPages/Dairy';
import Setting from "./RouterPages/Setting";
import SettingUser from "./RouterPages/setting/SettingUser";
import SettingBackup from './RouterPages/setting/SettingBackup.js'
import SettingExportToText from "./RouterPages/setting/SettingExportToText"
import SettingFaq from "./RouterPages/setting/SettingFaq"
import SettingAnnounce from './RouterPages/setting/SettingAnnounce.js'
import Memo from './RouterPages/Memo';
import MemoWriting from './RouterPages/memo/MemoWriting';
import MemoDetail from './RouterPages/memo/MemoDetail';
import MemoBundle from './RouterPages/memo/MemoBundle';


export default function Main() {
    return (
        <div className="mainContainer">
             {/*<Dairy></Dairy>*/}
             {/*<Home></Home>*/}
            {/*<Setting></Setting>*/}
            {/* <SettingUser></SettingUser>*/}
            {/* <SettingBackup></SettingBackup>*/}
            {/* <SettingExportToText></SettingExportToText>*/}
            {/* <SettingFaq></SettingFaq>*/}
            {/* <SettingAnnounce></SettingAnnounce>*/}
            {/* <Memo></Memo>*/}
            {/* <MemoWriting></MemoWriting>*/}
            {/* <MemoDetail></MemoDetail>*/}
            {/* <MemoBundle></MemoBundle>*/}


            {/* 
            react-router-dom 추가시 해야할 것 index.js에서도 있음
            <Routes>
                <Route path="/" element={<Home />} />
                <Route path="/dairy" element={<Dairy />} />
                <Route path="/memo" element={<Memo />} />
                <Route path="/memo/memo-write" element={<MemoWriting />} />
                <Route path="/setting" element={<Setting />} />
            </Routes>
            
            */}
        </div>
    )
}