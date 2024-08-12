import axios from "axios";

const BASE_URL = "http://localhost:8090/api";

// Get : /
export const getSettings = async () => {
    try {
        const response = await axios.get(BASE_URL + '/setting');
        return response.data;
    } catch (error) {
        console.error('백엔드 에러', error);
        return;
    }
};

// Post : /signUp
export const signUp = async () => {
    try {
        const response = await axios.post(BASE_URL + '/setting/signUp');
        return response.data;
    } catch (error) {
        console.error('백엔드 에러', error);
        return;
    }
};

// Post : /account/nickname
export const updateNickname = async (nickname) => {
    try {
        const response = await axios.post(BASE_URL + '/setting/account/nickname', null, {
            params: { nickname }
        });
        return response.data;
    } catch (error) {
        console.error('백엔드 에러', error);
        return;
    }
};

// Put : /account/email
export const updateEmail = async (email) => {
    try {
        const response = await axios.put(BASE_URL + '/setting/account/email', null, {
            params: { email }
        });
        return response.data;
    } catch (error) {
        console.error('백엔드 에러', error);
        return;
    }
};

// Delete : /account/deleteData
export const deleteAccountData = async (userId) => {
    try {
        const response = await axios.delete(BASE_URL + '/setting/account/deleteData', {
            params: { userId }
        });
        return response.data;
    } catch (error) {
        console.error('백엔드 에러', error);
        return;
    }
};

// Post : /account/deleteData/confirmSuccess
export const confirmDeleteAccountData = async (userId) => {
    try {
        const response = await axios.post(BASE_URL + '/setting/account/deleteData/confirmSuccess', null, {
            params: { userId }
        });
        return response.data;
    } catch (error) {
        console.error('백엔드 에러', error);
        return;
    }
};

// Post : /logout
export const logout = async () => {
    try {
        const response = await axios.post(BASE_URL + '/setting/logout');
        return response.status === 200;
    } catch (error) {
        console.error('백엔드 에러', error);
        return;
    }
};

// Delete : /account/withdrawal
export const withdrawAccount = async () => {
    try {
        const response = await axios.delete(BASE_URL + '/setting/account/withdrawal');
        return response.data;
    } catch (error) {
        console.error('백엔드 에러', error);
        return;
    }
};

// Post : /account/withdrawal/confirmSuccess
export const confirmWithdrawal = async (userId) => {
    try {
        const response = await axios.post(BASE_URL + '/setting/account/withdrawal/confirmSuccess', null, {
            params: { userId }
        });
        return response.data;
    } catch (error) {
        console.error('백엔드 에러', error);
        return;
    }
};

/* // Get : /backAndRecover/backup
export const backupData = async () => {
    try {
        const response = await axios.get(BASE_URL + '/setting/backAndRecover/backup');
        return response.data;
    } catch (error) {
        console.error('백엔드 에러', error);
        return;
    }
};

// Post : /backAndRecover/restore
export const restoreData = async () => {
    try {
        const response = await axios.post(BASE_URL + '/setting/backAndRecover/restore');
        return response.data;
    } catch (error) {
        console.error('백엔드 에러', error);
        return;
    }
};

// Get : /export/{category}
export const exportData = async (category, type) => {
    try {
        const response = await axios.get(BASE_URL + '/setting/export/' + category, {
            params: { type }
        });
        return response.data;
    } catch (error) {
        console.error('백엔드 에러', error);
        return;
    }
}; */

// Get : /faq/{category}
export const getFaq = async (category) => {
    try {
        const response = await axios.get(BASE_URL + '/setting/faq/' + category);
        return response.data;
    } catch (error) {
        console.error('백엔드 에러', error);
        return;
    }
};

// Get : /notice
export const getNotices = async () => {
    try {
        const response = await axios.get(BASE_URL + '/setting/notice');
        return response.data;
    } catch (error) {
        console.error('백엔드 에러', error);
        return;
    }
};
