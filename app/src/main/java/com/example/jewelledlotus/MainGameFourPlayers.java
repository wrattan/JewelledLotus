package com.example.jewelledlotus;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ActionBar;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import java.util.Random;

public class MainGameFourPlayers extends AppCompatActivity {
    Button PlayerOnePlusButton;
    TextView PlayerOneLifeTotal;
    Button PlayerOneMinusButton;


    Button PlayerTwoPlusButton;
    TextView PlayerTwoLifeTotal;
    Button PlayerTwoMinusButton;

    Button PlayerThreePlusButton;
    TextView PlayerThreeLifeTotal;
    Button PlayerThreeMinusButton;

    Button PlayerFourPlusButton;
    TextView PlayerFourLifeTotal;
    Button PlayerFourMinusButton;

    Button Menu;
    Button ExitGame;
    Button ResetGame;
    Button ExitPopUp;


    Button Player4Calc;
    Button Player3Calc;
    Button Player2Calc;
    Button PlayerOneCalc;

    TextView CalcResult;

    Button ButtonOne, ButtonTwo,ButtonThree, ButtonFour, ButtonFive, ButtonSix, ButtonSeven,ButtonEight,
    ButtonNine,ButtonZero,ButtonAdd,ButtonSubtract,ButtonMultiply,ButtonDivide,ButtonSetLife,ButtonEnter,ButtonClear;

    Button ExitCalc;

    Button PlayerPicker;

    public boolean Addition =false;
    public boolean Subtraction =false;
    public boolean Multiplication =false;
    public boolean Division =false;
    public int Value1 = 0;
    public int Value2 = 0;

    public boolean PlayerOneClickedCalc =false;
    public boolean PlayerTwoClickedCalc =false;
    public boolean PlayerThreeClickedCalc =false;
    public boolean PlayerFourClickedCalc =false;


    public static int _counterPlayer1 = 40;
    public static int _counterPlayer2 = 40;
    public static int _counterPlayer3 = 40;
    public static int _counterPlayer4 = 40;

    public String _stringValPlayer1;
    public String _stringValPlayer2;
    public String _stringValPLayer3;
    public String _stringValPlayer4;

    private View DecorView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
//        requestWindowFeature(Window.FEATURE_NO_TITLE);
//        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
//               WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_main_game_four_players);

        this.getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_FULLSCREEN);

        Menu = findViewById(R.id.MenuButton);
        PlayerOneCalc = findViewById(R.id.CalcMenuPlayerOne);
        Player2Calc = findViewById(R.id.calcMenuPlayerTwo);
        Player3Calc = findViewById(R.id.calcMenuPlayerThree);
        Player4Calc = findViewById(R.id.calcMenuPlayerFour);

        PlayerOnePlusButton = findViewById(R.id.PlayerOnePlusButton);
        PlayerOneMinusButton = findViewById(R.id.PlayerOneMinusButton);
        PlayerOneLifeTotal = findViewById(R.id.PlayerOneLifeTotalXML);

        PlayerTwoPlusButton = findViewById(R.id.playerTwoPlusButton);
        PlayerTwoMinusButton = findViewById(R.id.playerTwoMinusButton);
        PlayerTwoLifeTotal = findViewById(R.id.PlayerTwoLifeTotal);

        PlayerThreePlusButton = findViewById(R.id.playerThreePlusButton);
        PlayerThreeMinusButton = findViewById(R.id.playerThreeMinusButton);
        PlayerThreeLifeTotal = findViewById(R.id.PlayerThreeLifeTotal);

        PlayerFourPlusButton = findViewById(R.id.playerFourPlusButton);
        PlayerFourMinusButton = findViewById(R.id.playerFourMinusButton);
        PlayerFourLifeTotal = findViewById(R.id.PlayerFourLifeTotal);


        PlayerOnePlusButton.setOnClickListener(view -> {
            _counterPlayer1++;
            _stringValPlayer1 = Integer.toString(_counterPlayer1);
            PlayerOneLifeTotal.setText(_stringValPlayer1);
        });

        PlayerOneMinusButton.setOnClickListener(view -> {
            _counterPlayer1--;
            _stringValPlayer1 = Integer.toString(_counterPlayer1);
            PlayerOneLifeTotal.setText(_stringValPlayer1);
        });

        PlayerTwoPlusButton.setOnClickListener(view -> {
            _counterPlayer2++;
            _stringValPlayer2 = Integer.toString(_counterPlayer2);
            PlayerTwoLifeTotal.setText(_stringValPlayer2);
        });

        PlayerTwoMinusButton.setOnClickListener(view -> {
            _counterPlayer2--;
            _stringValPlayer2 = Integer.toString(_counterPlayer2);
            PlayerTwoLifeTotal.setText(_stringValPlayer2);
        });

        PlayerThreePlusButton.setOnClickListener(view -> {
            _counterPlayer3++;
            _stringValPLayer3 = Integer.toString(_counterPlayer3);
            PlayerThreeLifeTotal.setText(_stringValPLayer3);
        });

        PlayerThreeMinusButton.setOnClickListener(view -> {
            _counterPlayer3--;
            _stringValPLayer3 = Integer.toString(_counterPlayer3);
            PlayerThreeLifeTotal.setText(_stringValPLayer3);
        });

        PlayerFourPlusButton.setOnClickListener(view -> {
            _counterPlayer4++;
            _stringValPlayer4 = Integer.toString(_counterPlayer4);
            PlayerFourLifeTotal.setText(_stringValPlayer4);
        });

        PlayerFourMinusButton.setOnClickListener(view -> {
            _counterPlayer4--;
            _stringValPlayer4 = Integer.toString(_counterPlayer4);
            PlayerFourLifeTotal.setText(_stringValPlayer4);
        });



    PlayerOneCalc.setOnClickListener(view -> {
        PlayerOneClickedCalc = true;
        calcPopUp(view);
    });
        Player2Calc.setOnClickListener(view -> {
            PlayerTwoClickedCalc = true;
            calcPopUp(view);
        });
        Player3Calc.setOnClickListener(view -> {
            PlayerThreeClickedCalc = true;
            calcPopUp(view);
        });

        Player4Calc.setOnClickListener(view -> {
            PlayerFourClickedCalc = true;
            calcPopUp(view);
        });



    Menu.setOnClickListener(view -> buttonMenuPopUp(view));

    }


    public void calcPopUp(View view){

        LayoutInflater layoutInflaterCalc = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
        View PopUpCalcView = layoutInflaterCalc.inflate(R.layout.in_game_calc_popup,null);
        final PopupWindow PopUpCalcWindow = new PopupWindow(PopUpCalcView, LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.MATCH_PARENT,true);

        PopUpCalcWindow.showAtLocation(view, Gravity.CENTER,0,0);

        CalcResult = PopUpCalcView.findViewById(R.id.TextResult);

        ButtonOne = PopUpCalcView.findViewById(R.id.ButtonOne);
        ButtonTwo = PopUpCalcView.findViewById(R.id.ButtonTwo);
        ButtonThree = PopUpCalcView.findViewById(R.id.ButtonThree);
        ButtonFour = PopUpCalcView.findViewById(R.id.ButtonFour);
        ButtonFive = PopUpCalcView.findViewById(R.id.ButtonFive);
        ButtonSix = PopUpCalcView.findViewById(R.id.ButtonSix);
        ButtonSeven = PopUpCalcView.findViewById(R.id.ButtonSeven);
        ButtonEight = PopUpCalcView.findViewById(R.id.ButtonEight);
        ButtonNine = PopUpCalcView.findViewById(R.id.ButtonNine);
        ButtonZero = PopUpCalcView.findViewById(R.id.ButtonZero);
        ButtonAdd = PopUpCalcView.findViewById(R.id.ButtonAdd);
        ButtonSubtract = PopUpCalcView.findViewById(R.id.ButtonSubract);
        ButtonMultiply = PopUpCalcView.findViewById(R.id.ButtonMultiply);
        ButtonDivide = PopUpCalcView.findViewById(R.id.ButtonDivide);
        ButtonClear =PopUpCalcView.findViewById(R.id.ButtonClear);
        ButtonEnter = PopUpCalcView.findViewById(R.id.EqualsButton);
        ButtonSetLife = PopUpCalcView.findViewById(R.id.SetLifeButton);

        ExitCalc = PopUpCalcView.findViewById(R.id.ExitCalculatorPopUp);

        ButtonOne.setOnClickListener(view1 -> CalcResult.setText(CalcResult.getText()+"1"));

        ButtonTwo.setOnClickListener(view113 -> CalcResult.setText(CalcResult.getText()+"2"));

        ButtonThree.setOnClickListener(view12 -> CalcResult.setText(CalcResult.getText()+"3"));

        ButtonFour.setOnClickListener(view13 -> CalcResult.setText(CalcResult.getText()+"4"));

        ButtonFive.setOnClickListener(view14 -> CalcResult.setText(CalcResult.getText()+"5"));

        ButtonSix.setOnClickListener(view15 -> CalcResult.setText(CalcResult.getText()+"6"));

        ButtonSeven.setOnClickListener(view16 -> CalcResult.setText(CalcResult.getText()+"7"));

        ButtonEight.setOnClickListener(view17 -> CalcResult.setText(CalcResult.getText()+"8"));

        ButtonNine.setOnClickListener(view18 -> CalcResult.setText(CalcResult.getText()+"9"));

        ButtonZero.setOnClickListener(view19 -> CalcResult.setText(CalcResult.getText()+"0"));

        ButtonClear.setOnClickListener(view110 -> CalcResult.setText(""));

        ButtonAdd.setOnClickListener(v -> {

            if (CalcResult == null) {
                CalcResult.setText("");
            } else {
                if (CalcResult.getText().toString().trim().length() > 0) {
                    Value1 = Integer.parseInt(CalcResult.getText() + "");
                    Addition = true;
                    CalcResult.setText(null);
                }
            }
        });

        ButtonSubtract.setOnClickListener(v -> {
            if (CalcResult.getText().toString().trim().length() > 0) {
                Value1 = Integer.parseInt(CalcResult.getText() + "");
                Subtraction = true;
                CalcResult.setText(null);
            }
        });

        ButtonMultiply.setOnClickListener(v -> {
            if (CalcResult.getText().toString().trim().length() > 0) {
                Value1 = Integer.parseInt(CalcResult.getText() + "");
                Multiplication = true;
                CalcResult.setText(null);
            }
        });

        ButtonDivide.setOnClickListener(v -> {
            if (CalcResult.getText().toString().trim().length() > 0) {
                Value1 = Integer.parseInt(CalcResult.getText() + "");
                Division = true;
                CalcResult.setText(null);
            }
        });

        ButtonEnter.setOnClickListener(v -> {
            if(CalcResult.getText()!="") {

                Value2 = Integer.parseInt(CalcResult.getText() + "");
                if (Addition) {
                    CalcResult.setText(Value1 + Value2 + "");
                    Addition = false;
                }
                if (Subtraction) {
                    CalcResult.setText(Value1 - Value2 + "");
                    Subtraction = false;
                }
                if (Multiplication) {
                    CalcResult.setText(Value1 * Value2 + "");
                    Multiplication = false;
                }
                if (Division) {
                    if(Value2 == 0){
                        CalcResult.setText("");
                        Division = false;
                    }else{
                        CalcResult.setText(Value1 / Value2 + "");
                        Division = false;
                    }
                }
            }else{
                CalcResult.setText("0");
            }
        });

        ButtonSetLife.setOnClickListener(view111 -> {
            if(PlayerOneClickedCalc && CalcResult.getText()!="" && !PlayerTwoClickedCalc && !PlayerThreeClickedCalc && !PlayerFourClickedCalc){
                _counterPlayer1 = Integer.parseInt((String) CalcResult.getText());
                _stringValPlayer1 = Integer.toString(_counterPlayer1);
                PlayerOneLifeTotal.setText(_stringValPlayer1);

            }
            if(PlayerTwoClickedCalc && CalcResult.getText()!=""&& !PlayerOneClickedCalc && !PlayerThreeClickedCalc && !PlayerFourClickedCalc){
                _counterPlayer2 = Integer.parseInt((String) CalcResult.getText());
                _stringValPlayer2 = Integer.toString(_counterPlayer2);
                PlayerTwoLifeTotal.setText(_stringValPlayer2);

            }
            if(PlayerThreeClickedCalc && CalcResult.getText()!=""&& !PlayerOneClickedCalc && !PlayerTwoClickedCalc && !PlayerFourClickedCalc){
                _counterPlayer3 = Integer.parseInt((String) CalcResult.getText());
                _stringValPLayer3 = Integer.toString(_counterPlayer3);
                PlayerThreeLifeTotal.setText(_stringValPLayer3);

            }
           if(PlayerFourClickedCalc && CalcResult.getText()!=""&& !PlayerOneClickedCalc && !PlayerThreeClickedCalc && !PlayerTwoClickedCalc){
                _counterPlayer4 = Integer.parseInt((String) CalcResult.getText());
                _stringValPlayer4 = Integer.toString(_counterPlayer4);
                PlayerFourLifeTotal.setText(_stringValPlayer4);

            }
        });

        ExitCalc.setOnClickListener(view112 -> {
            PlayerOneClickedCalc = false;
            PlayerTwoClickedCalc = false;
            PlayerThreeClickedCalc = false;
            PlayerFourClickedCalc = false;
            CalcResult.setText("");
            PopUpCalcWindow.dismiss();
        });

    }



    public void buttonMenuPopUp(View view){

        LayoutInflater layoutInflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
        View viewPopupwindow = layoutInflater.inflate(R.layout.in_game_menu_popup,null);
        final PopupWindow popupWindow = new PopupWindow(viewPopupwindow, LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.MATCH_PARENT,true);

        popupWindow.showAtLocation(view, Gravity.CENTER,0,0);

       // popupWindow.setTouchable(true);


        ExitGame = viewPopupwindow.findViewById(R.id.ExitGame);
        ExitPopUp = viewPopupwindow.findViewById(R.id.ExitPopUp);
        ResetGame = viewPopupwindow.findViewById(R.id.ResetGameButton);
        PlayerPicker = viewPopupwindow.findViewById(R.id.PlayerPicker);

        ExitPopUp.setOnClickListener(view1 -> popupWindow.dismiss());

        ExitGame.setOnClickListener(view12 -> {
            Intent intent = new Intent(MainGameFourPlayers.this, MainActivity.class);
            startActivity(intent);
            finish();
        });

        ResetGame.setOnClickListener(view13 -> {
            _counterPlayer1 = 40;
            _stringValPlayer1 = Integer.toString(_counterPlayer1);
            PlayerOneLifeTotal.setText(_stringValPlayer1);

            _counterPlayer2 = 40;
            _stringValPlayer2 = Integer.toString(_counterPlayer2);
            PlayerTwoLifeTotal.setText(_stringValPlayer2);

            _counterPlayer3 = 40;
            _stringValPLayer3 = Integer.toString(_counterPlayer3);
            PlayerThreeLifeTotal.setText(_stringValPLayer3);

            _counterPlayer4 = 40;
            _stringValPlayer4 = Integer.toString(_counterPlayer4);
            PlayerFourLifeTotal.setText(_stringValPlayer4);
        });


        PlayerPicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PlayerPicker();
                popupWindow.dismiss();
            }
        });


    }
    public void PlayerPicker(){
        Random rng = new Random();
        int NumberPicked = rng.nextInt(4);
        String message = "You Shouldn't see this";

        if(NumberPicked == 0){
            message = "Erebos was picked";
        }
        if(NumberPicked == 1){
            message = "Iroas was Picked";
        }
        if(NumberPicked == 2){
            message = "Heliod was Picked";
        }
        if(NumberPicked == 3){
            message = "Thassa was picked";
        }

        new AlertDialog.Builder(this).setMessage(message)
                .setTitle("Player Picked")
                .setCancelable(true)
                .setNeutralButton(android.R.string.ok,
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int whichButton){
                                dialog.dismiss();
                            }
                        })
                .show();
    }



}

