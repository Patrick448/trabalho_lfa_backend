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
