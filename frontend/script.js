import data from './endpoints.json' assert {type: 'json'};

//hostname + create-uuid
//load
//accepts
console.log(data.hostname);


var fileChooser = document.getElementById('docpicker');

function parseTextAsXml(text) {
    var parser = new DOMParser(),
        xmlDom = parser.parseFromString(text, "text/xml");
        console.log(xmlDom)

    //now, extract items from xmlDom and assign to appropriate text input fields
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
    

// async function fetchData() {
//     await fetch(data.hostname + data.create_uuid)
//     .then(response => response.json())
//     .then(data => console.log(data));
// }

// fetchData();