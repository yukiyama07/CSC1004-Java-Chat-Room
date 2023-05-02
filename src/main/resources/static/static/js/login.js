// define a user object
var userInfo = {}

// login function
function handleLogin() {
    var username = $("#loginUsername").val();
	var password = $("#loginPassword").val();
	// check if the username and password are empty
	if(username === null || username === ""){
		alert("Please enter the username")
		return;
	}
	// check if the password is empty
	if(password === null || password === ""){
		alert("Please enter the password")
	}

	// send the request to the server
	var data = {
		username: username,
		password: password
	}

	$.ajax({
		url: "http://127.0.0.1:8888/user/login",
		contentType: "application/json",
		dataType: "json",
		type: "post",
		data: JSON.stringify(data),
		success: function(response){
			// check if the login is successful
			if(response.message == "Login Success"){
				userInfo = response.data;
				localStorage.setItem("userInfo", JSON.stringify(userInfo));
				// redirect to the chat page
				window.location.href="/UChat/index.html";
			}else{
				alert(response.message)
			}
		},
		error: function(response) {
			console.log(response)
		}
	})
}