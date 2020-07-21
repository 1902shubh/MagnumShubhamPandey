package pandey.shubham.magnumshubhampandey.helper;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.paging.PageKeyedDataSource;
import pandey.shubham.magnumshubhampandey.MainActivity;
import pandey.shubham.magnumshubhampandey.model.UsersList;
import pandey.shubham.magnumshubhampandey.utilities.ApiClient;
import pandey.shubham.magnumshubhampandey.utilities.UserInterface;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SearchDataItemSource extends PageKeyedDataSource<Integer, UsersList.UserData> {

    public static final int FIRST_PAGE = 1;

    @Override
    public void loadInitial(@NonNull PageKeyedDataSource.LoadInitialParams<Integer> params, @NonNull LoadInitialCallback<Integer, UsersList.UserData> callback) {
        ApiClient.getClient().create(UserInterface.class)
                .getUsersSearchResult(MainActivity.text, FIRST_PAGE)
                .enqueue(new Callback<UsersList>() {
                    @Override
                    public void onResponse(Call<UsersList> call, Response<UsersList> response) {

                        if (response.body() != null) {


                            UsersList userList = response.body();
                            ArrayList<UsersList.UserData> list = new ArrayList<>();
                            //                        Toast.makeText(SearchActivity.this, data.login, Toast.LENGTH_SHORT).show();
                            list.addAll(userList.items);

                            callback.onResult(list, null, FIRST_PAGE+1);
                        }

                    }

                    @Override
                    public void onFailure(Call<UsersList> call, Throwable t) {

                    }
                });
    }

    @Override
    public void loadBefore(@NonNull LoadParams<Integer> params, @NonNull LoadCallback<Integer, UsersList.UserData> callback) {
        ApiClient.getClient().create(UserInterface.class)
                .getUsersSearchResult(MainActivity.text, params.key)
                .enqueue(new Callback<UsersList>() {
                    @Override
                    public void onResponse(Call<UsersList> call, Response<UsersList> response) {

                        Integer key = (params.key > 1) ? params.key-1 : null;
                        if (response.body() != null) {

                            UsersList userList = response.body();
                            ArrayList<UsersList.UserData> list = new ArrayList<>();
                            //                        Toast.makeText(SearchActivity.this, data.login, Toast.LENGTH_SHORT).show();
                            list.addAll(userList.items);

                            callback.onResult(list, key);
                        }

                    }

                    @Override
                    public void onFailure(Call<UsersList> call, Throwable t) {

                    }
                });
    }

    @Override
    public void loadAfter(@NonNull LoadParams<Integer> params, @NonNull LoadCallback<Integer, UsersList.UserData> callback) {
        ApiClient.getClient().create(UserInterface.class)
                .getUsersSearchResult(MainActivity.text, params.key)
                .enqueue(new Callback<UsersList>() {
                    @Override
                    public void onResponse(Call<UsersList> call, Response<UsersList> response) {


                        if (response.body() != null) {

                            UsersList userList = response.body();
                            ArrayList<UsersList.UserData> list = new ArrayList<>();
                            //                        Toast.makeText(SearchActivity.this, data.login, Toast.LENGTH_SHORT).show();
                            list.addAll(userList.items);

                            callback.onResult(list, params.key + 1);
                        }

                    }

                    @Override
                    public void onFailure(Call<UsersList> call, Throwable t) {

                    }
                });

    }
}

