package pandey.shubham.magnumshubhampandey;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import java.util.Objects;

import androidx.appcompat.app.AppCompatActivity;
import pandey.shubham.magnumshubhampandey.search.SearchActivity;

public class MainActivity extends AppCompatActivity {

    private EditText searchText;
    public static String text ="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Objects.requireNonNull(getSupportActionBar()).setTitle("Search User");

        searchText = findViewById(R.id.searchText);
        Button button = findViewById(R.id.button);


        button.setOnClickListener(view -> {
            text = searchText.getText().toString();

            if (text.isEmpty()) {
                searchText.setError("Empty");
            }else {
                Intent intent = new Intent(MainActivity.this, SearchActivity.class);
                startActivity(intent);
            }
        });
    }
}
