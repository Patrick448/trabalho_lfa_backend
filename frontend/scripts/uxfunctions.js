
document.getElementById("afn-btn").addEventListener("click", toggleRadioButton, false);
document.getElementById("afd-btn").addEventListener("click", toggleRadioButton, false);


export function toggleRadioButton() {
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


export function displayTupla(tupla) {
    document.querySelector(".automata-tupla-box").innerHTML = tupla;
}