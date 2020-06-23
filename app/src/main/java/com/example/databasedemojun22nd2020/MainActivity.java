package com.example.databasedemojun22nd2020;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText editTextID;
    EditText editTextName;
    EditText editTextQuantity;

//    SharedPreferences sharedPreferences;
//    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextID = findViewById(R.id.editTextID);
        editTextQuantity = findViewById(R.id.editTextQuantity);
        editTextName = findViewById(R.id.editTextName);

        //sharedPreferences = getSharedPreferences("my_pref", Context.MODE_PRIVATE);
        //sharedPreferences = getPreferences(Context.MODE_PRIVATE);
        //sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        //editor = sharedPreferences.edit();
    }

    public void addOnClick(View view) {
//        editor.putInt("HIGH_SCORE", 60);
//        editor.commit();
//        editTextID.setText("High score is saved");
        DatabaseHandler dbHandler = new DatabaseHandler(this, null, null, 1);
        String name = editTextName.getText().toString();
        int quantity = Integer.parseInt(editTextQuantity.getText().toString());
        Product product = new Product(name, quantity);
        Long result = dbHandler.insertProduct(product);
        if (result == -1) {
            editTextID.setText("Insert fail!");
        } else {
            editTextID.setText("Insert success!");
            editTextName.setText("");
            editTextQuantity.setText("");
            editTextName.requestFocus();
        }
    }

    public void findOnClick(View view) {
//        int highScore = sharedPreferences.getInt("HIGH_SCORE", 0);
//        editTextName.setText("High score: " + highScore);
        DatabaseHandler handler = new DatabaseHandler(this, null, null, 1);
        Product product = handler.findProduct(editTextName.getText().toString());
        if (product == null) {
            editTextID.setText("Product not found!");
        }else{
            editTextID.setText(product.getId());
            editTextName.setText(product.getName());
            editTextQuantity.setText(product.getQuantity() + "");
        }
    }

    public void deleteOnClick(View view) {
//        editor.remove("HIGH_SCORE");
//        editor.commit();
//        editTextID.setText("High score is removed");


    }
}