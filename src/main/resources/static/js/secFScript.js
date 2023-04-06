//const deleteAction='delete';
//const searchAction='search';
//const enable= "True";
//const disable = "False"
//const defaultIdxVal=0;
//var aIdx=0;

function fSelectLocation() {
    const dropdown = document.getElementById("stationF1");
    const dropdownName = dropdown.options[dropdown.selectedIndex].value;
    fLocationSearchAction(dropdownName);
//    console.log("fSelectLocation is called");
}
function fLocationSearchAction(rowId){
    fPrepareLocation(searchAction,rowId);
    console.log(rowId);
}
function fLocationDeleteAction(rowId) {
    fPrepareLocation(deleteAction, rowId);
}

function fPrepareLocation(action, rowId){

    const locationRow = document.getElementById(rowId);
//    console.log(locationRow);
    const columns = locationRow.getElementsByTagName("td");

    const enableColumn = columns[0];
//    console.log("F"+ enableColumn);
    const columnInputs = enableColumn.getElementsByTagName("input");
//        console.log("F"+ columnInputs);
    const enableColumnInput = columnInputs[0];
//            console.log("F"+ enableColumnInput);
    const idColumn = columns[2];
//                console.log("F"+ idColumn);
    if(action===searchAction) {
        $("#"+ rowId).show();
        enableColumnInput.value = enable;
        const idColumnInnerHtml = idColumn.innerHTML;
        if(Number(idColumnInnerHtml) === defaultIdxVal){
            aIdx++;
            idColumn.innerHTML=String(aIdx);
            fSort(true, 'idF','Station-display-F');

        }

    }
    else if(action===deleteAction) {
        enableColumnInput.value = disable;
        idColumn.innerHTML = String(defaultIdxVal);

    }
//    console.log("fPrepareLocation is called");

}

function fSort(ascending, columnClassName, tableId)
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
//    console.log("fSort is called");
};


function fRemoveLocation(ele) {
    event.preventDefault();
    fRemoveLocationByElement(ele);
    fHideLocationForm();

}

function fRemoveLocationByElement(ele){
    const getTdId = document.getElementById(ele.id);
    console.log(getTdId);
    const rowId = getTdId.parentElement;
    console.log(rowId);
    const rowDeleteId = rowId.id;
    console.log(rowDeleteId);
    fLocationDeleteAction(rowDeleteId)
    $("#" + rowDeleteId).hide();
}

function fHideLocationForm(){
    let isAllLocationDisabled=true;  // all row is having False //
    const rows=document.getElementById("Station-display-F").rows;

    let table = document.getElementById("Station-display-F");
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
        fHideLocationDiv();
    }
}
function fHideLocationDiv(){
    $("#hidden-issues81").hide();
}