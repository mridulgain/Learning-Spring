<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js" type="text/javascript"></script>  
<script src="https://cdnjs.cloudflare.com/ajax/libs/xlsx/0.7.7/xlsx.core.min.js"></script>  
<script src="https://cdnjs.cloudflare.com/ajax/libs/xls/0.7.4-a/xls.core.min.js"></script> 
<script>
function ExportToJson() {  
     var regex = /^([a-zA-Z0-9\s_\\.\-:(\)])+(.xlsx|.xls)$/;  
     /*Checks whether the file is a valid excel file*/  
     if (regex.test($("#excelfile").val().toLowerCase())) {  
         var xlsxflag = false; /*Flag for checking whether excel is .xls format or .xlsx format*/  
         if ($("#excelfile").val().toLowerCase().indexOf(".xlsx") > 0) {  
             xlsxflag = true;  
         }  
         /*Checks whether the browser supports HTML5*/  
         if (typeof (FileReader) != "undefined") {  
             var reader = new FileReader();  
             reader.onload = function (e) {  
                 var data = e.target.result;  
                 /*Converts the excel data in to object*/  
                 if (xlsxflag) {  
                     var workbook = XLSX.read(data, { type: 'binary' });  
                 }  
                 else {  
                     var workbook = XLS.read(data, { type: 'binary' });  
                 }  
                 /*Gets all the sheetnames of excel in to a variable*/  
                 var sheet_name_list = workbook.SheetNames;
			                     /*Convert the cell value to Json*/  
                 if (xlsxflag) {  
                     var exceljson = XLSX.utils.sheet_to_json(workbook.Sheets[sheet_name_list[0]]);  
                 }  
                 else {  
                     var exceljson = XLS.utils.sheet_to_row_object_array(workbook.Sheets[sheet_name_list[0]]);  
                 }  
                 if (exceljson.length > 0) {  
                     //ajax 
            		var request = $.ajax({
  					url: "http://localhost:8080/student_record/RestController/insert/excel",
  					type: "POST",
  					contentType:'application/json',//sent data type
  					data: JSON.stringify(exceljson),//prob if not stringified
  					dataType: "json",//return data type
  					success: function(data) {
  								console.log(data);
  							 },
  		  			error: function(xhr, textStatus, errorThrown){
								alert('request failed'+errorThrown);
							}
					});
                     console.log(JSON.stringify(exceljson)); 
                 }  
             }  
             if (xlsxflag) {/*If excel file is .xlsx extension than creates a Array Buffer from excel*/  
                 reader.readAsArrayBuffer($("#excelfile")[0].files[0]);  
             }  
             else {  
                 reader.readAsBinaryString($("#excelfile")[0].files[0]);  
             }  
         }  
         else {  
             alert("Sorry! Your browser does not support HTML5!");  
         }  
     }  
     else {  
         alert("Please upload a valid Excel file!");  
     }  
 }
</script>
</head>
<body>
    <input type="file" id="excelfile" />  
       <input type="button" id="viewfile" value="Export To MongoDB" onclick="ExportToJson()" />  
</body>