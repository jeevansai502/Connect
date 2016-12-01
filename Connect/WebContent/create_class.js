$(document).ready(function(e){

	
	$('#menu-toggle').click(function(e) {
		e.preventDefault();
		
		$('#wrapper').toggleClass('toggled');
	});

	
	$(document).on('click','#light_btn',function(e){

		e.preventDefault();
		      
		$.post("Light",{},function(data){	
        			
			$('#light .modal-body').html("<p>Light is &nbsp;   <button type='button' class='btn btn-default' id='light_switch'>"+data+"</button></p><br>");
		
		});
	});
	
	$(document).on('click','#fan_btn',function(e){

		e.preventDefault();
		      
		$.post("Fan",{},function(data){	
			
			$('#fan .modal-body').html("<p>Fan is  &nbsp;  <button type='button' class='btn btn-default' id='fan_switch'>"  + data + "</button></p><br>");
		
		});
	});
	
	
	$(document).on('click','#light_switch',function(e){
		
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

	$(document).on('click','#fan_switch',function(e){
		
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
	
	
	$('#light').on('hidden.bs.modal',function(){
				
		$('#light .modal-body').html("<form action='#' role='form' method='post'> <button type='button' class='btn btn-default' id='light_btn'>check</button></form>");		
		
	});
	
	$('#fan').on('hidden.bs.modal',function(){
		
		$('#fan .modal-body').html("<form action='#' role='form' method='post'> <button type='button' class='btn btn-default' id='fan_btn'>check</button></form>");
		
		
	});
	
	
});






