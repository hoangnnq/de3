package com.example.onthi3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText mTextView;
    ListView ListView;
    MyAdapter lstTaxiAdapter;
    ArrayList<Phong_User>lstTaxi,lstTam;
    DB_Phong abc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextView = findViewById(R.id.editTextTextPersonName);
        ListView = findViewById(R.id.list);
//        btn=findViewById(R.id.fatadd);

        mTextView.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (isNumeric(mTextView.getText().toString()) == true) {
                    UpdateArr();
                    lstTaxi = abc.getbyTienPhong(Integer.parseInt(mTextView.getText().toString()));
                    UpdateContact();

                } else {
                    UpdateArr();
                    lstTaxi = abc.getAllContact();
                    UpdateContact();
                }
            }
            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        registerForContextMenu(ListView);


        abc = new DB_Phong(this, "ContactDB", null, 1);
//        abc.addTaxi(new Phong_User(null,"Nguyễn Anh Tuấn",2,500,4));
//        abc.addTaxi(new Phong_User(null,"Nguyễn Thị Thu Hà",4,150,3));
        lstTaxi = abc.getAllContact();
        lstTaxiAdapter = new MyAdapter(this, lstTaxi);
        lstTaxiAdapter.notifyDataSetChanged();
        ListView.setAdapter(lstTaxiAdapter);
        ListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                lstTam = abc.getbyTienPhong(lstTaxi.get(position).getSoNgayLuuTru() * lstTaxi.get(position).getDonGia());
                Toast.makeText(MainActivity.this, "Nguyễn Anh Tuấn - 191201082 " + lstTam.size(), Toast.LENGTH_SHORT).show();
                return false;
            }

        });

    }
    public static boolean isNumeric(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }
    public void UpdateArr(){
        abc=new DB_Phong(this,"ContactDB",null,1);
        lstTaxi= new ArrayList<>();


    }
    public void UpdateContact(){
        lstTaxiAdapter=new MyAdapter(MainActivity.this,lstTaxi);
        ListView.setAdapter(lstTaxiAdapter);
    }
}