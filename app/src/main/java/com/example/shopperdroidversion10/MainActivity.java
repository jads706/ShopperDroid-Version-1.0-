package com.example.shopperdroidversion10;

import android.content.DialogInterface;
import android.os.Bundle;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<String> arrayList = new ArrayList<String>();
    ArrayAdapter<String> arrayAdapter;
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        View view = new View(MainActivity.this);
        AlertDialog.Builder alertBuilder = new AlertDialog.Builder(MainActivity.this);
        alertBuilder.setView(view);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button addBtn = (Button) findViewById(R.id.AddBtn);
        listView = (ListView) findViewById(R.id.listView);
        arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,arrayList);


        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText Item = (EditText) findViewById(R.id.Item);
                EditText Quantity = (EditText) findViewById(R.id.secondNumEditText);
                EditText ExpirDate = (EditText) findViewById(R.id.ExpirDate);
                //TextView resultTextView = (TextView) findViewById(R.id.resultTextView);
                //int num1 = Integer.parseInt(firstNumEditText.getText().toString());
                //int num2 = Integer.parseInt(secondNumEditText.getText().toString());

                String ItemName = Item.getText().toString();
                String QuantityNum = Quantity.getText().toString();
                String DateName = ExpirDate.getText().toString();
                //Item item = new Item("",0,Date, );
                String Resultstr = "Item Name: "+ItemName + " Quantity: " + QuantityNum+ "ExpDate: "+ DateName;
                arrayAdapter.add(Resultstr);
                Editable result = new SpannableStringBuilder(Resultstr);

                //resultTextView.setText(result + "");
                //Log.d("Type=", R.string.app_name);

            }
        });

//        for(int i = 0;i<arrayList.size();i++){
//            arrayAdapter.add(arrayList.get(i));
//        }
        //arrayAdapter.notifyDataSetChanged();
        //arrayAdapter.notifyDataSetChanged();
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this,"You clicked on: " + arrayAdapter.getItem(position),Toast.LENGTH_LONG).show();
            }
        });
        //This is for when user wants to delete an item on the storage List
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                final int which_item = position;

                new AlertDialog.Builder(MainActivity.this)
                        .setIcon(android.R.drawable.ic_delete)
                        .setTitle("Are you sure?")
                        .setMessage("Do you want to delete this item")
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                arrayList.remove(which_item);
                                arrayAdapter.notifyDataSetChanged();
                            }
                        })
                        .setNegativeButton("No",null)
                        .show();

                return true;
            }
        });
    }
}