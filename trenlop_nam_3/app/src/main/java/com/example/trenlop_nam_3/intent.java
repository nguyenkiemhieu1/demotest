package com.example.trenlop_nam_3;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

public class intent extends AppCompatActivity {
Button b1,b2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent);
        b1=(Button)findViewById(R.id.button);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browser=new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.phimmoi.net"));
                startActivity(browser);
            }
        });
        b2=(Button)findViewById(R.id.button2);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(Intent.ACTION_VIEW,Uri.parse("tel:0379117280"));
                startActivity(intent);
            }
        });
    //    @Override
//        public boolean onCreateOptionsMenu(Menu menu)
//        {
//            getMenuInflater().inflate(R.menu.menu_main,menu);
//            return true;
//        }
//        @Override
//        public boolean onOptionsItemSelected (MenuItem  item) {
//            // Handle action bar item clicks here. The action bar will
//            // automatically handle clicks on the Home/Up button, so long
//            // as you specify a parent activity in AndroidManifest.xml.
//
//            int id = item.getItemId();
//
//            //noinspection SimplifiableIfStatement
//            if (id == R.id.action_settings) {
//                return true;
//            }
//            return super.onOptionsItemSelected(item);
//        }

    }
}
