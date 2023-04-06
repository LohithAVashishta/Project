//function displayStnLookAngleAvailability(location, date, time, displayLocation) {
//event.preventDefault();
//  const locationElement = document.getElementById(location);
//  const dateElement = document.getElementById(date);
//  const timeElement = document.getElementById(time);
//  const displayArea = document.getElementById(displayLocation);
//
//  const newValue = document.createElement("div");
//  newValue.classList.add(displayLocation);
//  newValue.innerHTML = "Location: " + locationElement.value + "<br/>" + "Date: " + dateElement.value + "<br/> " + "Time: " + timeElement.value;
//  const removeButton = document.createElement("button");
//  removeButton.innerHTML = "Remove";
//  removeButton.onclick = function () {
//    displayArea.removeChild(newValue);
//  };
//  newValue.appendChild(removeButton);
//  displayArea.appendChild(newValue);
//
//}


function hSelectLocation() {
event.preventDefault();
    const dropdown = document.getElementById("locationH");
    const dropdownName = dropdown.options[dropdown.selectedIndex].value;
    hLocationSearchAction(dropdownName+"h");
}
function hLocationSearchAction(rowId){
    hPrepareLocation(searchAction,rowId);
}
function hLocationDeleteAction(rowId) {
    hPrepareLocation(deleteAction, rowId);
}

function hPrepareLocation(action, rowId){

    const locationRow = document.getElementById(rowId);
//    console.log(locationRow);
    const columns = locationRow.getElementsByTagName("td");
//    console.log(columns)
    const enableColumn = columns[0];
//    console.log(enableColumn);
    const columnInputs = enableColumn.getElementsByTagName("input");
//            console.log(columnInputs);
    const enableColumnInput = columnInputs[0];
//                console.log(enableColumnInput);
    const idColumn = columns[3];
//                console.log("E"+ idColumn);

    if(action===searchAction) {
        $("#"+ rowId).show();
        console.log(rowId);

        enableColumnInput.value = enable;
        const idColumnInnerHtml = idColumn.innerHTML;
        if(Number(idColumnInnerHtml) === defaultIdxVal){
            aIdx++;
            idColumn.innerHTML=String(aIdx);
            hSort(true, 'idH','station-displayH');

        }

    }
    else if(action===deleteAction) {
        enableColumnInput.value = disable;
        idColumn.innerHTML = String(defaultIdxVal);

    }

}

function hSort(ascending, columnClassName, tableId)
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


function hRemoveLocation(ele) {
    event.preventDefault();
    hRemoveLocationByElement(ele);
    hHideLocationForm();

}

function hRemoveLocationByElement(ele){
    const getTdId = document.getElementById(ele.id);
    console.log(getTdId);
    const rowId = getTdId.parentElement;
    console.log(rowId);
    const rowDeleteId = rowId.id;
    console.log(rowDeleteId);
    locationDeleteAction(rowDeleteId)
    $("#" + rowDeleteId).hide();
}

function hHideLocationForm(){
    let isAllLocationDisabled=true;  // all row is having False //
    const rows=document.getElementById("station-displayH").rows;

    let table = document.getElementById("station-displayH");
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
        hHideLocationDiv();
    }
}
function hHideLocationDiv(){
    $("#hidden----").hide();
}