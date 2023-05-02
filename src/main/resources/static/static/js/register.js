// register function
function handleRegister() {
	var username = $("#registerUsername").val();
	var password1 = $("#pwd1").val();
	var password2 = $("#pwd2").val();

	// check if the username is empty
	if(username === null || username ==="") {
		alert("Please enter the username");
		return;
	}
	// check if the password is empty
	if(password1 === null || password1 ==="") {
		alert("Please enter the password");
		return;
	}
	// check if the confirmed password is empty
	if(password2 === null || password2 ==="") {
		alert("Please enter the password");
		return;
	}
	// check if the two passwords are the same
	if(password1 != password2) {
		alert("Two passwords do not match");
		return;
	}

	// send the request to the server
	data = {
		username: username,
		password: password1
	}

	$.ajax({
		url: "http://127.0.0.1:8888/user/register",
		contentType: "application/json",
		dataType: "json",
		type: "post",
		data: JSON.stringify(data),
		success: function(response) {
			alert(response.message)
		},
		error: function(response) {
			console.log(response)
		}
	})
}