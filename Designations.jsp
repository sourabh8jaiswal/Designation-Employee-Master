<%@taglib uri='/WEB-INF/mytags/tmtags.tld' prefix='tm' %>
<tm:Module name='DESIGNATION' />
<jsp:include page='/MasterPageTopSection.jsp' />
<link rel='stylesheet' type='text/css' href='/stylethree/css/designations.css' />
<script>

function cancelDeletedNotification()
{
var designationDeletedNotification=document.getElementById('designationDeletedNotification');
var designationsView=document.getElementById('designationsView');
designationDeletedNotification.style='display:none';
designationsView.style='display:block';
window.location.reload(true);
}


function deleteDesignation()
{
var xmlHttpRequest=new XMLHttpRequest();
var designationDeleteConfirmationForm=document.getElementById('designationDeleteConfirmationForm');
var designationDeletedNotification=document.getElementById('designationDeletedNotification');
var messageSpan=designationDeletedNotification.getElementsByTagName("span")[0];
var codeTextBox=designationDeleteConfirmationForm.getElementsByTagName("input")[0];
var code=codeTextBox.value;
var dataToSend="code="+encodeURI(code);
var responseData='';
xmlHttpRequest.onreadystatechange=function()
{
if(this.readyState==4)
{
if(this.status==200)
{
responseData=this.responseText;
if(responseData=="deleted")
{
designationDeleteConfirmationForm.style='display:none';
designationDeletedNotification.style='display:block';
messageSpan.innerHTML="Designation deleted."
}else
{
designationDeleteConfirmationForm.style='display:none';
designationDeletedNotification.style='display:block';
messageSpan.innerHTML=responseData;
}
}else
{
alert('some problem');
}
}
};
xmlHttpRequest.open('POST','deleteDesignation',true);
xmlHttpRequest.setRequestHeader("Content-Type","application/x-www-form-urlencoded")
xmlHttpRequest.send(dataToSend);
}

function cancelDeletion()
{
var designationDeleteConfirmationForm=document.getElementById('designationDeleteConfirmationForm');
var designationsView=document.getElementById('designationsView');
designationDeleteConfirmationForm.style='display:none';
designationsView.style='display:block';
}

function designationDeleteConfirmation(code,title)
{
//alert(code);
//alert(title);
var designationsView=document.getElementById('designationsView');
var designationDeleteConfirmationForm=document.getElementById('designationDeleteConfirmationForm');
var titleSpan=designationDeleteConfirmationForm.getElementsByTagName("span")[0];
var codeTextBox=designationDeleteConfirmationForm.getElementsByTagName("input")[0];
titleSpan.innerHTML=title;
codeTextBox.value=code;
designationsView.style='display:none';
designationDeleteConfirmationForm.style='display:block';
}

function cancelUpdation()
{
var designationUpdated=document.getElementById('designationUpdated');
var designationsView=document.getElementById('designationsView');
designationUpdated.style='display:none';
designationsView.style='display:block';
window.location.reload(true);
}

function updateDesignation()
{
var designationEditForm=document.getElementById('designationEditForm');
var codeTextBox=designationEditForm.getElementsByTagName('input')[0];
var titleTextBox=designationEditForm.getElementsByTagName('input')[1];
var code=codeTextBox.value;
var title=titleTextBox.value;
var responseData=' ';
var xmlHttpRequest=new XMLHttpRequest();
xmlHttpRequest.onreadystatechange=function()
{
if(this.readyState==4)
{
if(this.status==200)
{
responseData=this.responseText;
//alert(responseData);
if(responseData=="updated")
{
var designationUpdated=document.getElementById('designationUpdated');
codeTextBox.value="";
titleTextBox.value="";
designationEditForm.style='display:None';
designationUpdated.style='display:block';
}else
{
var errorSection=designationEditForm.getElementsByTagName('span')[0];
errorSection.innerHTML=responseData;
}
}else
{
alert("some problem");
}
}
};
var dataToSend="code="+encodeURI(code);
dataToSend=dataToSend+"&title="+encodeURI(title);
xmlHttpRequest.open('POST','updateDesignation',true);
xmlHttpRequest.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
xmlHttpRequest.send(dataToSend);
}

function cancelEdition()
{
var designationEditForm=document.getElementById('designationEditForm');
var titleTextBox=designationEditForm.getElementsByTagName('input')[0];
var errorSection=designationEditForm.getElementsByTagName('span')[0];
var designationsView=document.getElementById('designationsView');
errorSection.innerHTML="";
titleTextBox.value="";
designationEditForm.style='display:none';
designationsView.style='display:block';
}

function designationEditForm(code,title)
{
//alert(code);
//alert(title);
var designationsView=document.getElementById('designationsView');
var designationEditForm=document.getElementById('designationEditForm');
designationsView.style='display:none';
designationEditForm.style='display:block';
var codeTextBox=designationEditForm.getElementsByTagName("input")[0];
var titleTextBox=designationEditForm.getElementsByTagName("input")[1];
codeTextBox.value=code;
titleTextBox.value=title;
}


function cancelAddition()
{
var designationAddForm=document.getElementById('designationAddForm');
var titleTextBox=designationAddForm.getElementsByTagName('input')[0];
var errorSection=designationAddForm.getElementsByTagName('span')[0];
var designationsView=document.getElementById('designationsView');
errorSection.innerHTML="";
titleTextBox.value="";
designationAddForm.style='display:none';
designationsView.style='display:block';
window.location.reload(true);
}
function addDesignation()
{
var designationAddForm=document.getElementById('designationAddForm');
var titleTextBox=designationAddForm.getElementsByTagName('input')[0];
var responseData=' ';
var xmlHttpRequest=new XMLHttpRequest();
xmlHttpRequest.onreadystatechange=function()
{
if(this.readyState==4)
{
if(this.status==200)
{
responseData=this.responseText;
if(responseData=="added")
{
var designationAdded=document.getElementById('designationAdded');
titleTextBox.value="";
designationAddForm.style='display:None';
designationAdded.style='display:block';
}else
{
var errorSection=designationAddForm.getElementsByTagName('span')[0];
errorSection.innerHTML=responseData;
}
}else
{
alert("some problem");
}
}
};
var title=titleTextBox.value;
var requestURL="addDesignation?title="+encodeURI(title);
xmlHttpRequest.open('GET',requestURL,true);
xmlHttpRequest.send();
}
function getDesignationAddForm()
{
var designationsView=document.getElementById('designationsView');
var designationAddForm=document.getElementById('designationAddForm');
var designationAdded=document.getElementById('designationAdded');
designationsView.style='display:none';
designationAdded.style='display:none';
designationAddForm.style='display:block';
}
function populateDesignations()
{
var xmlHttpRequest=new XMLHttpRequest()
xmlHttpRequest.onreadystatechange=function()
{
if(this.readyState==4)
{
if(this.status==200)
{
var responseData=this.responseText;
var splits=responseData.split(",");
//alert(splits);
var designationsGridTable=document.getElementById("designationsGridTable");
var designationsGridTableBody=document.getElementsByTagName("tbody")[0];
var designationsGridTableBodyRowTemplate=designationsGridTableBody.getElementsByTagName("tr")[0];
designationsGridTableBodyRowTemplate.remove();
var designationsGridTableColumnsTemplateCollection=designationsGridTableBodyRowTemplate.getElementsByTagName("td");
var cellTemplate;
var dynamicRow;
var dynamicRowCells;
var placeHolderFor;
var j=1;
for(var k=0;k<splits.length;k+=2)
{
dynamicRow=designationsGridTableBodyRowTemplate.cloneNode(true);
designationsGridTableBody.appendChild(dynamicRow);
dynamicRowCells=dynamicRow.getElementsByTagName("td");
for(var i=0;i<dynamicRowCells.length;i++)
{
cellTemplate=dynamicRowCells[i];
placeHolderFor=cellTemplate.getAttribute("placeHolderId");
if(placeHolderFor==null)continue;
if(placeHolderFor=="serialNumber") cellTemplate.innerHTML=j;
if(placeHolderFor=="code") cellTemplate.innerHTML=splits[k];
if(placeHolderFor=="title") cellTemplate.innerHTML=splits[k+1];
if(placeHolderFor=="editOption") cellTemplate.innerHTML="<a href=\'#\' onclick=\'designationEditForm("+splits[k]+",\""+splits[k+1]+"\")\'>Edit</a>";
if(placeHolderFor=="deleteOption") cellTemplate.innerHTML="<a href=\'#\' onclick=\'designationDeleteConfirmation("+splits[k]+",\""+splits[k+1]+"\")\'>Delete</a>";
}
j=j+1
}
}else
{
alert('some problem');
}
}
};
xmlHttpRequest.open('GET','getDesignations',true);
xmlHttpRequest.send(); 
}
window.addEventListener('load',populateDesignations());
</script>
<div id='designationsView' style='display:block'>
<h2>Designations</h2>
<table border='1' id='designationsGridTable'>
<thead>
<tr>
<th colspan='4' class='designationGridHeader'>
<a href='#' onclick='getDesignationAddForm()'>Add new designation</a>
</th>
</tr>
<tr>
<th class='designationGridSNOColumnTitle'>S.No.</th>
<th class='designationGridDesignationColumnTitle'>Designation</th>
<th class='designationGridEditOptionColumnTitle'>Edit</th>
<th class='designationGridDeleteOptionColumnTitle'>Delete</th>
</tr>
</thead>
<tbody>
<tr>
<td placeHolderId='serialNumber' style='text-align:right'></td>
<td placeHolderId='title'></td>
<td placeHolderId='editOption' style='text-align:center'></td>
<td placeHolderId='deleteOption' style='text-align:center'></td>
</tr>
</tbody>
</table>
</div>

<div id='designationAddForm' style='display:none'>
<h2>Designation (Add Module)</h2>
<span class='error' id='errorSection'>
</span><br>
Designation
<input type='text' id='title' name='title' maxlength='35' size='36'>
<span id='titleErrorSection' class='error'></span><br><br>
<button type='button' onclick='addDesignation()'>Add</button>
<button type='button' onclick='cancelAddition()'>Cancel</button>
</div>

<div id='designationAdded' style='display:none'>
<h2>Designation Added  (Add Module)</h2>
Designation added, add more ?
<table>
<tr>
<td>
<button onclick='getDesignationAddForm()'>Yes</button>
</td>
<td>
<button onclick='cancelAddition()'>No</button>
</td>
</tr>
</table>
</div>


<div id='designationEditForm' style='display:none'>
<h2>Designation (Edit Module)</h2>
<span class='error' id='errorSection'>
</span><br>
Designation
<input type='hidden' id='code' name='code'>
<input type='text' id='title' name='title' maxlength='35' size='36'>
<span id='titleErrorSection' class='error'></span><br><br>
<button type='submit' onclick='updateDesignation()'>Update</button>
<button type='Button' onclick='cancelEdition()'>Cancel</button>
</div>

<div id='designationUpdated' style='display:none'>
<h2>Designation  (Edit Module)</h2>
Designation updated.
<br>
<button onclick='cancelUpdation()'>OK</button>
</div>

<div id='designationDeleteConfirmationForm' style='display:none'>
<h2>Designation (Delete Module)</h2>
<input type='hidden' id='code' name='code'>
Designation : <b><span id='title'></span></b><br><br>
Are you sure, You want to delete this designation ? <br><br>
<button type='Button' onclick='deleteDesignation()'>Yes</button>
<button type='Button' onclick='cancelDeletion()'>No</button>
</div>

<div id='designationDeletedNotification' style='display:none'>
<h2>Designation  (Delete Module)</h2>
Notification : <span id='message'></span><br>
<br>
<button onclick='cancelDeletedNotification()'>OK</button>
</div>


<jsp:include page='/MasterPageBottomSection.jsp' />