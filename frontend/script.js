import data from './endpoints.json' assert {type: 'json'};
import { displayTupla } from './uxfunctions.js'

//pending: 
// -> uuid dinamico + cookies to keep session
// -> update fetch function to afd/afn
// -> select file + select type + click carregar button to call function that will populate 5tupla

var fileChooser = document.getElementById('docpicker');

function waitForTextReadComplete(reader) {
    reader.onloadend = function (event) {
        var text = event.target.result;
        sendXML(text);
    }
}

function handleFileSelection() {
    var file = fileChooser.files[0],
        reader = new FileReader();

    waitForTextReadComplete(reader);
    reader.readAsText(file);
}

fileChooser.addEventListener('change', handleFileSelection, false);

function sendXML(xml) {
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
    postReq(requestOptions);
}

async function postReq(requestOptions) {
    await fetch("https://trabalho-lfa.herokuapp.com/afd/load-afd?uuid=10101010", requestOptions)
      .then(response => response.text())
      .then(result => displayTupla(result))
      .catch(error => console.log('error', error));
}

