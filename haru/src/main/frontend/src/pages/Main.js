import {Route, Routes} from 'react-router-dom';

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
            <Routes>
                <Route path="/" element={<Home/>}/>
                <Route path="/dairy" element={<Dairy/>}/>
                <Route path="/memo" element={<Memo/>}/>
                <Route path="/memo/memo-write" element={<MemoWriting/>}/>
                <Route path="/setting" element={<Setting/>}/>
                <Route path="/setting/user" element={<SettingUser/>}/>
                <Route path="/setting/backup" element={<SettingBackup/>}/>
                <Route path="/setting/export" element={<SettingExportToText/>}/>
                <Route path="/setting/faq" element={<SettingFaq/>}/>
                <Route path="/setting/announce" element={<SettingAnnounce/>}/>
                <Route path="/memo/detail" element={<MemoDetail/>}/>
                <Route path="/memo/bundle" element={<MemoBundle/>}/>
            </Routes>
        </div>
    )
}
