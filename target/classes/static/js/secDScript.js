//const schemacsArr = ["Monit Status", "INC1-CS5", "INC1-CS6", "INC1-CS7", "INC1-CS8", "INC2-CS5", "INC2-CS6", "INC2-CS7", "INC2-CS8"];
//const schemacsCont = document.getElementById('secD1-SchemacsHealth');
//const ul5 = document.createElement('ul');
//ul5.setAttribute('class', 'list-style-none text-center d-flex flex-wrap mar-rt-5 marjus');
//for (var i = 0; i < schemacsArr.length; i++) {
//  var li = document.createElement('li');
//  li.setAttribute('class', 'p-3 col-12 col-sm-6 col-md-3 boxli');
//  li.innerHTML = '<b><label>' + '' + schemacsArr[i] + ': </label></b> <input type="radio" class= "form-check-input" id="' + schemacsArr[i]  + '" name="' + schemacsArr[i] + '" value="OK" onchange="radioDiv(\'' + schemacsArr[i] + '\', \'' + schemacsArr[i] + 'HiddenDiv\')"> <label for="OK">OK</label>  <input type="radio" id="' + schemacsArr[i] + '" name="' + schemacsArr[i] + '" value="NotOK" onchange="showHideDivRadio(\'' + schemacsArr[i] + '\', \'' + schemacsArr[i] + '-hidden-div\')"> <label for="Not OK">Not OK</label> <textarea id="' + schemacsArr[i] + '-hidden-div" style="display:none;"></textarea>';
//  ul5.appendChild(li);
//}
//schemacsCont.appendChild(ul5);





//
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


//function plusbutton(buttonId, secDivId) {
//  const plusbutton = document.getElementById(buttonId);
//  const hiddenDiv = document.getElementById(secDivId);
//  hiddenDiv.style.display = "none";
//  plusbutton.innerHTML = "▼";
//
//  plusbutton.addEventListener("click", function() {
//    if (hiddenDiv.style.display === "block") {
//      hiddenDiv.style.display = "none";
//      plusbutton.innerHTML = "▼"
//
//    } else {
//      hiddenDiv.style.display = "block";
//      plusbutton.innerHTML = "▲";
//    }
//  });
//}
