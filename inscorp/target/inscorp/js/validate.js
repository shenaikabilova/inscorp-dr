function isValidRegNumber() {
	var str = document.getElementById("registrationNumber").value;
	var reg = /^(Е|А|В|ВТ|ВН|ВР|ЕВ|ТХ|К|КН|ОВ|М|РА|РК|ЕН|РВ|РР|Р|СС|СН|СМ|СО|С|СА|СВ|СТ|Т|Х|Н|У)[1-9]{4}[А-Я]{1,2}$/;
	var result = reg.test(str);
	if(!result) {
		alert("Грешен регистрационен номер!");
	}
}

function validateEmail() {
	var email = document.getElementById("e-mail").value;
    var re = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
    if(!re.test(email)) {
    	alert("Невалиден е-майл адрес!");
    }
}