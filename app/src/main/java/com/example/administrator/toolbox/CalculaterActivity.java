package com.example.administrator.toolbox;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.*;



public class CalculaterActivity extends ActionBarActivity {
    private Button btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btn0,btnP,btnM,btnMult,btnD,btnClear,btnEqual,btnReturn,btnSend;
    private EditText edtInput,edtAnswer;
    private String inputString1,inputString2,outputString,bufString;
    private int number1,number2,numberOutput;
    private int state,symbol,count;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculater);
        btn1=(Button)findViewById(R.id.buttonOne);
        btn2=(Button)findViewById(R.id.buttonTwo);
        btn3=(Button)findViewById(R.id.buttonThree);
        btn4=(Button)findViewById(R.id.buttonFour);
        btn5=(Button)findViewById(R.id.buttonFive);
        btn6=(Button)findViewById(R.id.buttonSix);
        btn7=(Button)findViewById(R.id.buttonSeven);
        btn8=(Button)findViewById(R.id.buttonEight);
        btn9=(Button)findViewById(R.id.buttonNine);
        btn0=(Button)findViewById(R.id.buttonZero);
        btnP=(Button)findViewById(R.id.buttonP);
        btnM=(Button)findViewById(R.id.buttonM);
        btnMult=(Button)findViewById(R.id.buttonMult);
        btnD=(Button)findViewById(R.id.buttonD);
        btnClear=(Button)findViewById(R.id.buttonClear);
        btnEqual=(Button)findViewById(R.id.buttonEqual);
        btnReturn=(Button)findViewById(R.id.btnReturn);
        edtInput=(EditText)findViewById(R.id.inputTextField);
        edtAnswer=(EditText)findViewById(R.id.answerTextField);
        btnSend=(Button)findViewById(R.id.btnSend);
        number1=0;
        number2=0;
        numberOutput=0;
        inputString1="";
        inputString2="";
        bufString="";
        outputString="";
        state=0;//0 for the first number, 1 for the second number
        symbol=0;//1 to +, 2 to -, 3 to *, 4 to / ,0 to initial
        count=0;
        btn1.setOnClickListener(btn1OnClick);
        btn2.setOnClickListener(btn2OnClick);
        btn3.setOnClickListener(btn3OnClick);
        btn4.setOnClickListener(btn4OnClick);
        btn5.setOnClickListener(btn5OnClick);
        btn6.setOnClickListener(btn6OnClick);
        btn7.setOnClickListener(btn7OnClick);
        btn8.setOnClickListener(btn8OnClick);
        btn9.setOnClickListener(btn9OnClick);
        btn0.setOnClickListener(btnZOnClick);
        btnP.setOnClickListener(btnPOnClick);
        btnM.setOnClickListener(btnMOnClick);
        btnMult.setOnClickListener(btnMultOnClick);
        btnD.setOnClickListener(btnDOnClick);
        btnEqual.setOnClickListener(btnEOnClick);
        btnClear.setOnClickListener(btnCOnClick);
        btnReturn.setOnClickListener(btnReturnOnClick);
        btnSend.setOnClickListener(btnSendOnClick);
        edtAnswer.setText("0");
    }

    private View.OnClickListener btnSendOnClick=new View.OnClickListener(){
        @Override
        public void onClick(View v){
            Double send ;
            Intent itSend=new Intent();
            itSend.setClass(CalculaterActivity.this, ConversionActivity.class);
            if(edtAnswer.getText().toString().equals(getString(R.string.canNotBeZero).toString())==true ){//make sure the result now is not infinite
                send=0.0;//if the result is infinite,then it will send 0 if the btn is clicked
            }else{
                send = Double.parseDouble(edtAnswer.getText().toString());//if the reuslt is good, then change it into double and send it
            }
            itSend.putExtra("Send_Data", send);//put the double into intent
            startActivity(itSend);

        }
    };

   private View.OnClickListener btnReturnOnClick=new View.OnClickListener(){
       @Override
       public void onClick(View v){
           Intent itReturn=new Intent();
           itReturn.setClass(CalculaterActivity.this,MenuActivity.class);
           startActivity(itReturn);
       }
   };

    private View.OnClickListener btnCOnClick=new View.OnClickListener(){
        @Override
        public void onClick(View v){
            number1=0;
            number2=0;
            numberOutput=0;
            inputString1="";
            inputString2="";
            bufString="";
            outputString="";
            state=0;//0 for the first number, 1 for the second number
            symbol=0;//1 to +, 2 to -, 3 to *, 4 to / ,0 to initial
            count=0;
            edtInput.setText("");
            edtAnswer.setText("0");
        }
    };
    private View.OnClickListener btnEOnClick=new View.OnClickListener(){
        @Override
        public void onClick(View v){
            int error_zero=0;
            if(state==0 && inputString1.equals("")==false){
                number1=Integer.parseInt(inputString1);
                outputString=Integer.toString(number1);
                edtAnswer.setText(outputString);
            }else if(state==1){
                number2=Integer.parseInt(inputString2);
                switch (symbol){
                    case 1:{
                        numberOutput=number1+number2;
                        break;
                    }
                    case 2:{
                        numberOutput=number1-number2;
                        break;
                    }
                    case 3:{
                        numberOutput=number1*number2;
                        break;
                    }
                    case 4:{
                        if(number2==0){
                            error_zero=1;
                        }else {
                            numberOutput = number1 / number2;
                        }
                        break;
                    }
                    default:{
                        break;
                    }
                }
                outputString=Integer.toString(numberOutput);
                if(error_zero==0){
                    edtAnswer.setText(outputString);
                }else{
                    edtAnswer.setText(getString(R.string.canNotBeZero));
                }

                number1=0;
                number2=0;
                numberOutput=0;
                inputString1="";
                inputString2="";
                bufString="";
                outputString="";
                state=0;//0 for the first number, 1 for the second number
                symbol=0;//1 to +, 2 to -, 3 to *, 4 to / ,0 to initial
                count=0;
            }
        }
    };
    private View.OnClickListener btnDOnClick=new View.OnClickListener(){
        @Override
        public void onClick(View v){
            if(state==0 && inputString1.equals("")==false){
                number1=Integer.parseInt(inputString1);
                symbol=4;
                state=1;
                edtInput.setText("/");
                count=0;
            }
        }
    };
    private View.OnClickListener btnMultOnClick=new View.OnClickListener(){
        @Override
        public void onClick(View v){
            if(state==0 && inputString1.equals("")==false){
                number1=Integer.parseInt(inputString1);
                symbol=3;
                state=1;
                edtInput.setText("*");
                count=0;
            }
        }
    };
    private View.OnClickListener btnMOnClick=new View.OnClickListener(){
        @Override
        public void onClick(View v){
            if(state==0 && inputString1.equals("")==false){
                number1=Integer.parseInt(inputString1);
                symbol=2;
                state=1;
                edtInput.setText("-");
                count=0;
            }
        }
    };
    private View.OnClickListener btnPOnClick=new View.OnClickListener(){
        @Override
        public void onClick(View v){
            if(state==0 && inputString1.equals("")==false){
                number1=Integer.parseInt(inputString1);
                symbol=1;
                state=1;
                edtInput.setText("+");
                count=0;
            }
        }
    };
    private View.OnClickListener btnZOnClick=new View.OnClickListener(){
        @Override
        public void onClick(View v){
            while(count<=8) {
                if (state == 0) {
                    bufString = "0";
                    inputString1 += bufString;
                    edtInput.setText(inputString1);
                    bufString = "";
                    count+=1;
                    break;
                } else if (state == 1) {
                    bufString = "0";
                    inputString2 += bufString;
                    edtInput.setText(inputString2);
                    bufString = "";
                    count+=1;
                    break;
                }
            }
        }
    };
    private View.OnClickListener btn9OnClick=new View.OnClickListener(){
        @Override
        public void onClick(View v){
            while(count<=8) {
                if (state == 0) {
                    bufString = "9";
                    inputString1 += bufString;
                    edtInput.setText(inputString1);
                    bufString = "";
                    count+=1;
                    break;
                } else if (state == 1) {
                    bufString = "9";
                    inputString2 += bufString;
                    edtInput.setText(inputString2);
                    bufString = "";
                    count+=1;
                    break;
                }
            }
        }
    };
    private View.OnClickListener btn8OnClick=new View.OnClickListener(){
        @Override
        public void onClick(View v){
            while(count<=8) {
                if (state == 0) {
                    bufString = "8";
                    inputString1 += bufString;
                    edtInput.setText(inputString1);
                    bufString = "";
                    count+=1;
                    break;
                } else if (state == 1) {
                    bufString = "8";
                    inputString2 += bufString;
                    edtInput.setText(inputString2);
                    bufString = "";
                    count+=1;
                    break;
                }
            }
        }
    };
    private View.OnClickListener btn7OnClick=new View.OnClickListener(){
        @Override
        public void onClick(View v){
            while(count<=8) {
                if (state == 0) {
                    bufString = "7";
                    inputString1 += bufString;
                    edtInput.setText(inputString1);
                    bufString = "";
                    count+=1;
                    break;
                } else if (state == 1) {
                    bufString = "7";
                    inputString2 += bufString;
                    edtInput.setText(inputString2);
                    bufString = "";
                    count+=1;
                    break;
                }
            }
        }
    };
    private View.OnClickListener btn6OnClick=new View.OnClickListener(){
        @Override
        public void onClick(View v) {
            while(count<=8) {
                if (state == 0) {
                    bufString = "6";
                    inputString1 += bufString;
                    edtInput.setText(inputString1);
                    bufString = "";
                    count+=1;
                    break;
                } else if (state == 1) {
                    bufString = "6";
                    inputString2 += bufString;
                    edtInput.setText(inputString2);
                    bufString = "";
                    count+=1;
                    break;
                }
            }
        }
    };
    private View.OnClickListener btn5OnClick=new View.OnClickListener(){
        @Override
        public void onClick(View v){
            while(count<=8) {
                if (state == 0) {
                    bufString = "5";
                    inputString1 += bufString;
                    edtInput.setText(inputString1);
                    bufString = "";
                    count+=1;
                    break;
                } else if (state == 1) {
                    bufString = "5";
                    inputString2 += bufString;
                    edtInput.setText(inputString2);
                    bufString = "";
                    count+=1;
                    break;
                }
            }
        }
    };
    private View.OnClickListener btn4OnClick=new View.OnClickListener(){
        @Override
        public void onClick(View v){
            while(count<=8) {
                if (state == 0) {
                    bufString = "4";
                    inputString1 += bufString;
                    edtInput.setText(inputString1);
                    bufString = "";
                    count+=1;
                    break;
                } else if (state == 1) {
                    bufString = "4";
                    inputString2 += bufString;
                    edtInput.setText(inputString2);
                    bufString = "";
                    count+=1;
                    break;
                }
            }
        }
    };
    private View.OnClickListener btn3OnClick=new View.OnClickListener(){
        @Override
        public void onClick(View v) {
            while(count<=8) {
                if (state == 0) {
                    bufString = "3";
                    inputString1 += bufString;
                    edtInput.setText(inputString1);
                    bufString = "";
                    count+=1;
                    break;
                } else if (state == 1) {
                    bufString = "3";
                    inputString2 += bufString;
                    edtInput.setText(inputString2);
                    bufString = "";
                    count+=1;
                    break;
                }
            }
        }
    };
    private View.OnClickListener btn2OnClick=new View.OnClickListener(){
        @Override
        public void onClick(View v) {
            while(count<=8) {
                if (state == 0) {
                    bufString = "2";
                    inputString1 += bufString;
                    edtInput.setText(inputString1);
                    bufString = "";
                    count+=1;
                    break;
                } else if (state == 1) {
                    bufString = "2";
                    inputString2 += bufString;
                    edtInput.setText(inputString2);
                    bufString = "";
                    count+=1;
                    break;
                }
            }
        }
    };
    private View.OnClickListener btn1OnClick=new View.OnClickListener(){
        @Override
        public void onClick(View v){
            while(count<=8) {
                if (state == 0) {
                    bufString = "1";
                    inputString1 += bufString;
                    edtInput.setText(inputString1);
                    bufString = "";
                    count+=1;
                    break;
                } else if (state == 1) {
                    bufString = "1";
                    inputString2 += bufString;
                    edtInput.setText(inputString2);
                    bufString = "";
                    count+=1;
                    break;
                }
            }
        }
    };


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_calculater, menu);
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
