package portos.app.portosapplication;

import androidx.appcompat.app.AppCompatActivity;
import  org.mariuszgromada.math.mxparser.*;
import android.os.Build;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText display;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        display = findViewById(R.id.input);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            display.setShowSoftInputOnFocus(false);
        }

        display.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (getString(R.string.display).equals(display.getText().toString()))
                    display.setText("");
            }
        });
    }

    private void updateText(String strToAdd) {
        String oldstring = display.getText().toString();
        int cursorPos = display.getSelectionStart();
        String LeftStr = oldstring.substring(0, cursorPos);
        String rightStr = oldstring.substring(cursorPos);
        if (getString(R.string.display).equals(display.getText().toString())){
            display.setText(strToAdd);
            display.setSelection(cursorPos + 1);
        }
        else {
            display.setText(String.format("%s%s%s", LeftStr, strToAdd, rightStr));
            display.setSelection(cursorPos + 1);
        }
    }

    public void zeroBTN (View view) {
        updateText("0");
    }

    public void oneBTN (View view) {
        updateText("1");
    }
    public void twoBTN (View view) {
        updateText("2");
    }
    public void threeBTN (View view) {
        updateText("3");
    }
    public void fourBTN (View view) {
        updateText("4");
    }
    public void fiveBTN (View view) {
        updateText("5");
    }
    public void sixBTN (View view) {
        updateText("6");
    }
    public void sevenBTN (View view) {
        updateText("7");
    }
    public void eightBTN (View view) {
        updateText("8");
    }
    public void nineBTN (View view) {
        updateText("9");
    }
    public void clearBTN (View view) {
        display.setText("");
    }
    public void parenthesisBTN (View view) {
        int cursorPos = display.getSelectionStart();
        int openPar = 0;
        int closedPar = 0;
        int textLen = display.getText().length();

        for (int i = 0; i < cursorPos; i++){
            if (display.getText().toString().substring(i, i+1).equals("(")){
                openPar += 1;
            }if (display.getText().toString().substring(i, i+1).equals(")")){
                closedPar += 1;
            }
        }

        if (openPar == closedPar || display.getText().toString().substring(textLen-1,textLen).equals("(")){
            updateText("(");
        }
        else if (closedPar < openPar && !display.getText().toString().substring(textLen-1,textLen).equals(")")){
            updateText(")");
        }
        display.setSelection(cursorPos + 1);
    }
    public void exponentBTN (View view) {
        updateText("^");
    }
    public void divideBTN (View view) {
        updateText("÷");
    }
    public void multiplyBTN (View view) {
        updateText("×");
    }
    public void subtractBTN (View view) {
        updateText("-");
    }
    public void plusBTN (View view) {
        updateText("+");
    }
    public void plusMinusBTN (View view) {
        updateText("-");
    }
    public void pointBTN (View view) {
        updateText(".");
    }
    public void equalsBTN (View view) {
        String userExp = display.getText().toString();

        userExp = userExp.replaceAll("÷", "/");
        userExp = userExp.replaceAll("×", "*");

        Expression exp = new Expression(userExp);

        String result = String.valueOf(exp.calculate());

        display.setText(result);
        display.setSelection(result.length());
    }

        }



