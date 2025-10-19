package ro.ase.ie.g1107_s03;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private final String MainActivityTag = getClass().getName().toLowerCase();

    public void openActivity(View view){
        Intent intent = new Intent(MainActivity.this, SecondActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); //calls the onCreate from AppCompactActivity
        ///EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        /*ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });*/
        Log.d(MainActivityTag, "onCreate:Entry-point method");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(MainActivityTag, "onStart:Entry-point method");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(MainActivityTag, "onPause:Entry-point method");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(MainActivityTag, "onResume:Entry-point method");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(MainActivityTag, "onStop:Entry-point method");
    }


}