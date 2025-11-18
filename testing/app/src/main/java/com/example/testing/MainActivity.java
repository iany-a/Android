package com.example.testing;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResultCaller;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.testing.model.Sports;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ActivityResultLauncher<Intent> itemLauncher;
    private ArrayList<Sports> sportList = new ArrayList<>();


    private Button btnOpenItemActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnOpenItemActivity = findViewById(R.id.btnOpenItemActivity);

        itemLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
                result->{
                    if(result.getResultCode()==RESULT_OK){
                        Intent data = result.getData();
                        if (data !=null && data.hasExtra("item")){
                            Sports sports = data.getParcelableExtra("item", Sports.class);
                            sportList.add(sports);
                            assert sports != null;
                            Toast.makeText(this, "Item Added: "+sports.getName(), Toast.LENGTH_LONG).show();
                        }
                    }
                }
        );

        btnOpenItemActivity.setOnClickListener(v->{
            Intent intent = new Intent(MainActivity.this, ItemActivity.class);
            //startActivity(intent);
            itemLauncher.launch(intent);
        });

    }
}