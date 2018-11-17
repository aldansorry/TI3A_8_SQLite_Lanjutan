package sorry.aldan.ti3a_8_sqlite_lanjutan;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button btnstore,btnGetall;
    private EditText etname, ethobby, etcity;
    private DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        databaseHelper = new DatabaseHelper(this);
        btnGetall = (Button) findViewById(R.id.btnget);
        btnstore = (Button) findViewById(R.id.btnstore);
        etname = (EditText)findViewById(R.id.etname);
        ethobby = (EditText)findViewById(R.id.ethobby);
        etcity = (EditText)findViewById(R.id.etcity);

        btnstore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                databaseHelper.addUser(etname.getText().toString(), ethobby.getText().toString(), etcity.getText().toString());
                etname.setText("");
                ethobby.setText("");
                etcity.setText("");
                Toast.makeText(MainActivity.this,"Stored Succesfully !", Toast.LENGTH_SHORT).show();
            }
        });
        btnGetall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, GetAllUsersActivity.class);
                startActivity(intent);
            }
        });
    }
}
