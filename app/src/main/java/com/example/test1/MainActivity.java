package com.example.test1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
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
    TextView coursefees,coursehours,totalfees,totalhours,lab;
    EditText extStudent;
    Button btnSelect;
    RadioButton rdbOne,rdbTwo;
    CheckBox chb1,chb2;
    ArrayList<Course> cList=new ArrayList<>();
    ArrayList<String> cTypes=new ArrayList<>();
    double tmptotfee=0,tmptothr=0,tohours=0,tofees=0,chours;
    double chb1_val=0,chb2_val=0;
    String flg="";
    ArrayList<Course>tmpList=new ArrayList<>();
    ArrayList<String>tmpNames=new ArrayList<>();

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
            flg="graduated";
        }
        ArrayAdapter aa=new ArrayAdapter(this, R.layout.spinnerdes,cTypes);
        courselist.setAdapter(aa);
        courselist.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {


                coursehours.setText(String.valueOf(cList.get(i).getCoursehours()));
                coursefees.setText(String.valueOf(cList.get(i).getCoursefees()));
                tmptothr+=cList.get(i).getCoursehours();
                tmptotfee+=cList.get(i).getCoursefees();
                if (flg.equals("graduated")) {
                    if (tmptothr > 21) {
                        Log.d("test","dddd"+tmptothr);
                    }
                    else
                    {
                        tohours+=cList.get(i).getCoursehours();
                        tofees+=cList.get(i).getCoursefees();
                    }
                } else if (flg.equals("ungraduated")) {
                    if (tmptothr <= 19) {
                        tohours+=cList.get(i).getCoursehours();
                        tofees+=cList.get(i).getCoursefees();
                    }
                } else {
                    chours = 0;
                    tohours=0;
                    tofees=0;
                }

                if(flg.equals("graduated") && tmptothr>21){
                    lab.setText("Maximum Hours");
                }
                else if(flg.equals("ungraduated") && tmptothr>19){
                    lab.setText("Maximum Hours");
                }
                else
                {
                    lab.setText("");
                }

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
        lab=findViewById(R.id.lab);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.rdbOne:
                chours=21;
                flg="graduated";
                break;
            case R.id.rdbTwo:
                chours=19;
                flg="ungraduated";
                break;
            case R.id.btnSelect:
                for(Course prd:cList) {
                    if (flg.equals("graduated")) {
                        if (tohours <= 21) {
                            tmpList.add(prd);
                            tmpNames.add(prd.getCoursename());
                        }
                    }
                    else if (flg.equals("ungraduated")) {
                        if (tohours <= 19) {
                            tmpList.add(prd);
                            tmpNames.add(prd.getCoursename());
                        }
                    }
                    else {
                        chours = 0;
                    }

                }
                if (chb1.isChecked()) {
                    chb1_val = 1000;
                }
                else
                {
                    chb1_val = 0;
                }
                if (chb2.isChecked()) {
                    chb2_val = 700;
                }
                else
                {
                    chb2_val = 0;
                }
                totalhours.setText(String.valueOf(tmptothr));
                totalfees.setText(String.valueOf(tmptotfee+chb1_val+chb2_val));
                break;
        }
                }



}




