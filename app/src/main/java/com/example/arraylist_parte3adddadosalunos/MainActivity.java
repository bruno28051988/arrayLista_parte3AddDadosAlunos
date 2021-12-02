package com.example.arraylist_parte3adddadosalunos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText editName, editAddress, editEmail;
    private Button btnAdd;
    private ListView listView;
    private ArrayList<Aluno> listaAlunos;
    private ArrayAdapter<Aluno> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editName = findViewById(R.id.editName);
        editAddress = findViewById(R.id.editAddress);
        editEmail = findViewById(R.id.editEmail);
        btnAdd = findViewById(R.id.btnAdd);

        listView = findViewById(R.id.listView);

        listaAlunos = new ArrayList<>();
        adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                listaAlunos
        );
        listView.setAdapter(adapter);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String name = editName.getText().toString();
                String address = editAddress.getText().toString();
                String email = editEmail.getText().toString();

                if(!name.equals("")){
                    if (!address.equals("")){
                        if (!email.equals("")){

                            Aluno aluno = new Aluno(name, address, email);
                            listaAlunos.add(aluno);
                            adapter.notifyDataSetChanged();
                            editName.setText("");
                            editAddress.setText("");
                            editEmail.setText("");

                        }else{
                            Toast.makeText(MainActivity.this,
                                    "Preencha o e-mail",
                                    Toast.LENGTH_SHORT).show();
                        }

                    }else{
                        Toast.makeText(MainActivity.this,
                                "Preencha o endereço",
                                Toast.LENGTH_SHORT).show();
                    }

                }else{
                    Toast.makeText(MainActivity.this,
                            "Preencha o nome",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Toast.makeText(
                        MainActivity.this,
                        listaAlunos.get(i).toString(),
                        Toast.LENGTH_SHORT
                ).show();
            }
        });

    }
}