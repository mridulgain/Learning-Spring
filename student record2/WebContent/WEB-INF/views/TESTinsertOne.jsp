<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script>
//var jsonText = JSON.parse(jsonObj);	
			
$(document).ready(function(){
	$("#insert").click(function(){
		var jsonObj = {"rollNo" : $("#rollNo").val(),
						"firstName" : $("#firstName").val(),
						"lastName" : $("#lastName").val()
						};
		console.log(JSON.stringify(jsonObj));
		var request = $.ajax({
  			url: "http://localhost:8080/student_record/RestController/insert",
  			type: "POST",
  			data: JSON.stringify(jsonObj),
  			contentType: "application/json",
  			dataType: "json",
  			success: function(data) {
  				$('#status').html("Status : " + data);
  			}	
		});
	});
});
</script>
</head>
<body>
	<h3>Insert one</h3>
	Roll<input type=text id=rollNo value=999><br>
	First name<input type=text id="firstName" value="f999"><br>
	Last name<input type=text id=lastName value="l999"><br>
	<button id=insert value=34>Insert</button>
	<div id=status></div>
</body>	