package tommymertell.novelspeedwriting;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

/**
 * Created by Tommy on 12/3/2016.
 */
public class AdFragment extends Fragment {
    // Avoid Placing App ID in Github Repository
    public Secrets new_secret = new Secrets();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        // inflate the fragment view
        View view = inflater.inflate(R.layout.ad_fragment, container, false);
        // initlialize the ad for the activity
        MobileAds.initialize(getActivity(), new_secret.getAppID());
        // find a view for it to latch on to
        AdView mAdView = (AdView) view.findViewById(R.id.adView);
        // Make and Build an new Ad Request from the API
        AdRequest adRequest = new AdRequest.Builder().build();
        // Load the Ad into the view
        mAdView.loadAd(adRequest);
        // return the view. Don't need to return mAdView as it is latched on to the id.Adview
        return view;
    }
}
