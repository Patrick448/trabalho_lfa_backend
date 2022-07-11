import data from '../../endpoints.json' assert {type: 'json'};
import { displayTupla } from './uxfunctions.js'

import { getCookie, setCookie } from './cookieHandler.js'

var user_session = getCookie('user_session');
if (!user_session) {
    setCookie();
}


//pending: 
// -> accepts words + js to change accept button
// -> check if load-afn is working (CORS error)


var fileChooser = document.getElementById('docpicker');
var loadButton = document.querySelector('.submit-automata-btn');
var loadedFile;
var loadedFileName;

function waitForTextReadComplete(reader) {
    reader.onloadend = function (event) {
        loadedFile = event.target.result;
        document.querySelector(".docpicker-label").innerText = loadedFileName;

    }
}

function handleFileSelection() {
    var file = fileChooser.files[0],
        reader = new FileReader();
    waitForTextReadComplete(reader);
    reader.readAsText(file);
    loadedFileName = file.name.toLowerCase();
}

fileChooser.addEventListener('change', handleFileSelection, false);

loadButton.addEventListener('click', handleSubmit);

function handleSubmit() {
    let automataOption;
    if (document.querySelector('.btn-clicked'))
        automataOption = document.querySelector('.btn-clicked').innerText.toLowerCase();
    if (loadedFile && automataOption) {
        sendXML(loadedFile, automataOption);
    }
    else {
        if (document.querySelector('.error-warning.hidden'))
            document.querySelector('.error-warning.hidden').classList.remove('hidden');
    }
}



function sendXML(xml, option) {
    var myHeaders = new Headers();
    myHeaders.append("Content-Type", "text/plain");
    myHeaders.append("Accept", "*/*");

    var raw = xml;
    var requestOptions = {
        method: 'POST',
        headers: myHeaders,
        body: raw,
        redirect: 'follow'
    };
    postReq(requestOptions, option);
}

async function postReq(requestOptions, option) {
    console.log(option)
    await fetch(`https://trabalho-lfa.herokuapp.com/${option}/load-${option}?uuid=${user_session}`, requestOptions)
        .then(response => response.text())
        .then(result => displayTupla(result))
        .catch(error => console.log('error', error));
}

