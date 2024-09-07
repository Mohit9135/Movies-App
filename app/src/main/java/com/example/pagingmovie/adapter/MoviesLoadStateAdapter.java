package com.example.pagingmovie.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.paging.LoadState;
import androidx.paging.LoadStateAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pagingmovie.R;
import com.example.pagingmovie.databinding.LoadStateItemBinding;
import com.example.pagingmovie.model.Movie;

public class MoviesLoadStateAdapter extends LoadStateAdapter<MoviesLoadStateAdapter.LoadStateviewHolder> {


    private View.OnClickListener mRetryCallback;
    public MoviesLoadStateAdapter(View.OnClickListener mRetryCallback){
        this.mRetryCallback=mRetryCallback;
    }

    @Override
    public void onBindViewHolder(@NonNull LoadStateviewHolder loadStateviewHolder, @NonNull LoadState loadState) {
        loadStateviewHolder.bind(loadState);
    }

    @NonNull
    @Override
    public LoadStateviewHolder onCreateViewHolder(@NonNull ViewGroup parent, @NonNull LoadState loadState) {
        return new LoadStateviewHolder(parent,mRetryCallback);
    }


    public static class LoadStateviewHolder extends RecyclerView.ViewHolder{
        private ProgressBar mProgressBar;
        private TextView mErrorMsg;
        private Button mRetry;

        public LoadStateviewHolder(@NonNull ViewGroup parent, @NonNull View.OnClickListener retryCallback) {
            super(LayoutInflater.from(parent.getContext()).inflate(
                    R.layout.load_state_item,parent,false
            ));
            LoadStateItemBinding binding = LoadStateItemBinding.bind(itemView);
            mProgressBar= binding.progressBar;
            mErrorMsg = binding.errorMsg;
            mRetry = binding.retryButton;
            mRetry.setOnClickListener(retryCallback);
        }
        public void bind(LoadState loadState){
            if(loadState instanceof LoadState.Error){
                LoadState.Error loadStateError = (LoadState.Error) loadState;
                mErrorMsg.setText(loadStateError.getError().getLocalizedMessage());
            }
            mProgressBar.setVisibility(loadState instanceof LoadState.Loading ?View.VISIBLE:View.GONE);
            mRetry.setVisibility(loadState instanceof LoadState.Error ?View.VISIBLE:View.GONE);
            mErrorMsg.setVisibility(loadState instanceof LoadState.Error ?View.VISIBLE:View.GONE);
        }
    }

}























