package sg.edu.rp.c346.accountconfirmation;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //Simple Dialog Step 2a
    Button btnSubmit;
    EditText etAccNo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Simple Dialog Step 2b - binding for SimpleDialog
        etAccNo = (EditText)findViewById(R.id.editTextAccNo);
        btnSubmit =(Button)findViewById(R.id.buttonSubmit);

        //step 2c for SimpleDialog
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Create the Dialog Builder
                AlertDialog.Builder myBuilder = new AlertDialog.Builder(MainActivity.this);
                //if i put below, then the "Close" will not show.

                myBuilder.setTitle("Account's Submission");
                myBuilder.setMessage("Submit: "+ etAccNo.getText().toString());
                myBuilder.setCancelable(false);

                myBuilder.setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // IMPORTANT: Update TextView as a form of data passing between Dialog and MainActivity
                        Toast.makeText(MainActivity.this, etAccNo.getText().toString()+" submitted", Toast.LENGTH_SHORT).show();
                    }
                });

                myBuilder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {


                    }
                });


                AlertDialog myDialog = myBuilder.create();

                myDialog.show();


            }
        });
    }
}
