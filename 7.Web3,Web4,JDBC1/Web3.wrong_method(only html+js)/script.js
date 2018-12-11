var count = 0; //Счётчик текущего положения.
var name ="";
var soname ="";
var patronymic ="";

function step_forward()
{  
var input_field = document.getElementById("text");
var back_button = document.getElementById("back");
var forward_button = document.getElementById("forward");
 
    if (isEmpty(input_field.value)) //проверка заполнения поля
    { 
        alert("Поле должно быть заполнено!");
        return;
    }

saveResult(input_field);

    if (count == 2) 
    {
		
		input_field.style.visibility = "hidden";
		back_button.style.visibility = "hidden";
		forward_button.style.visibility = "hidden";
        finish();
    }
	if (count == 0) back_button.style.visibility = "visible";

count = count+1;
}

function step_back()
{
var saved_data;
var placeholder;
count = count-1;
switch (count)
{
    case 0: //переход на страницу с именем
    saved_data = name;  
    placeholder = "Имя";   
    document.getElementById("back").style.visibility = "hidden";   
    break;
    case 1: //переход на страницу с фамилией
    saved_data = soname;    
    placeholder = "Фамилия";
    break;
}
document.getElementById("text").value = saved_data;
document.getElementById("text").placeholder = placeholder;
}

function isEmpty(str)
{
    return (str == null) || (str.length == 0) || (str == "");
}

function saveResult(input_field)
{
var text = input_field.value;
switch (count) 
{
    case 0:	
		name = text;  
        input_field.placeholder = "Фамилия"; 
		input_field.value = soname;
        break;   
    case 1:
		soname = text;
        input_field.placeholder  = "Отчество";
		input_field.value = patronymic;		
        break;
    case 2:
        patronymic = text;
        break;
    }
}



function finish()
{ 
    alert("Hello, " + " " + name + " " + soname + " " + patronymic);
}