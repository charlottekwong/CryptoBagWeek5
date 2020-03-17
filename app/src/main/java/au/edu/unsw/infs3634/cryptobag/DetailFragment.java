package au.edu.unsw.infs3634.cryptobag;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.NumberFormat;

public class DetailFragment extends Fragment {


    private Coin mCoin;
    private TextView mName;
    private TextView mSymbol;
    private TextView mValue;
    private TextView mChange1h;
    private TextView mChange24h;
    private TextView mChange7d;
    private TextView mMarketcap;
    private TextView mVolume;
    private ImageView mSearch;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        //if (getArguments().getBoolean("inWide") == true) {


      //  } else {

     //       return
      //  }

        int position = getArguments().getInt("position");
        View v = inflater.inflate(R.layout.fragment_detail, container, false);


        mName = v.findViewById(R.id.tvName);
        mSymbol = v.findViewById(R.id.tvSymbol);
        mValue = v.findViewById(R.id.tvValueField);
        mChange1h = v.findViewById(R.id.tvChange1hField);
        mChange24h = v.findViewById(R.id.tvChange24hField);
        mChange7d = v.findViewById(R.id.tvChange7dField);
        mMarketcap = v.findViewById(R.id.tvMarketcapField);
        mVolume = v.findViewById(R.id.tvVolumeField);
        mSearch = v.findViewById(R.id.ivSearch);

        mCoin = Coin.getCoins().get(position);
        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        //setTitle(mCoin.getName());
        mName.setText(mCoin.getName());
        mSymbol.setText(mCoin.getSymbol());
        mValue.setText(formatter.format(mCoin.getValue()));
        mChange1h.setText(String.valueOf(mCoin.getChange1h()) + " %");
        mChange24h.setText(String.valueOf(mCoin.getChange24h()) + " %");
        mChange7d.setText(String.valueOf(mCoin.getChange7d()) + " %");
        mMarketcap.setText(formatter.format(mCoin.getMarketcap()));
        mVolume.setText(formatter.format(mCoin.getVolume()));
        mSearch.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                searchCoin(mCoin.getName());
            }
        });

        return v;

    }


        private void searchCoin(String name) {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/search?q=" + name));
            startActivity(intent);
        }

}
