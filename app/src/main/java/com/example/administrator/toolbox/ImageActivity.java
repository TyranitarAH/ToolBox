package com.example.administrator.toolbox;


import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;



public class ImageActivity extends ActionBarActivity {
    private Button btnReturn,btnExplore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);

        btnReturn=(Button)findViewById(R.id.btnReturn);
        btnExplore=(Button)findViewById(R.id.btnExplore);

        btnReturn.setOnClickListener(btnReturnOCL);
        btnExplore.setOnClickListener(btnExploreOCL);
    }

    private View.OnClickListener btnExploreOCL=new View.OnClickListener(){
        @Override
        public void onClick(View v){
            // TODO Auto-generated method stub
            // create the Intent for the file select action
            Intent intent = new Intent( Intent.ACTION_PICK );

            // select the type for file
            intent.setType( "image/*" );

            //create the selection for the activity or app using for image loading, the second parameter is used for set the title
            Intent destIntent = Intent.createChooser( intent, getString(R.string.ImageExplore) );

            // call the activity or app for image loading and the call the onActivityResult
            startActivityForResult(destIntent, 0);
        }

    };
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        // TODO Auto-generated method stub
        super.onActivityResult(requestCode, resultCode, data);

        // if the file is selected
        if ( resultCode == RESULT_OK )
        {
            // get the uri of file
            Uri uri = data.getData();
            if( uri != null )
            {
                // show image using ImageView with the uri of the file
                ImageView iv = (ImageView)this.findViewById(R.id.imgV);
                iv.setImageURI( uri );

                iv.setContentDescription( uri.toString() );
            }

        }

        //look up for £º http://tomkuo139.blogspot.tw/2010/02/android-choose-file.html
    }
    private View.OnClickListener btnReturnOCL=new View.OnClickListener(){
        @Override
        public void onClick(View v){
            Intent itReturn=new Intent();
            itReturn.setClass(ImageActivity.this,MenuActivity.class);
            startActivity(itReturn);
        }
    };

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_image, menu);
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
