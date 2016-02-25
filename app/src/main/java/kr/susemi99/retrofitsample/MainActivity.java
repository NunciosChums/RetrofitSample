package kr.susemi99.retrofitsample;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import kr.susemi99.retrofitsample.models.Json1Item;
import kr.susemi99.retrofitsample.models.Json3Item;
import kr.susemi99.retrofitsample.models.Json4Item;
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

    callJsonType1();
    callJsonType2();
    callJsonType3();
    callJsonType4();
  }

  private void callJsonType1()
  {
    ListService.api().json1("jackson1").enqueue(new Callback<Json1Item>()
    {
      @Override
      public void onResponse(Call<Json1Item> call, Response<Json1Item> response)
      {
        if (response != null && response.isSuccess() && response.body() != null)
        {
          Json1Item type = response.body();
          Log.i("MainActivity | callJsonType1", type.name + ", " + type.url);
        }
      }

      @Override
      public void onFailure(Call<Json1Item> call, Throwable t)
      {
        t.printStackTrace();
      }
    });
  }

  private void callJsonType2()
  {
    ListService.api().json2("jackson2").enqueue(new Callback<Json1Item[]>()
    {
      @Override
      public void onResponse(Call<Json1Item[]> call, Response<Json1Item[]> response)
      {
        if (response != null && response.isSuccess() && response.body() != null)
        {
          Json1Item[] type2 = response.body();
          for (Json1Item type : type2)
          {
            Log.i("MainActivity | callJsonType2", type.name + ", " + type.url);
          }
        }
      }

      @Override
      public void onFailure(Call<Json1Item[]> call, Throwable t)
      {
        t.printStackTrace();
      }
    });
  }

  private void callJsonType3()
  {
    ListService.api().json3("jackson3").enqueue(new Callback<Json3Item>()
    {
      @Override
      public void onResponse(Call<Json3Item> call, Response<Json3Item> response)
      {
        if (response != null && response.isSuccess() && response.body() != null)
        {
          Json3Item type3 = response.body();
          for (Json1Item type : type3.result)
          {
            Log.i("MainActivity | callJsonType3", type.name + ", " + type.url);
          }
        }
      }

      @Override
      public void onFailure(Call<Json3Item> call, Throwable t)
      {
        t.printStackTrace();
      }
    });
  }

  private void callJsonType4()
  {
    ListService.api().json4("jackson4").enqueue(new Callback<Json4Item>()
    {
      @Override
      public void onResponse(Call<Json4Item> call, Response<Json4Item> response)
      {
        if (response != null && response.isSuccess() && response.body() != null)
        {
          Json4Item type = response.body();
          Log.i("MainActivity | callJsonType4", type.result.name + ", " + type.result.url);
        }
      }

      @Override
      public void onFailure(Call<Json4Item> call, Throwable t)
      {
        t.printStackTrace();
      }
    });
  }
}
