



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
};







//
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

//function toggleSection(){
////     on click of section A
//        const func sectionFunc=if(onCLickEventA);
//        onClickOfSectionA{
//        showElement('sectionAId');
//                hideElement('sectionAId');
//        }
//        -> show section A
//        -> hide section C
//     on click of section C
//        -> show section C
//        -> hide section A

//const sectionCButton = document.getElementById('secCMenu');
//const sectionAButton = document.getElementById('secAMenu');
//const sectionCId = document.getElementById('sectionC');
//const sectionAId = document.getElementById('sectionA');

//
//sectionCButton.addEventListener("click", function() {
//    console.log( document.getElementById);
//    showElement(sectionCId);
//    hideElement(sectionAId);
//});
//sectionAButton.addEventListener("click", function() {
//    showElement(sectionAId);
//    hideElement(sectionCId);
//});



//const sections = [sectionAId, sectionBId, sectionCId, sectionDId, sectionEId, sectionFId, sectionGId, sectionHId];
//
//const currSection=
//
//const buttonPressed = e => {
//    const currButton = document.getElementById(e.target.id);
//    return showHideSecs(currButton, currSection);
//}
//for (let button of buttons) {
//    button.addEventListener("click", buttonPressed);
//}
//
//function showHideSecs(currButton, currSection) {
//    showElement(currSection);
//    for (let section of sections) {
//        if(section !== currSection) {
//            hideElement(section);
//        }
//    }
//}

function hideElement(elementId){
     elementId.style.display = "none";
}
function showElement(elementId){
    elementId.style.display = "block";
}

const sectionA= document.getElementById('sectionA');
const sectionB = document.getElementById('sectionB');
const sectionBNav = document.getElementById('sectionBNav');
const sectionC= document.getElementById('sectionC');
const sectionD= document.getElementById('sectionD');
const sectionE = document.getElementById('sectionE');
const sectionF = document.getElementById('sectionF');
const sectionG = document.getElementById('sectionG');
const sectionH = document.getElementById('sectionH');


const sectionAButton = document.getElementById('secAMenu');
const sectionBButton = document.getElementById('secBMenu');
const sectionBNavButton = document.getElementById('secBNavMenu');
const sectionCButton = document.getElementById('secCMenu');
const sectionDButton = document.getElementById('secDMenu');
const sectionEButton = document.getElementById('secEMenu');
const sectionFButton = document.getElementById('secFMenu');
const sectionGButton = document.getElementById('secGMenu');
const sectionHButton = document.getElementById('secHMenu');



const buttons = document.getElementsByClassName('menu-button');

const sections = [
    {prevSec: null, currSec: sectionA, nextSec: sectionB, button: sectionAButton},
    {prevSec: sectionA, currSec: sectionB, nextSec: sectionBNav, button: sectionBButton},
    {prevSec: sectionB, currSec: sectionBNav, nextSec: sectionC, button: sectionBNavButton},
    {prevSec: sectionBNav, currSec: sectionC, nextSec: sectionD, button: sectionCButton},
    {prevSec: sectionC, currSec: sectionD, nextSec: sectionE, button: sectionDButton},
    {prevSec: sectionD, currSec: sectionE, nextSec: sectionF, button: sectionEButton},
    {prevSec: sectionE, currSec: sectionF, nextSec: sectionG, button: sectionFButton},
    {prevSec: sectionF, currSec: sectionG, nextSec: sectionH, button: sectionGButton},
    {prevSec: sectionG, currSec: sectionH, nextSec: null, button: sectionHButton},
];

const buttonPressed = e => {
    const currButton = document.getElementById(e.currentTarget.id);
    for (let section of sections) {
        if(section.button === currButton){
            return showHideSections(section.currSec, section.prevSec, section.nextSec);

        }
    }
};

/**
    This function attaches events to all the buttons in the menu
**/
function initEventListener(){
    for (let button of buttons) {
        button.addEventListener("click", buttonPressed);
    };
}
function showHideSections(currSec, prevSec, nextSec)  {
    sections.map(hideElementofMap);
    showElement(currSec);
};

initEventListener();


function hideElementofMap(item) {
    item.currSec.style.display = "none";
}


// Function to remove active on buttons
$(function() {
  $('.menu-button').on('click', function() {
    $('.menu-button').removeClass('active'); // reset *all* buttons to the default state
    $(this).addClass('active'); // mark only the click-target as active
  })
});




//Used to display the dropdown on clicking NOTOK radio
//Used in section A
function showHideDivRadio(radioName, dropdownDiv, issueDisplayId) {
  event.preventDefault();
  const name = radioName;
  const firstPart = 'input[class="';
  const lastPart = '"]:checked';
  const t = firstPart + name + lastPart;
  console.log(t);

  const radio= document.querySelector(t).value;
//  const radio = "NotOK";
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

function radioDiv(radioName, issueDisplayId) {
    event.preventDefault();
    const name = radioName;
      const firstPart = 'input[class="';
      const lastPart = '"]:checked';
      const t = firstPart + name + lastPart;
      const radio= document.querySelector(t).value;
      const hiddenIssues = document.getElementById(issueDisplayId);
      const blockPropertyName = "block";
        if (radio === "NotOK") {
          hiddenIssues.style.display = blockPropertyName;
        } else {
          hiddenIssues.style.display = "none";
        }
}


//To Remove the required attribute from inputs and dropdowns
var inputs, index;
inputs = document.getElementsByTagName('input');
for (index = 0; index < inputs.length; ++index) {
    inputs[index].removeAttribute("required");
}

var dropdowns, index1;
dropdowns = document.getElementsByTagName('select');
for (index1 = 0; index1 < dropdowns.length; ++index1) {
    dropdowns[index1].removeAttribute("required");
}








//    const GNSSArr = ['ITSA-GNSS', 'ITSB-GNSS', 'ITSC-GNSS', 'VREMYA-A', 'VREMYA-B', 'ITS-INC2']
//   const offsetCont = document.getElementById('C5-GNSS');
//    const ul3 = document.createElement('ul');
//    ul3.setAttribute('class', 'list-style-none text-center d-flex flex-wrap marjus');
//    ul3.setAttribute('id', 'listOfChainHealths');
//    for (var i = 0; i < GNSSArr.length; i++) {
//      var li = document.createElement('li');
//     li.setAttribute('class', 'p-3 col-12 col-sm-6 col-md-4 boxli ');
//      li.innerHTML = '<b><label>' + ' ' + GNSSArr[i] + ': </label></b> <input type="text" id="a' + i + 'a"   th:field="*{sectionC.gnssOffsets.baseValue[' + i + '].value}">';
//      ul3.appendChild(li);
//   }
//
//   offsetCont.appendChild(ul3);












