package com.example.practical26;

import android.os.AsyncTask;

public class Insert extends AsyncTask<Void,Void,Void> {
    String ist_txt;
    DBHelper dbhelper;
    public Insert(DBHelper db, String txt){
        ist_txt=txt;
        dbhelper=db;
    }


    @Override
    protected Void doInBackground(Void... voids) {
        dbhelper.insert_row(ist_txt);

        return null;
    }
}
