package app.com.bugdroidbuilder.paulo.icms_st.Controller;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import app.com.bugdroidbuilder.paulo.icms_st.R;

public class CalcActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc);

        Toolbar toolbar  = (Toolbar) findViewById(R.id.calc_toolbar);
        toolbar.setNavigationOnClickListener(btnBackClickListener);
    }

    View.OnClickListener btnBackClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            Intent intent = new Intent(CalcActivity.this, MainActivity.class);
            startActivity(intent);

        }
    };


}
