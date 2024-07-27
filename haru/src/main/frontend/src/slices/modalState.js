// src/features/counterSlice.js
import { createSlice } from '@reduxjs/toolkit';

const modalStateSlice = createSlice({
  name: 'modalState',
  initialState: { modalName: '', modalOnOff: false},
  reducers: {
    changeModalName: (state, action) => {
      state.modalName = action.payload;
    },
    modalStateOn: (state) => {
        state.modalOnOff = true
    },
    modalStateOff: (state) => {
        state.modalOnOff = false
    }
  }
});

//export const { increment, decrement, incrementByAmount } = footerSelecteSlice.actions;
export const { modalStateOn, modalStateOff, changeModalName } = modalStateSlice.actions;
export default modalStateSlice.reducer;


/* 
modal 이름 종류
DairyWriting

*/