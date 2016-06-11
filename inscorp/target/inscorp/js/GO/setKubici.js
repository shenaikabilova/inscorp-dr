function change() {
	var arr = [];
	switch(document.getElementById("vehicleType").value) {
	case 'Автомобил':
		if(!arr.length) {
		arr = ["до 1100 куб см", 
		           "от 1101 до 1200 куб см", 
		           "от 1201 до 1400 куб см",
				   "от 1401 до 1600 куб см", 
				   "от 1601 до 1800 куб см", 
				   "от 1801 до 2000 куб см",
				   "от 2001 до 2200 куб см", 
				   "от 2201 до 2500 куб см", 
				   "над  2500 куб см", 
				   "Електромобил"];
		document.getElementById("kubici").innerHTML = "";
		var kubici = document.getElementById('kubici');
		for(var i = 0; i < arr.length; i++) {
			var option = document.createElement('option');
	    	option.text = option.value = arr[i];
	    	kubici.add(option, 0);
		}}
		sum();
	break;
	
	case 'Товарни автомобили':
		if(!arr.length) {
		arr = ["до 0.8 т. включително",
				   "над 0.8 до 1.5 т.",
				   "над 1,5 до 2.5 т.",
				   "над 2,5 до 3.5 т.",
				   "над 3,5 до 5,0 т.",
				   "над 5,0 до 10 т.",
	 			   "над 10  до 20 т.",
				   "над 20 т."];
		document.getElementById("kubici").innerHTML = "";
		var kubici = document.getElementById('kubici');
		for(var i = 0; i < arr.length; i++) {
			var option = document.createElement('option');
	    	option.text = option.value = arr[i];
	    	kubici.add(option, 0);
		}}
		sum();
	break;
	
	case 'Мотоциклет':
		if(!arr.length) {
			arr = ["до 50 куб. см.",
			       "над   50 до 125 куб. см",
			       "над 125 до 250 куб. см",
			       "над 250 до 350 куб. см",
			       "над 350 до 490 куб. см",
			       "над 490 до 750 куб. см",
			       "над 750 куб. см"];
			document.getElementById("kubici").innerHTML = "";
			var kubici = document.getElementById('kubici');
			for(var i = 0; i < arr.length; i++) {
				var option = document.createElement('option');
		    	option.text = option.value = arr[i];
		    	kubici.add(option, 0);
			}}
		sum();
	break;
		
	case 'Автобус':
		if(!arr.length) {
		arr = ["до   20 места включително",
		           "над 20 места до 40 места",
		           "над 40 места"];
		document.getElementById("kubici").innerHTML = "";
		var kubici = document.getElementById('kubici');
		for(var i = 0; i < arr.length; i++) {
			var option = document.createElement('option');
	    	option.text = option.value = arr[i];
	    	kubici.add(option, 0);
		}}
		sum();
	break;
	}
}