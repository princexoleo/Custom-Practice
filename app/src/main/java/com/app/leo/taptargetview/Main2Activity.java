package com.app.leo.taptargetview;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.provider.MediaStore;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.ContextThemeWrapper;
import android.view.View;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.text.DateFormat;
import java.util.Calendar;

public class Main2Activity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {

    TextView welcomeText,dateTextView,progTV;
    static TextView timeTV;
    RadioButton radioButtonFood;
    CheckBox checkBoxDhaka, checkBoxMymen;
    RadioGroup radioGroup;
    Spinner sp;
    AutoCompleteTextView autocomtv;
    RatingBar ratBar;
    SeekBar skBar;
    ProgressBar progBar;
    Button datePicbtn,nextbtn,cardViewbtn,dataActivitybtn;
    Button timebtn,timerActvitybtn, webviewbtn;
    String []teams={"Brazil","Argentina","France","Japan","England","Russia"};
    String []playerName={"neymar","Neymar","messi","ronaldo","leo","kane","google"};
    ArrayAdapter<String>adapter,autocomtvAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        init();
        checkBoxDhaka.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                {
                    Toast.makeText(Main2Activity.this, "Dhaka checked", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(Main2Activity.this, "Dhaka unchecked", Toast.LENGTH_SHORT).show();
                }
            }
        });

        checkBoxMymen.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                {
                    Toast.makeText(Main2Activity.this, "Mymensingh checked", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(Main2Activity.this, "Mymensingh unchecked", Toast.LENGTH_SHORT).show();
                }
            }
        });

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton rb=findViewById(checkedId);
                Toast.makeText(Main2Activity.this, " "+rb.getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });


        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        String text=parent.getItemAtPosition(position).toString();
                        Toast.makeText(Main2Activity.this, " "+text+" selected", Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        //Rating Bar ....
        ratBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                Toast.makeText(Main2Activity.this, ""+String.valueOf(rating), Toast.LENGTH_SHORT).show();
            }
        });

        //seek Bar .....
        skBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                //Toast.makeText(Main2Activity.this, ""+String.valueOf(progress), Toast.LENGTH_SHORT).show();
                progBar.setProgress(progress);
                progTV.setText(""+progress+"%");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        //Date Picker Button method is here . . ..

        datePicbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                android.support.v4.app.DialogFragment datePicker=new DatePickerFragment();
                datePicker.show(getSupportFragmentManager(),"date picker");


            }
        });

        //time pickter button working here...

        timebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment fragment=new TimeSelect();
                fragment.show(getFragmentManager(),"Select Time");

            }
        });
        //Go to next Activity
        nextbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Main2Activity.this,Main3Activity.class);
                startActivity(intent);
               // finish(); this activity will be finish thats mean when i goback from MainAcitvity 3 then it ill not happen
            }
        });

        //Go to CarView Activity...
        cardViewbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent=new Intent(Main2Activity.this,CardViewActivity.class);
//                startActivity(intent);
            }
        });

        //Go to Timer Activity Button
        timerActvitybtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Main2Activity.this,TimerActivity.class);
                startActivity(intent);
            }
        });

        //Goto DataBase Related Activity
        dataActivitybtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Main2Activity.this,DatabaseActivity.class);
                startActivity(intent);
            }
        });
        //Got to webView Activity
        webviewbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Main2Activity.this,WebViewActivity.class);
                startActivity(intent);
            }
        });








    }
     //initilizer method
    private void init() {
        checkBoxDhaka = findViewById(R.id.dhakaCheckBox);
        checkBoxMymen = findViewById(R.id.mymenCheckBox);
        radioGroup=findViewById(R.id.radiogp);
        sp=findViewById(R.id.sp);
        adapter=new ArrayAdapter<>(
                this,android.R.layout.simple_spinner_item,teams);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp.setAdapter(adapter);

        autocomtv=findViewById(R.id.autoCompleteTextView);
        autocomtvAdapter=new ArrayAdapter<>(Main2Activity.this,android.R.layout.simple_dropdown_item_1line,playerName);
        autocomtv.setThreshold(1);
        autocomtv.setAdapter(autocomtvAdapter);

        ratBar=findViewById(R.id.ratingBar);
        skBar=findViewById(R.id.seekBar);
        dateTextView=findViewById(R.id.datetextView);
        datePicbtn=findViewById(R.id.datePickerButton);
       timeTV=findViewById(R.id.timetextView);
        timebtn=findViewById(R.id.timePickerButton);
        progBar=findViewById(R.id.progressBar);
        progTV=findViewById(R.id.progressTV);
        nextbtn=findViewById(R.id.nextActivity);
        cardViewbtn=findViewById(R.id.nextCardViewActivity);
        timerActvitybtn=findViewById(R.id.timerBtn);
        dataActivitybtn=findViewById(R.id.dataActivitybtn);
        webviewbtn=findViewById(R.id.web_view_button_id);


    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        Calendar c=Calendar.getInstance();
        c.set(Calendar.YEAR,year);
        c.set(Calendar.MONTH,month);
        c.set(Calendar.DAY_OF_MONTH,dayOfMonth);

        String currentDateString= DateFormat.getDateInstance(DateFormat.FULL).format(c.getTime());
        dateTextView.setText(currentDateString);
    }

    //For time picker we create a static class

   public  static  class TimeSelect extends DialogFragment implements TimePickerDialog.OnTimeSetListener{

       @Override
       public Dialog onCreateDialog(Bundle savedInstanceState) {

           Calendar c=Calendar.getInstance();
           int hour=c.get(Calendar.HOUR);
           int minute=c.get(Calendar.MINUTE);

           return new TimePickerDialog(getActivity(),this,hour,minute,android.text.format.DateFormat.is24HourFormat(getActivity()));
       }

       @Override
       public void onTimeSet(TimePicker view, int hourOfDay, int minute) {

           timeTV.setText("Hours: "+hourOfDay+" Minutes: "+minute);

       }
   }

//checkBox another way method
//    public void checkBoxClicked(View view) {
//        boolean checked = ((CheckBox) view).isChecked();
//
//
//        switch (view.getId())
//        {
//            case R.id.dhakaCheckBox:
//                if(checked)
//                {
//                    Toast.makeText(this, "Your Location Dhaka is Selected !", Toast.LENGTH_SHORT).show();
//
//                }
//
//
//            case R.id.mymenCheckBox:
//                if(checked)
//                {
//                    Toast.makeText(this, "Your Location Mymensingh is Selected !", Toast.LENGTH_SHORT).show();
//
//                }
//        }
//    }
//RadioGroupButton another way...

//    public void radioButtonClicked(View view) {
//        boolean checked = ((RadioButton) view).isChecked();
//        switch(view.getId()) {
//            case R.id.faluRad:
//                if (checked)
//                    Toast.makeText(this, "Faluda !!", Toast.LENGTH_SHORT).show();
//                    break;
//            case R.id.rosRad:
//                if (checked)
//                    Toast.makeText(this, "Roso Moloay !!", Toast.LENGTH_SHORT).show();
//                    break;
//            case R.id.manRad:
//                if (checked){
//                    Toast.makeText(this, "Mango Juice ", Toast.LENGTH_SHORT).show();
//                }
//        }
//
//    }
}