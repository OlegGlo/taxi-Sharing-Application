package com.example.fareshare;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.ArrayAdapter;import android.widget.ListView;

public class PendingRequestActivity extends Activity
{
    // Array of strings...
    ListView requestList;
    String pendingList[] = {/*TODO: update from incoming requests*/ };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);      setContentView(R.layout.activity_main);
        requestList = (ListView)findViewById(R.id.pendingRequestListView);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, R.layout.activity_pendinglistview, R.id.textView, pendingList);
        requestList.setAdapter(arrayAdapter);
    }
}