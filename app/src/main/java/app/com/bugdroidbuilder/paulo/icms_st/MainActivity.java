package app.com.bugdroidbuilder.paulo.icms_st;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class MainActivity extends AppCompatActivity {



    Toolbar mainToolbar;

    FloatingActionButton buttonNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainToolbar = (Toolbar) findViewById(R.id.main_toolbar);
        buttonNext = (FloatingActionButton) findViewById(R.id.floatingActionButton);
        buttonNext.setOnClickListener(this.nextBtnOnClickListener);

    }


    View.OnClickListener nextBtnOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            Intent intent = new Intent(MainActivity.this, CalcActivity.class);
            startActivity(intent);

        }

    };



}
