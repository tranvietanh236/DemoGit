package com.example.activity_phanca;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Toolbar mtoolbar;
    Spinner mSpinner_KV, mSpinner_DSNV;
    EditText mDate, mCa;
    ListView mListPC;
    ArrayList<String> list_KV;
    ArrayAdapter<String> adapter_kv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AnhXa();
        Action_toolbar();
        Action_Spinner_KV();
        mDate.setOnClickListener(this);
        mCa.setOnClickListener(this);
    }



    public void Action_Spinner_KV(){
        list_KV.add("khu vuc1");
        list_KV.add("khu vuc2");
        list_KV.add("khu vuc3");
        list_KV.add("khu vuc4");
        adapter_kv = new ArrayAdapter<>(MainActivity.this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, list_KV);
        adapter_kv.setDropDownViewResource(com.google.android.material.R.layout.support_simple_spinner_dropdown_item);
        mSpinner_KV.setAdapter(adapter_kv);


    }

    public void Action_toolbar(){
        setSupportActionBar(mtoolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Phan Ca Truc");
    }
    public void Action_Date(){
        Calendar calendar = Calendar.getInstance();
        int Ngay = calendar.get(Calendar.DATE);
        int Thang = calendar.get(Calendar.MONTH);
        int Nam = calendar.get(Calendar.YEAR);
        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                calendar.set(i, i1, i2);
                @SuppressLint("SimpleDateFormat") SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyy");
                mDate.setText(simpleDateFormat.format(calendar.getTime()));
            }
        }, Nam, Thang, Ngay);
        datePickerDialog.show();
    }

    public void Action_Dialog_Ca(){
        Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.dialog_ca);
        dialog.setTitle(" Chon Ca lam Viec ");
        dialog.setCanceledOnTouchOutside(true);
        TextView mSang = (TextView) dialog.findViewById(R.id.textView_Sang);
        TextView mChieu = (TextView) dialog.findViewById(R.id.textView_Chieu);
        TextView mToi = (TextView) dialog.findViewById(R.id.textView_Toi);

        mSang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mCa.setText(mSang.getText());
                dialog.dismiss();
            }
        });
        mChieu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mCa.setText(mChieu.getText());
                dialog.dismiss();
            }
        });
        mToi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mCa.setText(mToi.getText());
                dialog.dismiss();
            }
        });
        dialog.show();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = new MenuInflater(this);
        menuInflater.inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }


    @SuppressLint("UseSupportActionBar")
    public void AnhXa(){
        mSpinner_KV = (Spinner) findViewById(R.id.spinner_khuVuc);
        mSpinner_DSNV = (Spinner) findViewById(R.id.spinner_nhanVien);
        mDate = (EditText) findViewById(R.id.editTextDate);
        mCa = (EditText) findViewById(R.id.editTextCa);
        mListPC = (ListView) findViewById(R.id.listPhanCa);
        mtoolbar = (Toolbar) findViewById(R.id.toolbar);
        list_KV = new ArrayList<>();
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.editTextDate){
            Action_Date();
        }

        if (view.getId() == R.id.editTextCa){
            Action_Dialog_Ca();
        }
    }


}