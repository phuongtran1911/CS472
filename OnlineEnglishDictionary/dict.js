/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(document).ready(function () {
    $("#lookup").click(function(event) {
        var word = $("#term").val();
        document.getElementById("definition").innerHTML = "";
        $.get("/OnlineEnglishDictionary/dictServlet", {term: word}, function(responseJson) {
            if (responseJson != null) {
                var i = 1;               
                $.each(responseJson, function(key, value) {
                    $("#definition").append(i + " (" + value['wordtype'] + ") :: " + value['definition'] + "<br>");
                    i++;
                });
            }
        });
    });   
});

