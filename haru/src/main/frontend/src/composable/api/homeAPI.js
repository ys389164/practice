import axios from "axios";
const BASE_URL = "http://localhost:8090/api";

/* 응답값(예시)
* Object {object} 서버에서 넘겨준 응답객체
* Object.id {String} 고유값
* Object.title {String} 일기제목
* Object.content {String} 일기내용
* Object.date {String} 해당날짜
* */

export const getCalenderSomeNone = async (year, month) => {
        const response = await axios.get(BASE_URL + '/home/calendarBundle', {
            params: { year, month }
        });
        if(response.status === 200){            
            return response.data;
        }else{
            console.log('백엔드 에러');
            return;
        }
};

export const getRecentBundle = async () => {
    const response = await axios.get(BASE_URL + '/home/recentBundle');
    if(response.status === 200){
        return response.data;
    }else{
        console.log('백엔드 에러');
        return;
    }
};

/* 응답값(예시)
* Object {object} 서버에서 넘겨준 응답객체
* Object.id {String} 고유값
* Object.title {String} 일기제목
* Object.content {String} 일기내용
* Object.date {String} 해당날짜
* */
// export const sendDataToBackend = async (value) => {
//     const response = await axios.post(BASE_URL + '/your-endpoint', {
//         data: value
//     });
//     if(response.data.success === '200'){
//         return response.data;
//     }else{
//         console.log('백엔드 에러');
//         return;
//     }
// };