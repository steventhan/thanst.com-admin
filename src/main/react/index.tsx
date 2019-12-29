import React, { createContext } from 'react';
import ReactDOM from 'react-dom';
import './index.scss';
import App from './App';
import * as serviceWorker from './serviceWorker';

interface Window {
    __INITIAL_STATE__: string
}

interface InitialState {
    [key: string]: any
}

declare const window: Window;
const initialState: InitialState = JSON.parse(window.__INITIAL_STATE__);
const InitialStateContext = createContext(initialState);


ReactDOM.render(
    <InitialStateContext.Provider value={initialState}>
        <App />
    </InitialStateContext.Provider>,
    document.getElementById('root')
);

serviceWorker.unregister();

export {
    InitialStateContext
}
