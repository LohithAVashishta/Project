//
//function displayStations(locationId, selectedValue) {
//  const dropdownloc = document.getElementById(locationId);
//  const selectedvalues = document.getElementById(selectedValue);
//  const newValue = document.createElement("div");
//  newValue.classList.add(selectedValue);
//  newValue.innerHTML = "Location: " + dropdownloc.value + "<br/>";
//  const removeButton = document.createElement("button");
//  removeButton.setAttribute('class', 'btn btn-primary');
//  removeButton.innerHTML = "Remove";
//  removeButton.onclick = function () {
//    selectedvalues.removeChild(newValue);
//  };
//  newValue.appendChild(removeButton);
//  selectedvalues.appendChild(newValue);
//  event.preventDefault();
//}

//
//alert("secEFScript is called");

//$(document).ready(function(){
//
//    $('.irims').on('click', 'button[data-update-contacts-url]', function () {
//        let url = $(this).data('update-contacts-url');
//        alert(url);
//        let formData = $('form').serializeArray();
//        let param = {};
//         param["name"] = $(this).attr('name');
//         param["value"] = $(this).val();
//         formData.push(param);
//         $('#test').load(url, formData)
//
//    });
//
//})




const deleteAction='delete';
const searchAction='search';
const enable= "True";
const disable = "False"
const defaultIdxVal=0;
var aIdx=0;

function selectLocation() {
    const dropdown = document.getElementById("stationE1");
    const dropdownName = dropdown.options[dropdown.selectedIndex].value;
    locationSearchAction(dropdownName);
}
function locationSearchAction(rowId){
    prepareLocation(searchAction,rowId);
}
function locationDeleteAction(rowId) {
    prepareLocation(deleteAction, rowId);
}

function prepareLocation(action, rowId){

    const locationRow = document.getElementById(rowId);
//    console.log(locationRow);
    const columns = locationRow.getElementsByTagName("td");
//    console.log(columns)
    const enableColumn = columns[0];
//    console.log("E"+ enableColumn);
    const columnInputs = enableColumn.getElementsByTagName("input");
//            console.log("E"+ columnInputs);
    const enableColumnInput = columnInputs[0];
//                console.log("E"+ enableColumnInput);
    const idColumn = columns[2];
//                console.log("E"+ idColumn);

    if(action===searchAction) {
        $("#"+ rowId).show();
        enableColumnInput.value = enable;
        const idColumnInnerHtml = idColumn.innerHTML;
        if(Number(idColumnInnerHtml) === defaultIdxVal){
            aIdx++;
            idColumn.innerHTML=String(aIdx);
            sort(true, 'id','Station-display');

        }

    }
    else if(action===deleteAction) {
        enableColumnInput.value = disable;
        idColumn.innerHTML = String(defaultIdxVal);

    }

}

function sort(ascending, columnClassName, tableId)
{
    var tBody = document.getElementById(tableId).getElementsByTagName("tbody")[0];
    var rows = tBody.getElementsByTagName("tr");

    var unsorted = true;

    while(unsorted)
    {
        unsorted = false
        for (var r = 0; r < rows.length - 1; r++)
        {
            var row = rows[r];
            var nextRow = rows[r+1];
            var value = row.getElementsByClassName(columnClassName)[0].innerHTML;

            var nextValue = nextRow.getElementsByClassName(columnClassName)[0].innerHTML;
            value = value.replace(',', ''); // in case a comma is used in float number
            nextValue = nextValue.replace(',', '');
            if(!isNaN(value))
            {
                value = parseFloat(value);
                nextValue = parseFloat(nextValue);
            }
            if (ascending ? value > nextValue : value < nextValue)
            {
                tBody.insertBefore(nextRow, row);
                unsorted = true;
            }
        }
    }
};


function removeLocation(ele) {
    event.preventDefault();
    removeLocationByElement(ele);
    hideLocationForm();

}

function removeLocationByElement(ele){
    const getTdId = document.getElementById(ele.id);
    console.log(getTdId);
    const rowId = getTdId.parentElement;
    console.log(rowId);
    const rowDeleteId = rowId.id;
    console.log(rowDeleteId);
    locationDeleteAction(rowDeleteId)
    $("#" + rowDeleteId).hide();
}

function hideLocationForm(){
    let isAllLocationDisabled=true;  // all row is having False //
    const rows=document.getElementById("Station-display").rows;

    let table = document.getElementById("Station-display");
    for (let i = 1, row; row = table.rows[i]; i++) {
        var rowId=row.id;
        var locationRow = document.getElementById(rowId);
        var locationRowColumns = locationRow.getElementsByTagName("td");
        var locationRowFirstColumn = locationRowColumns[0];
        var locationRowInputs = locationRowFirstColumn.getElementsByTagName("input");
        var locationRowEnableInput = locationRowInputs[0];
        let isLocationEnabledValue=locationRowEnableInput.value;
        if(isLocationEnabledValue==="True"){
            isAllLocationDisabled=false;
            break;
        }
    }
    if(isAllLocationDisabled===true ){
        hideLocationDiv();
    }
}
function hideLocationDiv(){
    $("#hidden-issues2").hide();
}











