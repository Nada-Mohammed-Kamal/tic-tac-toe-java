package CursorHANDWhenMoveToIntoButton;


import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Esraa
 */
public class CursorHANDWhenMoveToIntoButton {
    static public void getCurserOnbutton(Button b,Stage stage)
    {
        b.setOnMouseEntered((event) -> {
            stage.getScene().setCursor(Cursor.HAND);
        });
        b.setOnMouseExited((event) -> {
            stage.getScene().setCursor(Cursor.DEFAULT);
        }); 
    }
}
