document
  .getElementById("afn-btn")
  .addEventListener("click", toggleRadioButton, false);
document
  .getElementById("afd-btn")
  .addEventListener("click", toggleRadioButton, false);

export function toggleRadioButton() {
  if (document.getElementById("afn-btn").checked) {
    document
      .getElementById("afn-btn")
      .labels[0].classList.toggle("btn-clicked");
    document
      .getElementById("afd-btn")
      .labels[0].classList.remove("btn-clicked");
  }
  if (document.getElementById("afd-btn").checked) {
    document
      .getElementById("afd-btn")
      .labels[0].classList.toggle("btn-clicked");
    document
      .getElementById("afn-btn")
      .labels[0].classList.remove("btn-clicked");
  }
}

export function displayTupla(tupla) {
  document.querySelector(".automata-tupla-box").innerHTML = tupla;
}


export function acceptsWord(result, flag) {
    if (result == 'true') {
        document.querySelector('.automata-response').classList.add('accepts-lfa')
        document.querySelector('.automata-response').classList.remove('rejects-lfa')
    }
    else{
        document.querySelector('.automata-response').classList.remove('accepts-lfa')
        document.querySelector('.automata-response').classList.add('rejects-lfa')
    }

}

export function clearAcceptButton(flag) {
    if (!flag) {
        document.querySelector('.automata-response').classList.remove('accepts-lfa')
        document.querySelector('.automata-response').classList.remove('rejects-lfa')
    }
}

export function loadingScreen(mode) {
    if (mode) {
        document.querySelector('.lds-roller').style.visibility='visible';
        window.scrollTo(0, 0);
        document.body.style.overflow = "hidden";
    }
    else {
        document.querySelector('.lds-roller').style.visibility='hidden';
        document.body.style.overflow = "auto";
    }
}