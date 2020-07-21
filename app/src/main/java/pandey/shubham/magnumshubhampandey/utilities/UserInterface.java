package pandey.shubham.magnumshubhampandey.utilities;

import pandey.shubham.magnumshubhampandey.model.UsersList;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface UserInterface {

    @GET("/search/users?")
    Call<UsersList> getUsersSearchResult(
                                        @Query("q") String userName,
                                        @Query("page") int page
                                    );

}
