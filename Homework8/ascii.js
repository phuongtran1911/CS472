/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function idle() {
    document.getElementById("text").innerHTML = 
            ANIMATIONS["Exercise"] + "=====\n" +
            ANIMATIONS["Juggler"] + "=====\n" + 
            ANIMATIONS["Bike"] + "=====\n" + 
            ANIMATIONS["Dive"];
}

function reset() {
    document.getElementById("text").innerHTML = "";
}
var timer;
var interval;
function start() {
    document.getElementById("start").disabled = true;
    document.getElementById("stop").disabled = false;
    document.getElementById("animation").disabled = true;
    reset();
    if (document.getElementById("size").value === "Tiny")
        document.getElementById("text").style.fontSize = "7pt";
    if (document.getElementById("size").value === "Small")
        document.getElementById("text").style.fontSize = "10pt";
    if (document.getElementById("size").value === "Medium")
        document.getElementById("text").style.fontSize = "12pt";
    if (document.getElementById("size").value === "Large")
        document.getElementById("text").style.fontSize = "16pt";
    if (document.getElementById("size").value === "Extra Large")
        document.getElementById("text").style.fontSize = "24pt";
    if (document.getElementById("size").value === "XXL")
        document.getElementById("text").style.fontSize = "32pt";
    
    if (document.getElementById("turbo").checked === true) {
        timer = 50;
    } else {
        timer = 250;
    }
    interval = setInterval(run, timer);
    
}
function run() {
    if (document.getElementById("animation").value === "Blank") 
        document.getElementById("text").innerHTML = document.getElementById("text").textContent + ANIMATIONS["Blank"];            
    if (document.getElementById("animation").value === "Custom")
        document.getElementById("text").innerHTML = document.getElementById("text").textContent + ANIMATIONS["Custom"]; 
    if (document.getElementById("animation").value === "Exercise")
        document.getElementById("text").innerHTML = document.getElementById("text").textContent + ANIMATIONS["Exercise"]; 
    if (document.getElementById("animation").value === "Juggler")
        document.getElementById("text").innerHTML = document.getElementById("text").textContent + ANIMATIONS["Juggler"]; 
    if (document.getElementById("animation").value === "Bike")
        document.getElementById("text").innerHTML = document.getElementById("text").textContent + ANIMATIONS["Bike"]; 
    if (document.getElementById("animation").value === "Dive")
        document.getElementById("text").innerHTML = document.getElementById("text").textContent + ANIMATIONS["Dive"]; 
}

function stop() {
    document.getElementById("start").disabled = false;
    document.getElementById("stop").disabled = true;
    document.getElementById("animation").disabled = false;
    clearInterval(interval);
}

