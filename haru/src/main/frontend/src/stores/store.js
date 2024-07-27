// src/app/store.js
import { configureStore } from '@reduxjs/toolkit';
import modalStateSliceReducer from '../slices/modalState';

const store = configureStore({
  reducer: {
    modalState: modalStateSliceReducer
  }
});

export default store;
