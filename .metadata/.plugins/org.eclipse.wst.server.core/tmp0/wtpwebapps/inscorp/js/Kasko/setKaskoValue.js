function change() {
	var insValue = document.getElementById("vehicleInsValue").value;

	switch(document.getElementById("vehicleType").value) {
	case 'Автомобил':
		document.getElementById('vehicleInsPremiq').value=insValue*0.05;
	break;
	
	case 'Товарни автомобили':
		document.getElementById('vehicleInsPremiq').value=insValue*0.07;
	break;
	
	case 'Мотоциклет':
		document.getElementById('vehicleInsPremiq').value=insValue*0.06;
	break;
		
	case 'Автобус':
		document.getElementById('vehicleInsPremiq').value=insValue*0.03;
	break;
	}
}