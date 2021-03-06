package hu.progtech.bead;

import org.junit.jupiter.api.Test;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class RegisterFormTest {

    @Test
    void visszaNameEmpty() {
        RegisterForm.getInstance().buttonVissza.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = RegisterForm.getInstance().textFieldName.getText();
                assertEquals(name, null);
            }
        });
    }

    @Test
    void passSame(){
        RegisterForm.getInstance().buttonRegister.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String pass = "test";
                String passAgain = "test";
                passAgain = String.valueOf(RegisterForm.getInstance().passwordFieldPassAgain);

                assertEquals(pass, String.valueOf(RegisterForm.getInstance().passwordFieldPassAgain));
            }
        });
    }

    @Test
    void name_Pass_NotEmpty(){
        RegisterForm.getInstance().buttonRegister.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = RegisterForm.getInstance().textFieldName.getText();
                String pass = String.valueOf(RegisterForm.getInstance().passwordFieldPass);

                assertNotNull(name);
                assertNotNull(pass);
            }
        });
    }

    @Test
    void insertUser(){
        RegisterForm.getInstance().buttonRegister.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = "test";
                String pass = "test";
                try {
                    IDandPasswords.insertUser(name, pass);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
    }
}