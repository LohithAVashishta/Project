const docArr1 = ['Doc1.txt', 'Doc2.txt', 'Doc3.txt', 'Doc4.txt', 'Doc5.txt'];
const cont2 = document.getElementById('section-G2');
const ul7 = document.createElement('ul');
ul7.setAttribute('class', 'list-style-none text-center d-flex flex-wrap p-0');
ul7.setAttribute('id', 'listofcheckboxes');

for (i = 0; i <= docArr1.length; i++) {
  var li = document.createElement('li');
  li.setAttribute('class', 'p-3 col-2 boxli marjus');
  li.innerHTML = "<input type='checkbox' name='" + docArr1[i] + "'><b><label>" + " " + docArr1[i] + "</label></b>";
  ul7.appendChild(li);
}
li.innerHTML = '<button id="next-button" onclick="checkboxverify()">Confirm</button>';
cont2.appendChild(ul7);


function plusbutton(buttonId, secDivId) {
  const plusbutton = document.getElementById(buttonId);
  const hiddenDiv = document.getElementById(secDivId);
  hiddenDiv.style.display = "none";
  plusbutton.innerHTML = "▼";

  plusbutton.addEventListener("click", function() {
    if (hiddenDiv.style.display === "block") {
      hiddenDiv.style.display = "none";
      plusbutton.innerHTML = "▼"

    } else {
      hiddenDiv.style.display = "block";
      plusbutton.innerHTML = "▲";
    }
  });
}

//function showHideDivRadio(radioName, dropdownDiv, issueDisplayId) {
//  event.preventDefault();
//  const name = radioName;
//  const firstPart = 'input[name="';
//  const lastPart = '"]:checked';
//  const t = firstPart + name + lastPart;
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
