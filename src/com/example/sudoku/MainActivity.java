package com.example.sudoku;



import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        Button level1 = (Button) findViewById(R.id.button1);
        level1.setOnClickListener(new View.OnClickListener() {
        public void onClick(View view) {
        Intent myIntent = new Intent(view.getContext(), Activity1.class);
        startActivityForResult(myIntent, 0);
        } });
        
        Button level2 = (Button) findViewById(R.id.button2);
        level2.setOnClickListener(new View.OnClickListener() {
        public void onClick(View view) {
        Intent myIntent = new Intent(view.getContext(), Activity2.class);
        startActivityForResult(myIntent, 0);
        } });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
    
}
