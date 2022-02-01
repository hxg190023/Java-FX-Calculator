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

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

/*
public class CS2336Asg6_HXG190023 extends Application
 */
public class CS2336Asg6_HXG190023 extends Application
{
    // Text fields for the first number and second number is created
    TextField firstNum = new TextField();
    TextField secondNum = new TextField();

    // A label is created for the result section
    Label result = new Label();

    // Used to clear the first number and second portions when the clear button is pressed
    boolean clear = true;

    /*
    This is the start method, and it performs the main operations of the calculator.
     */
    @Override // Override the start method in the Application class
    public void start(Stage primaryStage)
    {
        // Create a pane and set its properties
        GridPane pane = new GridPane();

        // Setting a background color
        pane.styleProperty().set("-fx-background-color: #879797");

        // Set center alignment
        pane.setAlignment(Pos.CENTER);
        pane.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
        pane.setHgap(5.5);

        // Set vGap to 3px
        pane.setVgap(3);

        // First number pane is created, and the text field is set to (1, 0)
        pane.setBorder(new Border(new BorderStroke(Color.ROYALBLUE,
                BorderStrokeStyle.DOTTED, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
        pane.add(new Label("First Number: "), 0, 0);
        pane.add(firstNum, 1, 0);

        // First number pane is created, and the text field is set to (1, 2)
        pane.add(new Label("Second Number: "), 0, 2);
        pane.add(secondNum, 1, 2);

        // Result pane is created, and the text field is set to (1, 4)
        pane.add(new Label("Result: "), 0, 4);
        pane.add(result, 1, 4);

        // The font of the answer/result is in Verdana
        result.setFont(Font.font("Verdana",
                FontWeight.BOLD, 20));

        // The addition button is created, and the button field will
        // be placed in (2, 0)
        Button additionButton = new Button("+");
        pane.add(additionButton, 2, 0);

        // The multiplication button is created, and the button field will
        // be placed in (3, 0)
        Button multiplyButton = new Button("x");
        pane.add(multiplyButton, 3, 0);

        // The division button is created, and the button field will
        // be placed in (2, 2)
        Button divideButton = new Button("÷");
        pane.add(divideButton, 2, 2);

        // The subtraction button is created, and the button field will
        // be placed in (2, 3)
        Button subtractButton = new Button("-");
        pane.add(subtractButton, 3, 2);

        // The clear button is created, and the button field will
        // be placed in (2, 3)
        Button clearButton = new Button("Clear");
        pane.add(clearButton, 2, 4);

        /*
        Each individual button is sent to the function, getButtonClicked,
        and is checked to see if that button is clicked.
        This handler function will check and send to the Calculator Class to do the correct
        calculation.
         */
        additionButton.setOnAction(e -> getButtonClicked("+"));
        multiplyButton.setOnAction(e -> getButtonClicked("x"));
        subtractButton.setOnAction(e -> getButtonClicked("-"));
        divideButton.setOnAction(e -> getButtonClicked("÷"));
        clearButton.setOnAction(e -> getButtonClicked("Clear"));

        // Create a scene and place it in the stage
        Scene scene = new Scene(pane);

        // Set the stage title
        primaryStage.setTitle("The Simple Calculator");

        // Place the scene in the stage
        primaryStage.setScene(scene);

        // Display the stage
        primaryStage.show();

    } // end of public void start(Stage primaryStage)

    /*
    This method will get the button that is clicked and will perform the
    correct operations by sending it to the controller class.
     */
    public void getButtonClicked(String input)
    {
        // Will be the string that is sent to the CalculatorController class
        String inputToControl;

        // Stores the result of the operation performed, initialized to 0, to begin with
        double resultOfAnswer = 0.0;

        // Will be used to determine if is a number or not
        boolean isNumber = false;

        // Will be used to determine if either the first number or
        // the second number is not a number
        boolean firstNumberTruth = false;
        boolean secondNumberTruth = false;

        // If the firstNum & secondNum is not null and the first character of both numbers
        // is not null.
        if (firstNum.getText().length() > 0 && secondNum.getText().length() > 0
                && firstNum.getText().charAt(0) != ' '
                && secondNum.getText().charAt(0) != ' ')
        {
            // Then it is a number, so set to true
            isNumber = true;

            /*
            The try-catch will check to see if a valid numeric value
            is being entered.
            If not, then the program will notify the user.
             */
            try {

                // Checking if both the values are able to parse as double values
                Double firstNumberDouble = Double.parseDouble(firstNum.getText());
                Double secondNumberDouble = Double.parseDouble(secondNum.getText());

            }
            // If not, then the exception is caused
            catch (NumberFormatException ex)
            {
                // The Alert is created to inform the user that they have entered a non-numeric value
                Alert errorAlert = new Alert(Alert.AlertType.ERROR);

                // Will let the user know of the error, and wait until they press the Ok button
                errorAlert.setHeaderText("Non-Numeric Value Error!");
                errorAlert.setContentText("Please enter only numeric values in the first and second" +
                        " number text fields.\n" +
                        "\nTo return back to the calculator, press the OK button.");
                errorAlert.showAndWait();

                // Not a number, so set to false
                isNumber = false;

                // The truth values is set to true for both
                firstNumberTruth = true;
                secondNumberTruth = true;
            }

            // Will be used to clear the input fields
            if (isNumber == false)
            {
                // The two input fields are cleared
                firstNum.clear();
                secondNum.clear();

                // The result label is cleared
                result.equals(0.0);

                // Since it is to be cleared, it is set to true
                clear = true;
            }

            // Once valid values are entered into the text fields
            if (firstNumberTruth == false && secondNumberTruth == false)
            {
                // The first number is stored after gotten from the text field
                double firstNumber = Double.parseDouble(firstNum.getText());

                // The second number is stored after gotten from the text field
                double secondNumber = Double.parseDouble(secondNum.getText());

                // The first number and the second number is sent to the CalculatorController
                // constructor.
                CalculatorController handler = new CalculatorController(firstNumber, secondNumber);

                // If the addition button is clicked
                if (input.equalsIgnoreCase("+"))
                {
                    // Will send the addition sign to calculateResult
                    inputToControl = "+";

                    // Will store the answer of the addition of the two numbers
                    resultOfAnswer = handler.calculateResult(inputToControl);

                    // set to false
                    clear = false;
                }
                // If the subtraction button is clicked
                else if (input.equalsIgnoreCase("-"))
                {
                    // Will send the subtraction sign to calculateResult
                    inputToControl = "-";

                    // Will store the answer of the subtraction of the two numbers
                    resultOfAnswer = handler.calculateResult(inputToControl);

                    // set to false
                    clear = false;
                }
                // If the multiplication button is clicked
                else if (input.equalsIgnoreCase("x"))
                {
                    // Will send the multiplication sign to calculateResult
                    inputToControl = "x";

                    // Will store the answer of the multiplication of the two numbers
                    resultOfAnswer = handler.calculateResult(inputToControl);

                    // set to false
                    clear = false;
                }
                // If the division button is clicked
                else if (input.equalsIgnoreCase("÷"))
                {
                    // Will send the division sign to calculateResult
                    inputToControl = "÷";

                    // Will store the answer of the division of the two numbers
                    resultOfAnswer = handler.calculateResult(inputToControl);

                    // set to false
                    clear = false;
                }
            }

            // If the clear button is clicked, then the
            // two input fields, and the result label is cleared.
            if (input.equalsIgnoreCase("Clear") ) // && !clear
            {
                // The two input fields are cleared
                firstNum.clear();
                secondNum.clear();

                // The result label is cleared
                result.equals(0.0);

                // Since it is to be cleared, it is set to true
                clear = true;
            }

            // Will write the result to the result label
            result.setText(String.valueOf(resultOfAnswer));

        }

    } // end of public void getButtonClicked(String input)

    /*
    This is the main method, that launches the program.
    It is not needed to be included in this program to run correctly, but is still
    included.
     */
    public static void main(String[] args)
    {
        launch(args);
    } // end of public static void main(String[] args)

} // end of public class CS2336Asg6_HXG190023 extends Application
