<!DOCTYPE html>
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script>
function createTable(jsonObj){
			var str="<table border=1><th>roll</th><th>fname</th><th>lname</th>";
			for(i = 0; i < jsonObj.length; i++){
				str += "<tr>";
				str += "<td>"+jsonObj[i].roll+"</td>";
				str += "<td>"+ jsonObj[i].first_name+"</td>";
				str += "<td>"+ jsonObj[i].last_name+"</td>";
				str += "</tr>";
			}
			str += "</table>";
			document.getElementById("records").innerHTML = str;
}
$(document).ready(function(){
  $("button").click(function(){
    $.ajax({url: "http://localhost:8080/student_record/RestController/roll/" + $('#roll').val(), 
    		type:"GET", 
    		success: function(result){
      createTable(result);
    }});
  });
});
</script>
</head>
<body>
<h2>Student record</h2>
roll<input id=roll type=text value=all><button>Get records</button>
<div id="records"></div>
</body>
</html>