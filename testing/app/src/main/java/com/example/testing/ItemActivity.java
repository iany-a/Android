package com.example.testing;

import static com.example.testing.R.id.etName;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.testing.model.Sports;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ItemActivity extends AppCompatActivity {

    private EditText etName, etDescription, etId, etDate;
    private Spinner spHall;
    private Button btnSave;
    @SuppressLint("SimpleDateFormat")
    private final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_item);

        etName = findViewById(R.id.etName);
        etDescription = findViewById(R.id.etDescription);
        etId = findViewById(R.id.etId);
        etDate = findViewById(R.id.etDate);
        spHall = findViewById(R.id.spHall);
        btnSave = findViewById(R.id.btnSave);

        //Spinner adapter
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this, R.array.hall_list, android.R.layout.simple_spinner_item
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spHall.setAdapter(adapter);

        btnSave.setOnClickListener(v -> saveItem());

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private void saveItem(){
        String name = etName.getText().toString().trim();
        String desc = etDescription.getText().toString().trim();
        String id = etId.getText().toString().trim();
        String dateStr = etDate.getText().toString().trim();
        String hall = spHall.getSelectedItem().toString();

        //validate date
        Date date;
        try{
            date=sdf.parse(dateStr);
        } catch(ParseException e){
            etDate.setError("Use format yyyy-mm-dd");
            return;
        }

        //build object
        Sports sports = new Sports(name, desc, id, date, hall);

        //toast
        Toast.makeText(this, "Object created: "+ sports.getName(), Toast.LENGTH_SHORT).show();

        //Return to Main activity
        Intent result = new Intent();
        result.putExtra("sports", sports);
        setResult(RESULT_OK, result);
        finish();
    }

}