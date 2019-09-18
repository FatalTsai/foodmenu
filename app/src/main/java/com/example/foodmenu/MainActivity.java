package com.example.foodmenu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TextView;

import java.util.ArrayList;

public  class MainActivity extends AppCompatActivity
        implements OnCheckedChangeListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        int [] chk_id ={R.id.hamburger,R.id.fries,R.id.Coke,R.id.soup,R.id.chicken,R.id.salad};

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        for(int id:chk_id){
            CheckBox chk =(CheckBox) findViewById(id);
            chk.setOnCheckedChangeListener(this);
        }
    }




    ArrayList<CompoundButton> selected =new ArrayList<>();


    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if(isChecked)
            selected.add(buttonView);
        else
            selected.remove(buttonView);
    }


    public void order(View v){

        String msg ="";
        for(CompoundButton chk :selected){
            msg += "\n"+chk.getText();

        }

        ((TextView)findViewById(R.id.textView)).setText(msg);

    }
}
