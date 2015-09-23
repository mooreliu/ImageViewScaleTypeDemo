package salesmarket.mooreliu.com.scaletypedemo;

import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends FragmentActivity{



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setFragment();
    }

    private void setFragment() {
        FragmentManager fm = getSupportFragmentManager();//  getFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.root,  new FragmentChooseScaleType());
        ft.addToBackStack(null);
        ft.commit();
    }


}
