
function check(){
	var focusSet=false;

	var p1 = $('#password').val();	
	var p2 = $('#confirm_password').val();	
	if(p1 != p2){
		$('#confirm_password').get(0).setCustomValidity("Passwords Don't Match");

	}else{
		document.getElementById("confirm_password").setCustomValidity('');	 
	}
}


