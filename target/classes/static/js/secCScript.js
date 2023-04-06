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
// used on lines 557
function validation(textAreaId, messageID) {
  const input = document.getElementById(textAreaId);
  const message = document.getElementById(messageID);
  const delay = 500;
  const debounce = function (func, wait) {
    let timeout;
    return function () {
      const context = this, args = arguments;
      clearTimeout(timeout);
      timeout = setTimeout(() => {
        timeout = null;
        func.apply(context, args);
      }, wait);
    };
  };

  const validate = debounce(function textValidation() {
    const value = input.value;
    // let value=input.value;
    const regex = /^[a-zA-Z0-9 ,.]+$/;

    if (regex.test(value)) {
      message.innerHTML = "valid input";
      message.style.color = "green";
    } else {
      message.innerHTML = "Invalid input";
      message.style.color = "red";
    }
  }, delay);
  input.addEventListener("keypress", validate);
}





function showHideDivRadio(radioName, dropdownDiv, issueDisplayId) {
  event.preventDefault();
  const name = radioName;
  const firstPart = 'input[name="';
  const lastPart = '"]:checked';
  const t = firstPart + name + lastPart;
  const radio = document.querySelector(t).value;
  const hiddenDiv = document.getElementById(dropdownDiv);
  const hiddenIssues = document.getElementById(issueDisplayId);
  const blockPropertyName = "block";
  if (radio === "NotOK") {
    hiddenDiv.style.display = blockPropertyName;
    hiddenIssues.style.display = blockPropertyName;
  } else {
    hiddenDiv.style.display = "none";
    hiddenIssues.style.display = "none";
  }

}



//// Dynamic input for Health of all chains,  called on line 243
//const healthArr = ['TWSTFT offset ITS-A', 'TWSTFT offset ITS-B', 'TWSTFT offset ITS-C'];
//const healthCont = document.getElementById('C4-health');
//
//const ul2 = document.createElement('ul');
//ul2.setAttribute('class', 'list-style-none text-center d-flex flex-wrap mar-rt-5 marjus');
//
//for (var i = 0; i < healthArr.length; i++) {
//  var li = document.createElement('li');
//  li.setAttribute('class', 'p-3 col-3 boxli');
//  li.innerHTML = '<label>' + '' + healthArr[i] + ': </label> <input type="text" th:field="*{sectionC.twstftOffsets['+ i +'].value}" name="' + healthArr[i] + '">';
//  ul2.appendChild(li);
//}
//healthCont.appendChild(ul2);



// Dynamic input for Offsets, called on line 243




