<%@taglib uri='/WEB-INF/mytags/tmtags.tld' prefix='tm' %>
<tm:Module name='DESIGNATION' />
<jsp:useBean id='designationBean' scope='request' class='com.thinking.machines.hr.beans.DesignationBean' />
<jsp:include page='/MasterPageTopSection.jsp' />
<script src='/styletwo/js/DesignationDeleteConfirmation.js'></script>
<h2>Designation (Delete Module)</h2>
<form method='post' action='/styletwo/DeleteDesignation.jsp'>
<tm:FormID />
<input type='hidden' id='code' name='code' value='${designationBean.code}'>
Designation : <b><jsp:getProperty name='designationBean' property='title' /></b><br><br>
Are you sure, You want to delete this designation ? <br><br>
<button type='submit'>Yes</button>
<button type='Button' onclick='cancelDeletion()'>No</button>
</form>
<form id='cancelDeletionForm' action='/styletwo/Designations.jsp'>
</form>
<jsp:include page='/MasterPageBottomSection.jsp' />