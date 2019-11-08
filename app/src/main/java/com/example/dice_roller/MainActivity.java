package com.example.dice_roller;

import android.os.Bundle;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {


    private TextView mgTv;
    private EditText userEntered;
    private Button validate;
    private int counter = 0;
    private TextView countering;
    private TextView counterDP;
    private TextView questionlist;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mgTv = (TextView) findViewById(R.id.message);
        userEntered = (EditText) findViewById(R.id.userEntered);
        countering = (TextView) findViewById(R.id.countering);
        counterDP = (TextView) findViewById(R.id.counterView);
        questionlist = (TextView) this.findViewById(R.id.list);


        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void on_button_click(View view) {
        TextView tv = this.findViewById(R.id.myTextView);


        Random r = new Random();
        int number = r.nextInt(7);

        tv.setText(Integer.toString(number));


        int n = Integer.parseInt(userEntered.getText().toString());


        if (n < 1 || n > 6) {
            Toast.makeText(this, "Invalid input, the number is not in range", Toast.LENGTH_SHORT).show();
        } else if (n == number) {
            Toast.makeText(this, "Congrats! Number macthes", Toast.LENGTH_SHORT).show();
            counter = counter + 1;
            counterDP.setText(Integer.toString(counter));
        }


    }

    public void randomlist(View view){

        ArrayList<String> questionSelection = new ArrayList<>();
        questionSelection.add("1) If you could go anywhere in the world, where would you go?");
        questionSelection.add("2) If you were stranded on a desert island, what three things would you want to take with you?");
        questionSelection.add("3) If you could eat only one food for the rest of your life, what would that be?");
        questionSelection.add("4) If you won a million dollars, what is the first thing you would buy?");
        questionSelection.add("5) If you could spaned the day with one fictional character, who would it be?");
        questionSelection.add("6) If you found a magic lantern and a genie gave you three wishes, what would you wish?");

        Random r = new Random();
        int numElement = 1;

        for (int i = 0; i < numElement; i++) {

            int index = r.nextInt(questionSelection.size());
            String randomE =  questionSelection.get(index);
            questionlist.setText(randomE);
        }
    }
}