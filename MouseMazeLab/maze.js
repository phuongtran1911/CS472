/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(document).ready(function() {
    $("#start").click(function() {
        $(".boundary").removeClass("youlose");
        $("#status").text("Click the \"S\" to begin.");
    });
    /*$("#boundary1").mouseover(function() {
        $("#boundary1").addClass("youlose");
    });
    $("#boundary2").mouseover(function() {
        $("#boundary2").addClass("youlose");
    });
    $("#boundary3").mouseover(function() {
        $("#boundary3").addClass("youlose");
    });
    $("#boundary4").mouseover(function() {
        $("#boundary4").addClass("youlose");
    });
    $("#boundary5").mouseover(function() {
        $("#boundary5").addClass("youlose");
    });*/
    $(".boundary").mouseover(function() {
        $(".boundary").addClass("youlose");
    });
    $("#maze").mouseout(function() {
        $("#end").click(function() {
            $(".boundary").addClass("youlose");
        });
    });
    $("#end").click(function() {
        if ($(".boundary").hasClass("youlose")) {
            alert("Sorry, you lost. :(");
            $("#status").text("Sorry, you lost. :(");
        } else {
            alert("You win! :)");
            $("#status").text("You win! :)");
        } 
    });
    
    
});
