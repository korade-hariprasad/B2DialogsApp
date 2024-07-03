package sumagoscope.madipt.b2dialogsapp;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    Button btnAlert;
    Button btnCustom;
    String[] cities=new String[]{"Nashik","Pune","Mumbai"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnAlert=findViewById(R.id.btnAlert);
        btnCustom=findViewById(R.id.btnCustom);
        btnCustom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                showCustomDialog();
            }
        });
        btnAlert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //showSimpleDialog();
               // showSimpleDialogWithOptions();
                showSimpleDialogWithRadioButtons();
            }
        });

    }

    private void showCustomDialog() {

        Dialog dialog=new Dialog(MainActivity.this);
        dialog.setContentView(R.layout.custom_dialog_layout);
        Button btnSubmit=dialog.findViewById(R.id.btnSubmit);
        TextInputEditText etName=dialog.findViewById(R.id.etName);
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(MainActivity.this, ""+etName.getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });
        dialog.show();


    }

    private void showSimpleDialog() {
        AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity.this)
                .setTitle("Hello")
                .setMessage("Message text here")
                .setCancelable(false)
                .setIcon(R.drawable.ic_launcher_background)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        dialog.dismiss();
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        dialog.dismiss();
                    }
                });

        AlertDialog alertDialog=builder.create();
        alertDialog.show();
    }

    private void showSimpleDialogWithOptions() {
        AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity.this)
                .setTitle("Hello")
                .setIcon(R.drawable.ic_launcher_background)
                .setItems(cities, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        Toast.makeText(MainActivity.this, ""+cities[which], Toast.LENGTH_SHORT).show();
                    }
                });

        AlertDialog alertDialog=builder.create();
        alertDialog.show();
    }

    private void showSimpleDialogWithRadioButtons() {
        AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity.this)
                .setTitle("Hello")
                .setIcon(R.drawable.ic_launcher_background)
                .setSingleChoiceItems(cities, -1, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        Toast.makeText(MainActivity.this, ""+cities[which], Toast.LENGTH_SHORT).show();
                    }
                }).setPositiveButton("Submit", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        dialog.dismiss();
                    }
                });

        AlertDialog alertDialog=builder.create();
        alertDialog.show();
    }
}