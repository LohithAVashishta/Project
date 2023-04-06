
// Standard Files staus (Section B1)
//const doc1='Doc1.txt';
//const docArr = [doc1, 'Doc2.txt', 'Doc3.txt', 'Doc4.txt', 'Doc5.txt'];
//const cont = document.getElementById('standard-file-status');
//const uncheckedNames = document.getElementById('uncheckedNames');
//const ul = document.createElement('ul');
//ul.setAttribute('class', 'list-style-none text-center d-flex flex-wrap p-0');
//ul.setAttribute('id', 'listofcheckboxes');
//for ( var i = 0; i < docArr.length; i++) {
//  var li = document.createElement('li');
//  li.setAttribute('class', 'p-3 col-2 boxli marjus');
//  li.innerHTML = "<input type='checkbox' class='form-check-input' name='" + docArr[i] + "' onchange='updateUncheckedNames(this)'><label>" + "     " + docArr[i] + "</label>";
//  ul.appendChild(li);
//  updateUncheckedNames(li.querySelector('input'));
//}
//cont.appendChild(ul);

function updateUncheckedNames(checkbox) {
  if (!checkbox.checked) {
    uncheckedNames.value += checkbox.name + '\n';
  } else {
    uncheckedNames.value = uncheckedNames.value.replace(checkbox.name + '\n', '');
  }
}



// Dynamic inputs for archival, called on line 243
//const archArr = ['NSOP-2', 'NSOP-4', 'NSDAQ-1', 'NSDAQ-2'];
//const archCont = document.getElementById('archival-container');
//
//const ul1 = document.createElement('ul');
//ul1.setAttribute('class', 'list-style-none text-center d-flex flex-wrap');
//for (i = 0; i < archArr.length; i++) {
//  var li = document.createElement('li');
//  li.setAttribute('class', 'col-3 boxli row');
//  li.innerHTML='<label for=' + archArr[i] + '>' + archArr[i] + ':</label> <select class="form-control col-6" id=' + archArr[i] + ' style="width:100px; margin-left: 25px;" required> <option value="" disabled selected>status</option> <option value="Ok"> OK</option> <option value="Not Ok"> Not OK</option> </select><input type="text" class="form-control col-6" id="' + archArr[i] + '" name="secB3" style="width:100px; margin-left:25px;" placeholder="Size">';
//  ul1.appendChild(li);
//}
//archCont.appendChild(ul1);
//


//  called on line 243

  const table1 = document.getElementById("section-B4-BLRstreamA");
  const table2 = document.getElementById("section-B4-BLRstreamB");
  const table3 = document.getElementById("section-B4-LCKstreamA");
  const table4 = document.getElementById("section-B4-LCKstreamB");

  const satellites = ["SAT02", "SAT03", "SAT06", "SAT09"];
  const servers = ["", "INC1NSOP2", "INC1NSOP4", "INC2NSOP1", "INC2NSOP2"];

  let tableHTML = "";
  for (var i = 0; i <= satellites.length; i++) {
    tableHTML += "<tr>";
    for (var j = 0; j < servers.length; j++) {
      if (i == 0) {
        tableHTML += `<th>${servers[j]}</th>`;
      }
      else if (j == 0) {
        tableHTML += `<th>${satellites[i - 1]}</th>`;
      }
      else {
        tableHTML += `<td><input type="text" style="width:75px" placeholder="enter uere"/></td>`;
      }
    }
    tableHTML += "</tr>";
  }
//  table1.innerHTML = tableHTML;
//  table2.innerHTML = tableHTML;
//  table3.innerHTML = tableHTML;
//  table4.innerHTML = tableHTML;

  const table5 = document.getElementById("table-user-position");
  const locations = ["LCK", "BLR"];
  const servers2 = ["", "B5: INC1NSOP2", "B6: INC1NSOP4", "B7: INC2NSOP1", "B8: INC2NSOP2"];

  let table2HTML = "";
  for (var i = 0; i <= locations.length; i++) {
    table2HTML += "<tr>";
    for (var j = 0; j < servers2.length; j++) {
      if (i == 0) {
        table2HTML += `<th>${servers2[j]}</th>`;
      }
      else if (j == 0) {
        table2HTML += `<th>${locations[i - 1]}</th>`;
      }
      else {
        table2HTML += `<td><input type="text"/></td>`;
      }
    }
    table2HTML += "</tr>";
  }
//  table5.innerHTML = table2HTML;
