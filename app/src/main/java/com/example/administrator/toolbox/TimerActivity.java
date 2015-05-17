package com.example.administrator.toolbox;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.administrator.toolbox.R;

public class TimerActivity extends ActionBarActivity {

    private Button btnR,btnT;
    private Long startTime;
    private Handler handler = new Handler();
    private int state;
    private TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer);
        btnR=(Button)findViewById(R.id.btnReturn);
        btnT=(Button)findViewById(R.id.btn);
        tv=(TextView)findViewById(R.id.tvTime);
        btnR.setOnClickListener(btnReturnOCL);
        state=0;
        btnT.setText(R.string.TimeBtnInitial);
        btnT.setOnClickListener(btnTimeOCL);

    }
    private View.OnClickListener btnTimeOCL=new View.OnClickListener(){
        @Override
        public void onClick(View v){
            switch(state)
            {
                case 0:
                    startTime=System.currentTimeMillis();
                    handler.removeCallbacks(updateTimer);
                    handler.post(updateTimer);
                    btnT.setText(R.string.TimeBtnStop);
                    state=1;
                    break;
                case 1:
                    handler.removeCallbacks(updateTimer);
                    btnT.setText(R.string.TimeBtnClear);
                    state=2;
                    break;
                case 2:
                    tv.setText("00:00");
                    btnT.setText(R.string.TimeBtnInitial);
                    state=0;
                    break;
                default:
                    break;
            }
        }
    };

    private Runnable updateTimer = new Runnable() {
        public void run() {

            Long spentTime = System.currentTimeMillis() - startTime;
            Long minius = (spentTime/1000)/60;
            Long seconds = (spentTime/1000) % 60;
            tv.setText(minius + ":" + seconds);
            handler.postDelayed(this, 1000);
        }
    };
    private View.OnClickListener btnReturnOCL=new View.OnClickListener(){
        @Override
        public void onClick(View v){
            Intent itReturn=new Intent();
            itReturn.setClass(TimerActivity.this,MenuActivity.class);
            startActivity(itReturn);
        }
    };



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_timer, menu);
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
