export default function SettingBackup(){
    return (
        <div class="main" id="main">
        <h2> 백업 및 복구</h2>
        <section>
            <p>google Drive에 데이터를 수동으로 백업하여 기기가 변경되어도 간편하게 복구할 수 있습니다.</p>

            <div className="buttonWrap" id="buttonWrap">
                <button>백업</button>
                <button>복구</button>
            </div>
        </section>
        </div>
    )
}