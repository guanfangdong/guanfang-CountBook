package com.example.counter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class MoreEdit extends AppCompatActivity {
    private static final String FILENAME = "file.sav";

    private ArrayList<EachActivity> activities;
    private ArrayAdapter<EachActivity> adapter;

    private EditText newName;
    private EditText newComment;
    private EditText newCount;

    private int position;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more_edit);
        loadFromFile();
        Intent intent = getIntent();
        position = intent.getExtras().getInt("pos");

        newName = (EditText) findViewById(R.id.newName);
        newComment = (EditText) findViewById(R.id.newComment);
        newCount = (EditText) findViewById(R.id.newCount);

        Button saveButton = (Button) findViewById(R.id.save);
        Button backButton = (Button) findViewById(R.id.back);
        saveButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                String nameStr = new String();
                String CommentStr = new String();
                String CountStr = new String();

                nameStr = newName.getText().toString();
                nameStr.trim();
                CountStr = newCount.getText().toString();
                CommentStr = newComment.getText().toString();

                int newValue = Integer.valueOf(CountStr).intValue();
                if (CommentStr!=null & nameStr!= null &  CountStr != null) {
                    (activities.get(position)).setComment(CommentStr);
                    (activities.get(position)).setName(nameStr);
                    (activities.get(position)).setCount(newValue);

                    saveInFile();
                }
                //Intent backToMain = new Intent(MoreEdit.this, EditCounter.class);
                //startActivity(backToMain);
            }

        });



        backButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent backToMain = new Intent(MoreEdit.this, MainActivity.class);
                startActivity(backToMain);
            }

        });




    }









    private void loadFromFile() {
        try {
            FileInputStream fis = openFileInput(FILENAME);
            BufferedReader in = new BufferedReader(new InputStreamReader(fis));
            Gson gson = new Gson();

            // Taken from https://stackoverflow.com/question/12384064/gson-convert-from-json-into java
            // 2017 01-26 17:53:59
            activities = gson.fromJson(in, new TypeToken<ArrayList<EachActivity>>(){}.getType());

            fis.close();

        } catch (FileNotFoundException e) {
            activities = new ArrayList<EachActivity>();
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }

    /**
     * Saves tweets in file in JSON format.
     * @throws FileNotFoundException if folder not exists
     */
    private void saveInFile() {
        try {
            FileOutputStream fos = openFileOutput(FILENAME,
                    Context.MODE_PRIVATE);
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(fos));
            Gson gson = new Gson();
            gson.toJson(activities, out);
            out.flush();
            fos.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException();
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }

}
