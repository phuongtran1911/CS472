/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.cs545;

/**
 *
 * @author ThinkPad
 */
public class RadioState {
    String yesCheck1;
    String noCheck1;
    String yesCheck2;
    String noCheck2;
    String yesCheck3;
    String noCheck3;

    public String getYesCheck1() {
        return yesCheck1;
    }

    public String getNoCheck1() {
        return noCheck1;
    }

    public String getYesCheck2() {
        return yesCheck2;
    }

    public String getNoCheck2() {
        return noCheck2;
    }

    public String getYesCheck3() {
        return yesCheck3;
    }

    public String getNoCheck3() {
        return noCheck3;
    }
    
    public void answer(String choice, String radio) {
        if (choice != null) {
            System.out.println ("choice= "+ choice);
            if (choice.equals("1") && radio.equals("radioJSPCool")) {
                yesCheck1 = "checked";
            }
            if (choice.equals("0") && radio.equals("radioJSPCool")) {
                noCheck1 = "checked";
            }
            if (choice.equals("1") && radio.equals("JSFwayCool")) {
                yesCheck2 = "checked";
            }
            if (choice.equals("0") && radio.equals("JSFwayCool")) {
                noCheck2 = "checked";
            }
            if (choice.equals("1") && radio.equals("moonCheese")) {
                yesCheck3 = "checked";
            }
            if (choice.equals("0") && radio.equals("moonCheese")) {
                noCheck3 = "checked";
            }
        }
        else
            System.out.println("No choice made");
    }
      
}
