package com.example.zadaniemobilna1811;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<String> arrayListProdukty = new ArrayList<>();
    ArrayAdapter<String> arrayAdapterProdukty;
    ListView listViewListZakupow;
    EditText editTextNazwa;
    Button buttonDodaj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        listViewListZakupow = findViewById(R.id.listView);
        editTextNazwa = findViewById(R.id.editTextText);
        buttonDodaj = findViewById(R.id.button);

        arrayAdapterProdukty = new ArrayAdapter<>(MainActivity.this,
                android.R.layout.simple_list_item_1,arrayListProdukty);

        arrayListProdukty.add("Jabłka");
        arrayListProdukty.add("mleko");
        arrayListProdukty.add("woda");

        listViewListZakupow.setAdapter(arrayAdapterProdukty);

        buttonDodaj.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String produkt = editTextNazwa.getText().toString();
                        arrayListProdukty.add(produkt);
                        listViewListZakupow.setAdapter(arrayAdapterProdukty);
                        editTextNazwa.setText("");
                    }
                }
        );

    }
}