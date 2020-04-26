package vn.edu.nbd.nguyenbaoduy_59130423_simplewidget;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity<text> extends AppCompatActivity
{
    EditText editTextTEN, editTextNGAYSINH, editTextSOTHICH;
    RadioGroup radiogrGIOITINH, radiogrSOTHICH;
    Button buttonXACNHAN;
    CheckBox checkBoxST1, checkBoxST2, checkBoxST3, checkBoxST4, checkBoxST5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addViews();
        addEvent();
    }

    private void addViews()
    {
        editTextTEN= findViewById(R.id.editTextTEN);
        editTextNGAYSINH=findViewById(R.id.editTextNGAYSINH);
        editTextSOTHICH=findViewById(R.id.edittextSOTHICH);
        radiogrGIOITINH=findViewById(R.id.radiogrGIOITINH);
        checkBoxST1=findViewById(R.id.checkBoxST1);
        checkBoxST2= findViewById(R.id.checkBoxST2);
        checkBoxST3=findViewById(R.id.checkBoxST3);
        checkBoxST4=findViewById(R.id.checkBoxST4);
        checkBoxST5 = findViewById(R.id.checkBoxST5);
        buttonXACNHAN=findViewById(R.id.buttonXACNHAN);

    }
    private void addEvent()
    {
        buttonXACNHAN.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String Name = getName();
                String Date = getDate();
                String Sex = getSex();
                String soThich="";
                if(checkBoxST1.isChecked())
                {
                    soThich += checkBoxST1.getText() + " ; ";
                }
                if(checkBoxST2.isChecked()){
                    soThich += checkBoxST2.getText()+" ; ";
                }
                if(checkBoxST3.isChecked()){
                    soThich += checkBoxST3.getText()+" ; ";
                }
                if (checkBoxST4.isChecked()){
                    soThich += checkBoxST4.getText()+" ; ";
                }
                if (checkBoxST5.isChecked()){
                    soThich += checkBoxST5.getText()+" ; ";
                }
                soThich += editTextSOTHICH.getText();

                String ToDisplay = Name+ "\nNgày sinh: " + Date + "\nGiới tính: " + Sex + "\nSở thích: " + soThich;
                Toast.makeText(getApplicationContext(), ToDisplay, Toast.LENGTH_SHORT).show();
            }

            private String getSex() {
                int selectedBtn = radiogrGIOITINH.getCheckedRadioButtonId();
                return ((Button) findViewById(selectedBtn)).getText().toString();
            }

            private String getDate() {
                String s = editTextNGAYSINH.getText().toString();
                if (s.matches(""))
                    s = "Bạn chưa nhập Ngày Sinh";
                return s;
            }

            private String getName() {
                String s = editTextTEN.getText().toString();
                if (s.matches(""))
                    s = "Bạn chưa nhập Tên";
                return s;
            }
        });
    }
}
