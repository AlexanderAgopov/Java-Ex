/**
 * 
 */

function msg() {
	alert("Nice one!");
}

function bulbOn() {
	document.getElementById("bulb1").src = "pic_bulbon.gif";
}

function bulbOff() {
	document.getElementById("bulb1").src = "pic_bulboff.gif";
}

function setStyle() {
	document.getElementById("jsol").style.fontSize = "40px";
	document.getElementById("jsol").style.color = "red";
	document.getElementById("jsol").style.backgroundColor = "black";
}