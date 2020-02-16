package com.ppal007.datetolong_longtodate;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;

import com.ppal007.datetolong_longtodate.databinding.ActivityMainBinding;

import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(MainActivity.this, R.layout.activity_main);

//        convert date to long
        binding.dateToLongBT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                convertDateToLong();
            }
        });

//        convert long to date
        binding.longToDateBT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                convertLongToDate();
            }
        });


    }

    private void convertDateToLong() {

//        get current date
        String currentDate = new SimpleDateFormat("dd-MMM-yyyy", Locale.getDefault()).format(new Date());

        @SuppressLint("SimpleDateFormat") SimpleDateFormat format = new SimpleDateFormat("dd-MMM-yyyy");
        try {

            Date date = format.parse(currentDate);
            assert date != null;
            long milliseconds = date.getTime();
            String strLong = Long.toString(milliseconds);
//            set long to tvLong
            binding.tvLong.setText(strLong);

        } catch (ParseException e) {
            e.printStackTrace();
        }

    }

    private void convertLongToDate() {

//        get long value from tvLong
        String longValue = binding.tvLong.getText().toString();

        long millisecond = Long.parseLong(longValue);
        Date date = new Date(millisecond);

        @SuppressLint("SimpleDateFormat") Format formatter = new SimpleDateFormat("dd-MMM-yyyy");
        String strDate = formatter.format(date);

//        set date to tvDate
        binding.tvDate.setText(strDate);

    }
}
