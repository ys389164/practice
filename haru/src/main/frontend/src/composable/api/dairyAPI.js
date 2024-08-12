import axios from "axios";

const BASE_URL = "http://localhost:8090/api";

// get : /statusTF
export const getCalenderSomeNone = async (year, month) => {
    try {
        const response = await axios.get(BASE_URL + '/diary/statusTF', {
            params: { year, month }
        });
        return response.data;
    } catch (error) {
        console.error('백엔드 에러', error);
        return;
    }
};

// get : /consecutive
export const getConsecutiveDate = async () => {
    try {
        const response = await axios.get(BASE_URL + '/diary/consecutive');
        return response.data;
    } catch (error) {
        console.error('백엔드 에러', error);
        return;
    }
};

// get : /{date}
export const getDate = async (date) => {
    try {
        const response = await axios.get(BASE_URL + '/diary/' + date);        
        return response.data;
    } catch (error) {
        console.error('백엔드 에러', error);
        return;
    }
};


// get : /checkToday
export const goToWrite = async () => {
    try {
        const response = await axios.get(BASE_URL + '/diary/checkToday');
        return response.data;
    } catch (error) {
        console.error('백엔드 에러', error);
        return;
    }
};

// get : /view/{date}
export const getDiaryInfo = async (date) => {
    try {
        const response = await axios.get(BASE_URL + '/diary/view/' + date);
        return response.data;
    } catch (error) {
        console.error('백엔드 에러', error);
        return;
    }
};

// get : /view/{date}/navigate
export const getDiaryNavigate = async (date) => {
    try {
        const response = await axios.get(BASE_URL + '/diary/view/' + date + '/navigate');
        return response.data;
    } catch (error) {
        console.error('백엔드 에러', error);
        return;
    }
};

// post : /view/cancel
export const viewCancel = async (date) => {
    try {
        const response = await axios.post(BASE_URL + '/diary/view/cancel', null, {
            params: { date }
        });
        return response.data;
    } catch (error) {
        console.error('백엔드 에러', error);
        return;
    }
};

// post : /cancel
export const writingCancel = async () => {
    try {
        const response = await axios.post(BASE_URL + '/diary/cancel');
        return response.data;
    } catch (error) {
        console.error('백엔드 에러', error);
        return;
    }
};

// post : /submit
export const enrollDiary = async (date) => {
    try {
        const response = await axios.post(BASE_URL + '/diary/submit', null, {
            params: { date }
        });
        return response.data;
    } catch (error) {
        console.error('백엔드 에러', error);
        return;
    }
};

// post : /modal/submit
export const enrollDiaryOnModal = async (date) => {
    try {
        const response = await axios.post(BASE_URL + '/diary/modal/submit', null, {
            params: { date }
        });
        return response.data;
    } catch (error) {
        console.error('백엔드 에러', error);
        return;
    }
};
