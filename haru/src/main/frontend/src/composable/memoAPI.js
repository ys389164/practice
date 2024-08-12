import axios from "axios";

const BASE_URL = "http://localhost:8090/api";

// Get : /folders
export const getFolders = async () => {
    try {
        const response = await axios.get(BASE_URL + '/memo/folders');
        return response.data;
    } catch (error) {
        console.error('백엔드 에러', error);
        return;
    }
};

// Post : /folders
export const createFolder = async (folderlist) => {
    try {
        const response = await axios.post(BASE_URL + '/memo/folders', folderlist);
        return response.data;
    } catch (error) {
        console.error('백엔드 에러', error);
        return;
    }
};

// Put : /folders
export const updateFolder = async (folderlist) => {
    try {
        const response = await axios.put(BASE_URL + '/memo/folders', folderlist);
        return response.data;
    } catch (error) {
        console.error('백엔드 에러', error);
        return;
    }
};

// Delete : /folders/{folderId}
export const deleteFolder = async (folderId) => {
    try {
        const response = await axios.delete(BASE_URL + '/memo/folders/' + folderId);
        return response.data;
    } catch (error) {
        console.error('백엔드 에러', error);
        return;
    }
};

// Get : /folders/{folderId}/notes
export const getNotesByFolder = async (folderId) => {
    try {
        const response = await axios.get(BASE_URL + '/memo/folders/' + folderId + '/notes');
        return response.data;
    } catch (error) {
        console.error('백엔드 에러', error);
        return;
    }
};

// Post : /folders/{folderId}/notes
export const createNote = async (folderId, memo) => {
    try {
        const response = await axios.post(BASE_URL + '/memo/folders/' + folderId + '/notes', memo);
        return response.data;
    } catch (error) {
        console.error('백엔드 에러', error);
        return;
    }
};

// Get : /folders/{folderId}/notes/{noteId}
export const getNote = async (folderId, noteId) => {
    try {
        const response = await axios.get(BASE_URL + '/memo/folders/' + folderId + '/notes/' + noteId);
        return response.data;
    } catch (error) {
        console.error('백엔드 에러', error);
        return;
    }
};

// Put : /folders/{folderId}/notes/{noteId}
export const updateNote = async (folderId, noteId, memo) => {
    try {
        const response = await axios.put(BASE_URL + '/memo/folders/' + folderId + '/notes/' + noteId, memo);
        return response.data;
    } catch (error) {
        console.error('백엔드 에러', error);
        return;
    }
};

// Delete : /folders/{folderId}/notes/{noteId}
export const deleteNote = async (folderId, noteId) => {
    try {
        const response = await axios.delete(BASE_URL + '/memo/folders/' + folderId + '/notes/' + noteId);
        return response.data;
    } catch (error) {
        console.error('백엔드 에러', error);
        return;
    }
};

// Post : /defaultFolder/notes
export const createNoteDefaultFolder = async (memo) => {
    try {
        const response = await axios.post(BASE_URL + '/memo/defaultFolder/notes', memo);
        return response.data;
    } catch (error) {
        console.error('백엔드 에러', error);
        return;
    }
};
