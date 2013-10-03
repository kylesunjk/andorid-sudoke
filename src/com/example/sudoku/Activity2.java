package com.example.sudoku;


import java.util.ArrayList;
import java.util.Random;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.text.InputType;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Activity2 extends Activity {
	 boolean flag[][]=new boolean[4][4]; 
	 Button bt1 , bt2 , bt3 , bt4; 
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_activity2);
		
		final Object inputRoot[][]=new Object[4][4];
		Button level1 = (Button) findViewById(R.id.home);
        level1.setOnClickListener(new View.OnClickListener() {
        public void onClick(View view) {
        Intent myIntent = new Intent(view.getContext(), MainActivity.class);
        startActivityForResult(myIntent, 0);
        } });
        
        LinearLayout layout1=new LinearLayout(this);
        layout1=(LinearLayout)findViewById(R.id.linearlayout1);
        
        int[][] field=new int[4][4];
        for(int i=0;i<4;i++){
        	 final LinearLayout layout2=new LinearLayout(this);
             layout2.setOrientation(LinearLayout.HORIZONTAL);
             Random myRandom;
             myRandom=new Random();
             int blankNum1=myRandom.nextInt(4);
             int blankNum2;
             do{
            	 blankNum2=myRandom.nextInt(4);
             }while(blankNum2==blankNum1);
            	
        	for(int j=0;j<4;j++){
        		final EditText sudo=new EditText(this);
        		sudo.setWidth(60);
        		sudo.setTextSize((float)15.0);
        		sudo.setTextColor(Color.BLACK);
        		field[i][j]=(2*i+i/2+j)%4+1;
        		sudo.setText(String.valueOf(field[i][j]));
        		sudo.setCursorVisible(false);
        		sudo.clearFocus();
        		
        		sudo.setOnTouchListener(new OnTouchListener(){

					@Override
					public boolean onTouch(View arg0, MotionEvent arg1) {
						// TODO Auto-generated method stub
    	                int inType = sudo.getInputType(); // backup the input type  
    	                sudo.setInputType(InputType.TYPE_NULL); // disable soft input      
    	                sudo.onTouchEvent(arg1); // call native handler      
    	                sudo.setInputType(inType); // restore input type     
    	                sudo.setSelection(sudo.getText().length());  
    	                return true;  
					}
        	         
        	        });
        		
        		sudo.setInputType(InputType.TYPE_CLASS_NUMBER);
        		if(j==blankNum1||j==blankNum2){
        			sudo.setText("");
        			//sudo.setTag("0");
        			flag[i][j] = true;
        			sudo.setEnabled(true);
        			sudo.setTextColor(Color.RED);
        		}
        		else{
        			//sudo.setTag("1");
        			sudo.setEnabled(false);
        			flag[i][j] = false;
        		}
        		inputRoot[i][j]=sudo;
        		layout2.addView(sudo);       		
        		
        	}
        	layout1.addView(layout2);
        	
        }
        
        final String inputNum[][]=new String[4][4];
        final int[][] sudokuArray = new int[4][4];
        Button submit = (Button) findViewById(R.id.submit);
        submit.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				 for(int i=0;i<4;i++){ 	 
		            	for(int j=0;j<4;j++){
		           		
		            		EditText et=(EditText)inputRoot[i][j];
		            		
		            		
		            		if(et.getText().toString().equalsIgnoreCase("")){
		            			inputNum[i][j]="0";
		            			sudokuArray[i][j] = Integer.valueOf(inputNum[i][j]).intValue();
		            			           			
		            		}
		            		else
		            		{
		            			inputNum[i][j]=et.getText().toString();
		            			sudokuArray[i][j] = Integer.valueOf(inputNum[i][j]).intValue();
		            		          }
		                    	 }
		                     }

		            		
				 TextView showResult = (TextView) findViewById(R.id.textView1);
				 showResult.setText("success");
		         for(int i=0 ; i<4; i ++){
						for(int j = 0 ; j<4 ;j++ ){
							if(flag[i][j]==true){
							if(!judgesudoke(sudokuArray, i , j)){					
							    	showResult.setText("you are wrong");
								    break;

							}
							}
							
						}
					}
	
		            	    
			}});
        
        bt1 = (Button) findViewById(R.id.button1);
        bt2 = (Button) findViewById(R.id.button2);
        bt3 = (Button) findViewById(R.id.button3);
        bt4 = (Button) findViewById(R.id.button4);
        
        bt1.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				 for(int i=0 ; i<4; i ++){
						for(int j = 0 ; j<4 ;j++ ){
							EditText et123 = (EditText) inputRoot[i][j];
							if(et123.isFocused()){
								et123.setText("1");
							}
							
						}
				 }
			}
        	
        });
        
        bt2.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				 for(int i=0 ; i<4; i ++){
						for(int j = 0 ; j<4 ;j++ ){
							EditText et123 = (EditText) inputRoot[i][j];
							if(et123.isFocused()){
								et123.setText("2");
							}
							
						}
				 }
			}
        	
        });
        
        bt3.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				 for(int i=0 ; i<4; i ++){
						for(int j = 0 ; j<4 ;j++ ){
							EditText et123 = (EditText) inputRoot[i][j];
							if(et123.isFocused()){
								et123.setText("3");
							}
							
						}
				 }
			}
        	
        });
        
        bt4.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				 for(int i=0 ; i<4; i ++){
						for(int j = 0 ; j<4 ;j++ ){
							EditText et123 = (EditText) inputRoot[i][j];
							if(et123.isFocused()){
								et123.setText("4");
							}
							
						}
				 }
			}
        	
        });
        
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_activity2, menu);
		return true;
	}
	
	static boolean judgesudoke (int[][] singleSudoku , int i , int j){
    	ArrayList<Integer> l1 = new ArrayList<Integer>();
    	ArrayList<Integer> l2 = new ArrayList<Integer>();
    	ArrayList<Integer> squ1 = new ArrayList<Integer>();
    	ArrayList<Integer> squ2 = new ArrayList<Integer>();
    	ArrayList<Integer> squ3 = new ArrayList<Integer>();
    	ArrayList<Integer> squ4 = new ArrayList<Integer>();
    	
    	for(int x=0 ; x<=3 ; x++){
    		if(x != j){
    			l1.add(singleSudoku[i][x]);
    		}	
    	}
    	
    	
    	for(int x=0 ; x<=3 ; x++){
    		if(x!=i){
    			l2.add(singleSudoku[x][j]);
    		}
    		
    	}
    	
    	for(int x = 0 ; x<=1 ; x++){
    		for(int y = 0 ; y <=1 ; y ++){
    			if(i!=x && j!=y){
    			squ1.add(singleSudoku[x][y]) ;
    			}
    		}
    	}
    	
    	for(int x = 2 ; x<=3 ; x++){
    		for(int y = 0 ; y <=1 ; y ++){
    			if(i!=x && j!=y){
    			squ2.add(singleSudoku[x][y]) ;
    			}
    		}
    	}
    	
    	for(int x = 0 ; x<=1 ; x++){
    		for(int y = 2 ; y <=3 ; y ++){
    			if(i!=x && j!=y){
    			squ3.add(singleSudoku[x][y]) ;
    			}
    		}
    	}
    	
    	
    	for(int x = 2 ; x<=3 ; x++){
    		for(int y = 2 ; y <=3 ; y ++){
    			if(i!=x && j!=y){
    			squ4.add(singleSudoku[x][y]) ;
    			}
    		}
    	}
    	
    	boolean first = !l1.contains(singleSudoku[i][j]);
    	boolean second = !l2.contains(singleSudoku[i][j]);
    	boolean third = true;
    	if( i <=1 && j<=1){		
    		third = !squ1.contains(singleSudoku[i][j]);
    	}   else if( i <=1 && j>1){
    		third = !squ3.contains(singleSudoku[i][j]);
    	}else if( i >1 && j<=1){
    		third = !squ2.contains(singleSudoku[i][j]);
    	}
    	else if( i >1 && j>1){
    		third = !squ4.contains(singleSudoku[i][j]);
    	}
    	
    	if(first&&second&&third){
    		return true;
    	}
    	else{
    		return false;
    	}
    	
    }

}
