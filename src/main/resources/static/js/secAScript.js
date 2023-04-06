
// To get current Date and Time
const timeElement = document.getElementById("current-time");
const dateElement = document.getElementById("current-date");
setInterval(() => {

        const now = new Date();
        const timeString = now.toLocaleTimeString();
        const dateString = now.toLocaleDateString();
        timeElement.innerText = timeString;
        dateElement.innerText = dateString;

}, 1000);

//Used to display the dropdown on clicking NOTOK radio
//Used in section A
//function showHideDivRadio(radioName, dropdownDiv, issueDisplayId) {
//  event.preventDefault();
//  const name = radioName;
//  const firstPart = 'input[name="';
//  const lastPart = '"]:checked';
//  const t = firstPart + name + lastPart;
////const t = 'input[name="' + name + '"]:checked';
//
//  const radio = document.querySelector(t).value;
//  const hiddenDiv = document.getElementById(dropdownDiv);
//  const hiddenIssues = document.getElementById(issueDisplayId);
//  const blockPropertyName = "block";
//  if (radio === "NotOK") {
//    hiddenDiv.style.display = blockPropertyName;
//    hiddenIssues.style.display = blockPropertyName;
//  } else {
//    hiddenDiv.style.display = "none";
//    hiddenIssues.style.display = "none";
//  }
//
//}

function displaySelectedValue(locationId, statId, dateId, selectedValue) {
  const dropdownloc = document.getElementById(locationId);
  const dropdownstat = document.getElementById(statId);
  const date = document.getElementById(dateId);
  const selectedvalues = document.getElementById(selectedValue);
  const newValue = document.createElement("div");
  newValue.classList.add(selectedValue);
  newValue.innerHTML = "Location: " + dropdownloc.value + "<br/>" + "Status: " + dropdownstat.value + "<br/> " + "date: " + date.value;
  const removeButton = document.createElement("button");
  removeButton.innerHTML = "Remove";
  removeButton.onclick = function () {
    selectedvalues.removeChild(newValue);
  };
  newValue.appendChild(removeButton);
  selectedvalues.appendChild(newValue);
  event.preventDefault();
}


