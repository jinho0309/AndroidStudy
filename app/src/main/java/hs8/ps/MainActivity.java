package hs8.ps;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Toolbar toolbar;
    DrawerLayout mDrawerLayout;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar=(Toolbar)findViewById(R.id.toolbar);
        toolbar.setTitle(R.string.title);
        setSupportActionBar(toolbar);

        toolbar.setNavigationIcon(R.drawable.ic_menu);
        mDrawerLayout=(DrawerLayout)findViewById(R.id.drawer_layout);
        NavigationView navigationView = (NavigationView)findViewById(R.id.navigation_layout);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                mDrawerLayout.closeDrawers();
                int id = item.getItemId();
                switch(id){
                    case R.id.item1 :
                        Toast.makeText(getApplicationContext(),"item1",Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.item2 :
                        Toast.makeText(getApplicationContext(),"item2",Toast.LENGTH_SHORT).show();
                        break;
                }
                return true;
            }
        });

    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id=item.getItemId();
        switch(id){
            case android.R.id.home :
                mDrawerLayout.openDrawer(GravityCompat.START);//왼쪽에서 오른쪽
                break;
            case R.id.setting :
                Toast.makeText(getApplicationContext(),"setting",Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }
}
