package com.example.sql;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    private EditText nameCourse, timeCourse, priceCourse, descriptionCourse;
    private Button addButtonBtn;
    private  Db db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameCourse = findViewById(R.id.nameCourse);
        timeCourse = findViewById(R.id.timeCourse);
        priceCourse = findViewById(R.id.priceCourse);
        descriptionCourse = findViewById(R.id.descriptionCourse);
        addButtonBtn = findViewById(R.id.addbutton);
        db = new Db(MainActivity.this);

        addButtonBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String courseName = nameCourse.getText().toString();
                String courseTime = timeCourse.getText().toString();
                String coursePrice = priceCourse.getText().toString();
                String courseDescription = descriptionCourse.getText().toString();
                if (courseName.isEmpty() &&
                        courseTime.isEmpty() &&
                        coursePrice.isEmpty() &&
                        courseDescription.isEmpty()){
                    Toast.makeText(MainActivity.this, "لطفاً اطلاعات خواسته شده را کامل کنید", Toast.LENGTH_SHORT).show();
                    return;
                }
                db.addCourse("nameCourse", "timeCourse", "priceCourse", "descriptionCourse");
                Toast.makeText(MainActivity.this, "دوره با موفقیت اضافه شد" , Toast.LENGTH_SHORT).show();
                nameCourse.setText("");
                timeCourse.setText("");
                priceCourse.setText("");
                descriptionCourse.setText("");
            }
        });
      }
    }
