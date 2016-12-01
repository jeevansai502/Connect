	
	function fun1(param){
		
		//alert("a");
		var id = param.id;
			
		//var state = $('#' + id).text();
		var state = $(param).text();
		var change;
	
		state = state.trim();
		
		if(state == "ON"){
			change = "OFF";
			
		}else if(state == "OFF")
			change = "ON";
		
		$.ajax({

			type: "GET",
			url: "Light_control?val="+change+"&id="+id,
			success: function(data){
				
            $(param).text(change);
			}
		});
		
	}
	
	function fun2(param){

		
		//alert("b");
		var id = param.id;

		var state = $(param).text();
		var change;
	
		state = state.trim();
		
		if(state == "ON"){
			change = "OFF";
			
		}else if(state == "OFF")
			change = "ON";
		
		$.ajax({

			type: "GET",
			url: "Fan_control?val="+change+"&id="+id,
			success: function(data){
	       $(param).text(change);
	     
			}
		});
		
		
		
	}
	
	/*$(document).on('click','.light_switch',function(e){
		
		e.preventDefault();

		var state = $('#light_switch').text();
		var change;
	
		state = state.trim();
		
		if(state == "ON"){
			change = "OFF";
			
		}else if(state == "OFF")
			change = "ON";
		
		$.ajax({

			type: "GET",
			url: "Light_change?id="+change,
			success: function(data){
				
				$('#light .modal-body').html("<p>Light is &nbsp;   <button type='button' class='btn btn-default' id='light_switch'>" + change + "</button></p><br>");

			}
		});
		
		
	});
	
	$(document).on('click','.fan_switch',function(e){
		
		e.preventDefault();

		var state = $('#fan_switch').text();
		var change;
	
		state = state.trim();
		
		if(state == "ON"){
			change = "OFF";
			
		}else if(state == "OFF")
			change = "ON";
		
		$.ajax({

			type: "GET",
			url: "Fan_change?id="+change,
			success: function(data){
				
				$('#fan .modal-body').html("<p>Fan is &nbsp;   <button type='button' class='btn btn-default' id='fan_switch'>" + change + "</button></p><br>");

			}
		});
		
		
	});
	*/
	
