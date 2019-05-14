/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var accountInfoList = [];

function Account(name, balance) {
    this.name = name;
    this.balance = balance;
}

var account = (function() {
    var createAccount = function() {
        var name = document.getElementById("name").value;
        var balance = document.getElementById("deposit").value;
        var newAccount = new Account(name, balance);
        accountInfoList.push(newAccount);
    };

    var display = function() {
        createAccount();
        var info = "";
        for (var i = 0; i < accountInfoList.length; i++) {
            info += "Account name: " + accountInfoList[i].name + " Balance: " + accountInfoList[i].balance + "\n";
        }   
        document.getElementById("text").innerHTML = info;
    };
    return display;
})();


