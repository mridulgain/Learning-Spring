<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<!DOCTYPE html>  
<html>  
<head>  
	<title>Excel File Upload</title>  
	<script type='text/javascript'>
	function validateFileSize() {
    	var input, file;	
	    // (Can't use `typeof FileReader === "function"` because apparently
	    // it comes back as "object" on some browsers. So just see if it's there
	    // at all.)
	    if (!window.FileReader) {
	        showMessage("The file API isn't supported on this browser yet.");
	        return false;
	    }
	
	    input = document.getElementById('fileToUpload');
	    if (!input) {
	        showMessage("Um, couldn't find the fileinput element.");
	        return false;
	    }
	    else if (!input.files) {
	        showMessage("This browser doesn't seem to support the `files` property of file inputs.");
	        return false;
	    }
	    else if (!input.files[0]) {
	        showMessage("Please select a file before clicking 'Load'");
	        return false;
	    }
	    else {
	        file = input.files[0];
	        var tempStr = file.name.split(".");
	        var fileExtension = tempStr[tempStr.length - 1];
	        if(fileExtension != "xls" && fileExtension != "xlsx"){
	        	showMessage("Select a file with .xls or .xlsx extention");
	        	return false;
	        }
	        if(file.size > 2097152){
	        	showMessage("Max file size 2MB");
	        	return false;
	        }
	        showMessage("File " + file.name + " is " + file.size + " bytes in size");
	        return true;
	    }
	}	
	function showMessage(innerHTML) {
	    document.getElementById("status").innerHTML = innerHTML;
	}
	</script>
</head>  
<body>  
<h1>Upload excel file</h1>  
<form:form method="post" action="savefile" enctype="multipart/form-data">  
<p><label for="image">Choose Image</label></p>  
<p><input name="file" id="fileToUpload" type="file" /></p>  
<p><input type="submit" value="Upload" onclick='return validateFileSize();'></p>  
</form:form>
<div id="status"></div>
</body>  
</html>