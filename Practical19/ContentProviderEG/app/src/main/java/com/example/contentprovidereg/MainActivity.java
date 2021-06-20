package com.example.contentprovidereg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.CursorAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event){
        InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
        return true;
    }

    public void onClickAddDetails(View view){
        ContentValues values = new ContentValues();

        values.put(MyContentProvider.name, ((EditText) findViewById(R.id.textName)).getText().toString());

        getContentResolver().insert(MyContentProvider.CONTENT_URI, values);

        Toast.makeText(getBaseContext(), "New Record Inserted", Toast.LENGTH_LONG).show();
    }

    public void onClickShowDetails(View view){
        TextView result = (TextView) findViewById(R.id.res);

        Cursor c = getContentResolver().query(Uri.parse("content://com.demo.user.provider/users"), null, null, null, null);


        if(c.moveToFirst()){
            StringBuilder str = new StringBuilder();
            while(!c.isAfterLast()){
                str.append("\n" + c.getString(c.getColumnIndex("id")) + ":- " + c.getString(c.getColumnIndex("name")));
                c.moveToNext();
            }
            result.setText(str);
        }
        else{
            result.setText("No Records Found");
        }
    }
}