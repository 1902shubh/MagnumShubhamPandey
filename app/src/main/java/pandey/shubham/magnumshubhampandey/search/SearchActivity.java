package pandey.shubham.magnumshubhampandey.search;

import android.app.ProgressDialog;
import android.os.Bundle;

import java.util.Objects;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import pandey.shubham.magnumshubhampandey.R;
import pandey.shubham.magnumshubhampandey.SearchItemViewModel;
import pandey.shubham.magnumshubhampandey.adapter.SearchAdapter;

public class SearchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        Objects.requireNonNull(getSupportActionBar()).setTitle("Github Users");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        SearchItemViewModel itemViewModel = ViewModelProviders.of(this).get(SearchItemViewModel.class);
        SearchAdapter mAdapter = new SearchAdapter(this);
        itemViewModel.itemPagedList.observe(this, mAdapter::submitList);

        recyclerView.setAdapter(mAdapter);

    }

}