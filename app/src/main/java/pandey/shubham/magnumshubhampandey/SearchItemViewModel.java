package pandey.shubham.magnumshubhampandey;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PageKeyedDataSource;
import androidx.paging.PagedList;
import pandey.shubham.magnumshubhampandey.helper.SearchDataItemSource;
import pandey.shubham.magnumshubhampandey.helper.SearchItemDataSourceFactory;
import pandey.shubham.magnumshubhampandey.model.UsersList;

public class SearchItemViewModel extends ViewModel {

    public LiveData<PagedList<UsersList.UserData>> itemPagedList;
    private LiveData<PageKeyedDataSource<Integer, UsersList.UserData>> liveDataSource;

    public  SearchItemViewModel(){
        SearchItemDataSourceFactory itemDataSourceFactory = new SearchItemDataSourceFactory();
        liveDataSource = itemDataSourceFactory.getItemLiveDataSource();

        PagedList.Config config =
                (new PagedList.Config.Builder())
                        .setEnablePlaceholders(false)
                        .setPageSize(SearchDataItemSource.FIRST_PAGE)
                        .build();

        itemPagedList = (new LivePagedListBuilder(itemDataSourceFactory, config)).build();

    }
}
