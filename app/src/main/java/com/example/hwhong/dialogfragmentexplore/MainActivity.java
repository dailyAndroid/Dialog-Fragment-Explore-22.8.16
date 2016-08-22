package com.example.hwhong.dialogfragmentexplore;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements DialogFrag.Communicator {

    private Button button;
    public static ImageView imageView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = (ImageView)findViewById(R.id.imageView);

        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fm = getSupportFragmentManager();
                DialogFrag df = new DialogFrag();
                //the string in the second parameter is used for future reference possibility
                //i.e findFragmentByTag("dialog");
                df.show(fm, "dialog");

            }
        });
    }

    @Override
    public void onActivity(String string, int drawable) {

        if(drawable == 1) {
            imageView.setImageResource(R.drawable.spotify);
        }
        Toast.makeText(getApplicationContext(), string, Toast.LENGTH_SHORT).show();
    }
}
