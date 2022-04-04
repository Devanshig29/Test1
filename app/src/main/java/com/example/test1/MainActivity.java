package com.example.test1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Spinner courselist;
    TextView coursefees,coursehours,totalfees,totalhours;
    EditText extStudent;
    Button btnSelect;
    RadioButton rdbOne,rdbTwo;
    CheckBox chb1,chb2;
    ArrayList<Course> cList=new ArrayList<>();
    ArrayList<String> cTypes=new ArrayList<>();
    double originalFee;
    int originalHour;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fillData();
        findViewId();
        rdbOne.setOnClickListener(this);
        rdbTwo.setOnClickListener(this);
        btnSelect.setOnClickListener(this);
        if(rdbOne.isChecked())
        {
            coursehours.setText("21");
        }

        ArrayAdapter aa=new ArrayAdapter(this, R.layout.spinnerdes,cTypes);
        courselist.setAdapter(aa);
        courselist.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                coursefees.setText(String.valueOf(cList.get(i).getCoursefees()));
                originalFee=cList.get(i).getCoursefees();
                coursehours.setText(String.valueOf(cList.get(i).getCoursehours()));
                originalHour=cList.get(i).getCoursehours();

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    private void fillData(){
        cList.add(new Course("Java",1300,6));
        cList.add(new Course("Swift",1500,5));
        cList.add(new Course("iOS",1350,5));
        cList.add(new Course("Android",1400,7));
        cList.add(new Course("Database",1000,4));

        for(Course pz:cList)
            cTypes.add(pz.getCoursename());

    }

    private void findViewId() {
        courselist=findViewById(R.id.courselist);
        coursefees=findViewById(R.id.coursefees);
        coursehours=findViewById(R.id.coursehours);
        totalfees=findViewById(R.id.totalfees);
        totalhours=findViewById(R.id.totalhours);
        extStudent=findViewById(R.id.extStudent);
        btnSelect=findViewById(R.id.btnSelect);
        rdbOne=findViewById(R.id.rdbOne);
        rdbTwo=findViewById(R.id.rdbTwo);
        chb1=findViewById(R.id.chb1);
        chb2=findViewById(R.id.chb2);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.rdbOne:
                coursehours.setText("21");
                break;
            case R.id.rdbTwo:
                coursehours.setText("19");
                break;
            case R.id.btnSelect:
                int chval = 0;
                double Totalfees;
                double fees = Double.parseDouble(coursefees.getText().toString());

                        if (chb1.isChecked()) {
                            chval = 1500;
                        }

                        if (chb2.isChecked()) {
                            chval = 700;
                        }

                        Totalfees = fees + chval ;
                        totalfees.setText(String.valueOf(totalfees));
                        break;
                    }

                }



}




}