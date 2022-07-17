



	function registernew() {
			
			var n=document.getElementById("n").value;
			var e=document.getElementById("e").value;
			var p=document.getElementById("p").value;
			
			if(n==null ||n=="" || e==null ||e=="" || p==null ||p==""){
				document.getElementById("fields_error").innerHTML =" All fields are required !!. try agin";
			}
			else{
				
				document.getElementById("fields_error").innerHTML ="";	
			
			 	var xmlHttp = new XMLHttpRequest();
			    xmlHttp.open( "POST", "register_newUser?username="+n+"&email="+e+"&password="+p, false ); // false for synchronous request
			   
			    xmlHttp.setRequestHeader('Content-Type', 'application/json');
			    
			    //xmlHttp.send( null );
		    
				

			    if(xmlHttp.responseText=="email exsist!"){
			    	document.getElementById("fields_error").innerHTML =" Email exsist !!. try agin";	
			    }
			    else{
			    	
			    	//submit1();
			    	//window.location.href = xmlHttp.responseText; // send to dispather
			    }
			}
			
	    }

	function submit1() {
			
        	document.forms["RgisterForm"].submit();
        
        }