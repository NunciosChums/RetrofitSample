package kr.susemi99.retrofitsample;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import kr.susemi99.retrofitsample.models.JsonType1;
import kr.susemi99.retrofitsample.networks.ListService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity
{

  @Override
  protected void onCreate(Bundle savedInstanceState)
  {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);

    FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
    fab.setOnClickListener(new View.OnClickListener()
    {
      @Override
      public void onClick(View view)
      {
        Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG).setAction("Action", null).show();
      }
    });

    ListService.api().json1("jackson1").enqueue(new Callback<JsonType1>()
    {
      @Override
      public void onResponse(Call<JsonType1> call, Response<JsonType1> response)
      {
        if (response != null && response.isSuccess() && response.body() != null)
        {
          JsonType1 type1 = response.body();
          Log.i("MainActivity | onResponse", type1.name + ", " + type1.url);
        }
      }

      @Override
      public void onFailure(Call<JsonType1> call, Throwable t)
      {
        t.printStackTrace();
      }
    });
  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu)
  {
    getMenuInflater().inflate(R.menu.menu_main, menu);
    return true;
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item)
  {
    int id = item.getItemId();

    if (id == R.id.action_settings)
    {
      return true;
    }

    return super.onOptionsItemSelected(item);
  }
}
