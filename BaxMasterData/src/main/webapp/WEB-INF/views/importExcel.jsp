<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<script type="text/javascript">
$(document).ready(function() {
    $('#submit').bind("click",function() 
    { 
        var imgVal = $('#file').val(); 
        if(imgVal=='') 
        { 
            alert("Please select a file to upload"); 
			return false;
        } 
        return true; 

    }); 
});
</script>
<script type="text/javascript" language="javascript">
function checkfile(sender) {
    var validExts = new Array(".xlsx", ".xls");
    var fileExt = sender.value;
    fileExt = fileExt.substring(fileExt.lastIndexOf('.'));
    if (validExts.indexOf(fileExt) < 0) {
      alert("Invalid file selected, valid files are of " +
               validExts.toString() + " types.");
      $('#file').val("");
      return false;
    }
    else return true;
}
</script>
<div class="header_content">Import Excel</div>
<div class="header_space_filler"></div>
<div class="updates_content">
	<form:form method="POST" action="${pageContext.request.contextPath}/importExcelContent" modelAttribute="fileUploadForm" enctype="multipart/form-data">
	<input type="file" name="file" id="file" onchange="checkfile(this)" value="BROWSE" />
	<form:select path="fileName">
		<form:option value="MasterData" label="MasterData">MasterData</form:option>
	</form:select>
	<input type="submit" name="submit" id="submit" value="SUBMIT" />
	</form:form>
</div>