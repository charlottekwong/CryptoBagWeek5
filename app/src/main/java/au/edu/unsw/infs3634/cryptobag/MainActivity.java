package au.edu.unsw.infs3634.cryptobag;

import android.os.Bundle;
import android.view.View;

import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "au.edu.unsw.infs3634.beers.MESSAGE";


    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    Boolean inWide;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = findViewById(R.id.rvList);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);


        CoinAdapter.RecyclerViewClickListener listener = new CoinAdapter.RecyclerViewClickListener() {
            @Override
            public void onClick(View view, int position) {

                if (findViewById(R.id.scrollView2) != null){
                    inWide = true;

                    FragmentManager manager = getSupportFragmentManager();
                    FragmentTransaction transaction = manager.beginTransaction();
                    Fragment fragment = new DetailFragment();
                    Bundle bundle = new Bundle();
                    bundle.putBoolean("inWide", inWide);
                    bundle.putString("message", "Activated in Widescreen");
                    fragment.setArguments(bundle);
                    transaction.replace(R.id.scrollView, fragment);
                    transaction.commit();


                } else inWide = false;{
                    FragmentManager manager = getSupportFragmentManager();
                    FragmentTransaction transaction = manager.beginTransaction();
                    Fragment fragment = new DetailFragment();
                    Bundle bundle = new Bundle();
                    bundle.putBoolean("inWide", inWide);
                    bundle.putString("message", "Activated in Widescreen");
                    fragment.setArguments(bundle);
                    launchDetailActivity(position);
                    transaction.replace(R.id.scrollView2, fragment);
                    transaction.commit();

                }

            }
        };
        mAdapter = new CoinAdapter(Coin.getCoins(), listener);
        mRecyclerView.setAdapter(mAdapter);
    }

    public void launchDetailActivity(int position) {
        Intent intent = new Intent(this, DetailActivity.class);
        intent.putExtra(EXTRA_MESSAGE, position);
        startActivity(intent);




    }


}
