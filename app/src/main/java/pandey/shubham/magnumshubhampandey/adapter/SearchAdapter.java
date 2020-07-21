package pandey.shubham.magnumshubhampandey.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;

import androidx.annotation.NonNull;
import androidx.paging.PagedListAdapter;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import pandey.shubham.magnumshubhampandey.R;
import pandey.shubham.magnumshubhampandey.model.UsersList;

public class SearchAdapter extends PagedListAdapter<UsersList.UserData, SearchAdapter.MyViewHolder> {
    private Context mContext;

    public SearchAdapter(Context context){
        super(DIFF_CALLBACK);
        mContext = context;

    }
    @NonNull
    @Override
    public SearchAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_item, parent, false);
        return new SearchAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull SearchAdapter.MyViewHolder holder, int position) {

        UsersList.UserData user = getItem(position);
        if (user != null) {
            holder.mUserName.setText(user.login);
            Glide.with(mContext)
                    .applyDefaultRequestOptions(RequestOptions.circleCropTransform().dontAnimate())
                    .setDefaultRequestOptions(new RequestOptions()
                            .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
                            .circleCrop())
                    .load(user.avatar_url)
                    .into(holder.mImageView);
        }


    }

    private static DiffUtil.ItemCallback<UsersList.UserData> DIFF_CALLBACK =
            new DiffUtil.ItemCallback<UsersList.UserData>() {
                @Override
                public boolean areItemsTheSame(@NonNull UsersList.UserData oldItem, @NonNull UsersList.UserData newItem) {
                    return oldItem.id == newItem.id;
                }

                @SuppressLint("DiffUtilEquals")
                @Override
                public boolean areContentsTheSame(@NonNull UsersList.UserData oldItem, @NonNull UsersList.UserData newItem) {
                    return oldItem.equals(newItem);
                }
            };

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView mUserName;
        ImageView mImageView;

        public MyViewHolder(View itemView) {
            super(itemView);

            mUserName = itemView.findViewById(R.id.user_name);
            mImageView = itemView.findViewById(R.id.imageView);

        }
    }
}

