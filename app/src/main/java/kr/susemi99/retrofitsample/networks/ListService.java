package kr.susemi99.retrofitsample.networks;

import kr.susemi99.retrofitsample.models.Json1Item;
import kr.susemi99.retrofitsample.models.Json3Item;
import kr.susemi99.retrofitsample.models.Json4Item;
import kr.susemi99.retrofitsample.networks.bases.BaseService;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by susemi99 on 2016. 2. 25..
 */
public final class ListService extends BaseService
{
  public static ListAPI api()
  {
    return (ListAPI) retrofit(ListAPI.class);
  }

  public interface ListAPI
  {
    @GET("{name}.json")
    Call<Json1Item> json1(@Path("name") String name);

    @GET("{name}.json")
    Call<Json1Item[]> json2(@Path("name") String name);

    @GET("{name}.json")
    Call<Json3Item> json3(@Path("name") String name);

    @GET("{name}.json")
    Call<Json4Item> json4(@Path("name") String name);
  }
}
