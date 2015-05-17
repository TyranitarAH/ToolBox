package com.example.administrator.toolbox;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.*;

public class MenuActivity extends ActionBarActivity {

    private Button btnCalculater,btnConversion,btnImageExplore,btnTimer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        btnCalculater=(Button)findViewById(R.id.btnCalculater);
        btnConversion=(Button)findViewById(R.id.btnConversion);
        btnImageExplore=(Button)findViewById(R.id.btnImageExplore);
        btnTimer=(Button)findViewById(R.id.btnTimer);

        btnCalculater.setOnClickListener(btnCalOnClickListener);
        btnConversion.setOnClickListener(btnConversionOnClickListener);
        btnImageExplore.setOnClickListener(btnImageExploreOnClickListenr);
        btnTimer.setOnClickListener(btnTimerOnClickListener);
    }

    private View.OnClickListener btnImageExploreOnClickListenr=new View.OnClickListener(){
        @Override
        public void onClick(View v){
            Intent itMenu2ImgE=new Intent();
            itMenu2ImgE.setClass(MenuActivity.this,ImageActivity.class);
            startActivity(itMenu2ImgE);
        }
    };


    private View.OnClickListener btnConversionOnClickListener=new View.OnClickListener(){
        @Override
        public void onClick(View v){
            Intent itMenu2Con=new Intent();
            itMenu2Con.setClass(MenuActivity.this,ConversionActivity.class);
            startActivity(itMenu2Con);
        }
    };

    private View.OnClickListener btnCalOnClickListener=new View.OnClickListener(){
        @Override
        public void onClick(View v){
            Intent itMenu2Cal=new Intent();
            itMenu2Cal.setClass(MenuActivity.this,CalculaterActivity.class);
            startActivity(itMenu2Cal);
        }
    };

    private View.OnClickListener btnTimerOnClickListener=new View.OnClickListener(){
        @Override
        public void onClick(View v){
            Intent itMenu2Timer=new Intent();
            itMenu2Timer.setClass(MenuActivity.this,TimerActivity.class);
            startActivity(itMenu2Timer);
        }
    };
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
