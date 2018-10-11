package ilgulee.com.fragmentbydeviceorientationold;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements MyListFragment.OnListFragmentListener {

    private DetailFragment mDetailFragment;
    private MyListFragment mListFragment;
    private FragmentTransaction mFt;
    private TextView mTextView;
    private String[] mDescriptionArray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTextView=findViewById(R.id.description);
        mDescriptionArray = this.getResources().getStringArray(R.array.descriptions);
        mDetailFragment = (DetailFragment)getSupportFragmentManager().findFragmentById(R.id.detailFragment);
        mListFragment = (MyListFragment)getSupportFragmentManager().findFragmentById(R.id.listFragment);
        mFt = getSupportFragmentManager().beginTransaction();

        if(findViewById(R.id.portrait)!=null){
            mFt.show(mListFragment).hide(mDetailFragment).commit();
        }
        if(findViewById(R.id.landscape)!=null){
            mFt.show(mListFragment).show(mDetailFragment).commit();
            mTextView.setText(mDescriptionArray[0]);
        }
    }

    @Override
    public void onItemClicked(int index) {
        Toast.makeText(this, "You clicked " + index, Toast.LENGTH_SHORT).show();
        mTextView.setText(mDescriptionArray[index]);
        if(findViewById(R.id.portrait)!=null){
            FragmentTransaction ft=getSupportFragmentManager().beginTransaction();
            ft.hide(mListFragment).addToBackStack(null).show(mDetailFragment).commit();
        }

    }
}
