function onLoad() {
	arr = ["до   20 места включително",
	           "над 20 места до 40 места",
	           "над 40 места"];
	document.getElementById("kubici").innerHTML = "";
	var kubici = document.getElementById('kubici');
	for(var i = 0; i < arr.length; i++) {
		var option = document.createElement('option');
		option.text = option.value = arr[i];
		kubici.add(option, 0);
	}
	sum();
	
//	document.getElementById('policaN').value=Math.floor(Math.random()*999999);
}