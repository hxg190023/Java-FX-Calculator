/*
Name & NET-ID:      Harsh Gopalan - HXG190023
Class & Section:    CS 2336. 005
Assignment:         Assignment 6 - Simple Calculator using JavaFX
Start / End Date:   11/17/2021 - 12/03/2021
Purpose:            Writing this program for this class to complete Assignment 6.

General Description of Program:

    This program uses Java FX to create a simple calculator. The calculator will perform
    basic operation such as, addition, subtraction, multiplication and division using buttons.
    The calculator will make sure that the user is notified of a divide by zero error, and
    will not allow non-numeric values to be entered to the calculator, and will not allow a
    crash due to this either. The program also has a clear button that will clear the input fields
    and reset the result label to 0.
    Overall, the program makes use of two text fields for the input values, five buttons for the four
    operations and the clear option, and a result label that will display the result.

 */

package com.example.cs2336asg6_hxg190023;

import javafx.scene.control.Alert;

/*
public class CalculatorController
 */
public class CalculatorController
{
    // Will store the first number, second number from the main class
    // and will the result from this class, which will be sent back to main.
    double firstNumber, secondNumber, result;

    // The only constructor in the class.
    // Will create the first number and the second number for this class using this.
    CalculatorController (double firstNumber, double secondNumber)
    {
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
    }

    /*
    This method will calculate the result based on the correct operation
    that should be performed.
     */
    public double calculateResult(String inputToControl)
    {
        // The switch case to check which operation to perform
        switch (inputToControl)
        {
            // If plus sign
            case "+":
                result = firstNumber + secondNumber;
                break;
            // If subtraction sign
            case "-":
                result = firstNumber - secondNumber;
                break;
            // If multiplication sign
            case "x":
                result = firstNumber * secondNumber;
                break;
            // If division sign
            case "÷":
                // If the second number is 0, then it will not perform the operation
                if (secondNumber != 0)
                {
                    result = firstNumber / secondNumber;
                }
                // Will come here when the second number is 0
                else
                {
                    // The Alert is created to inform the user that they have entered a non-numeric value
                    Alert errorAlert = new Alert(Alert.AlertType.ERROR);

                    // Will let the user know of the error, and wait until they press the Ok button
                    errorAlert.setHeaderText("Divide By Zero Error!");
                    errorAlert.setContentText("The second number/denominator cannot be zero when doing" +
                            "the divide operation.\n" +
                            "\nPlease try again.\n" +
                            "\nTo return back, press the OK button.");
                    errorAlert.showAndWait();
                }
                break;
        }

        // Will return the result to the respective call
        return result;

    } // end of  public double calculateResult(String inputToControl)

} // end of public class CalculatorController