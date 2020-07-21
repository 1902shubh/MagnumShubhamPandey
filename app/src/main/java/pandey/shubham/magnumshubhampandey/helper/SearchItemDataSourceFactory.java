package pandey.shubham.magnumshubhampandey.helper;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import androidx.paging.DataSource;
import androidx.paging.PageKeyedDataSource;
import pandey.shubham.magnumshubhampandey.model.UsersList;

public class SearchItemDataSourceFactory extends DataSource.Factory {

    private MutableLiveData<PageKeyedDataSource<Integer, UsersList.UserData>> itemLiveDataSource =
            new MutableLiveData<>();


    @NonNull
    @Override
    public DataSource create() {
        SearchDataItemSource itemDataSource = new SearchDataItemSource();
        itemLiveDataSource.postValue(itemDataSource);
        return itemDataSource;
    }

    public MutableLiveData<PageKeyedDataSource<Integer, UsersList.UserData>> getItemLiveDataSource() {
        return itemLiveDataSource;
    }
}
