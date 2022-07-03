import data from './endpoints.json' assert {type: 'json'};

//hostname + create-uuid
//load
//accepts
console.log(data.create_uuid);


var fileChooser = document.getElementById('docpicker');

function parseTextAsXml(text) {
    var parser = new DOMParser(),
        xmlDom = parser.parseFromString(text, "text/xml");
        console.log(xmlDom)
}

function waitForTextReadComplete(reader) {
    reader.onloadend = function(event) {
        var text = event.target.result;

        parseTextAsXml(text);
    }
}

function handleFileSelection() {
    var file = fileChooser.files[0],
        reader = new FileReader();

    waitForTextReadComplete(reader);
    reader.readAsText(file);
}

fileChooser.addEventListener('change', handleFileSelection, false);
    
document.getElementById("afn-btn").addEventListener("click", toggleRadioButton, false);
document.getElementById("afd-btn").addEventListener("click", toggleRadioButton, false);

function toggleRadioButton() {
    console.log('teste')
    if (document.querySelector("#afn-btn").checked) {
        document.querySelector("#afn-btn").labels[0].classList.add('btn-clicked');
    }
    else {
        document.querySelector("#afn-btn").labels[0].classList.remove('btn-clicked');
    }

    if (document.querySelector("#afd-btn").checked) {
        document.querySelector("#afd-btn").labels[0].classList.add('btn-clicked');
    }
    else {
        document.querySelector("#afd-btn").labels[0].classList.remove('btn-clicked');
    }
}



async function fetchData() {
    await fetch(data.hostname + data.create_uuid, {
        mode: 'no-cors',
        method: 'get'
    })
    .then(response => console.log(response));
}

fetchData();