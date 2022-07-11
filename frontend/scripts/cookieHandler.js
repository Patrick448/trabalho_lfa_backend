import { UUIDv4 } from './uuid.js'


export function setCookie() {
    let date = new Date();
    date.setTime(date.getTime() + (3 * 24 * 60 * 60 * 1000));
    const expires = "expires=" + date.toUTCString();


    document.cookie = `user_session=${UUIDv4.generate()}` + "; " + expires + ";";
}

export function getCookie(name) {
    let value = `; ${document.cookie}`;
    let parts = value.split(`; ${name}=`);
    if (parts.length === 2) 
        return parts.pop().split(';').shift();
}




