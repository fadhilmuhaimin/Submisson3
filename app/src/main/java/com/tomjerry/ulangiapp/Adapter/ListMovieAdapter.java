//package com.tomjerry.ulangiapp.Adapter;
//
//import android.content.Context;
//import android.content.UriMatcher;
//import android.net.Uri;
//import android.support.v7.widget.RecyclerView;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.ImageButton;
//import android.widget.ImageView;
//import android.widget.TextView;
//import android.widget.Toast;
//
//import com.bumptech.glide.Glide;
//import com.tomjerry.ulangiapp.MovieList.Movie;
//import com.tomjerry.ulangiapp.MovieList.Result;
//import com.tomjerry.ulangiapp.R;
//
//import java.util.ArrayList;
//
//public class ListMovieAdapter  extends RecyclerView.Adapter<ListMovieAdapter.ListViewHolder>{
//    private ArrayList<Result> listMovie ;
//    private Context context;
//
//    private OnDetailClick onDetailClick;
//
//    public ListMovieAdapter(ArrayList<Result> listMovie) {
//        this.listMovie = listMovie;
//    }
////
////    private ArrayList<Result> getListMovie(){
////        return listMovie;
////    }
////    public ListMovieAdapter(Context context) {
////        this.context = context;
////    }
//
////    public void setListMovieAdapter(ArrayList<Result> listMovie) {
////
////        this.listMovie = listMovie;
////
////    }
//
//    @Override
//    public ListViewHolder onCreateViewHolder( ViewGroup viewGroup, int position) {
//        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_fragment, viewGroup, false);
//        this.context = viewGroup.getContext();
//        return new ListViewHolder(view);
//    }
//
//    @Override
//    public void onBindViewHolder(final ListViewHolder holder, final int position) {
//        Uri gambar = Uri.parse("https://image.tmdb.org/t/p/w342" + listMovie.get(position).getPosterPath());
//        final Result movie = listMovie.get(position);
//        Glide.with(context)
//                .load(gambar)
////                .apply(new RequestOptions().override(55, 55))
//                .into(holder.imgPhoto);
//        holder.tvName.setText(listMovie.get(position).getTitle());
//        holder.view.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                onDetailClick.onClick(movie);
//            }
//        });
//        holder.btnFavorite.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(holder.itemView.getContext(), "Kamu Menyukai " + listMovie.get(holder.getAdapterPosition()).getTitle(), Toast.LENGTH_SHORT).show();
//            }
//        });
//        holder.btnUnlike.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(holder.itemView.getContext(), "Kamu Tidak Menyukai " + listMovie.get(holder.getAdapterPosition()).getTitle(), Toast.LENGTH_SHORT).show();
//            }
//        });
//        holder.btnLike.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(holder.itemView.getContext(), "Kamu Menyukai " + listMovie.get(holder.getAdapterPosition()).getTitle(), Toast.LENGTH_SHORT).show();
//            }
//        });
//    }
//
//    @Override
//    public int getItemCount() {
//        return (listMovie!=null)?listMovie.size():0;
//    }
//
//    public class ListViewHolder extends RecyclerView.ViewHolder {
//        ImageButton btnLike, btnUnlike,btnFavorite;
//        ImageView imgPhoto;
//        public View view;
//        TextView tvName;
//        public ListViewHolder( View itemView) {
//            super(itemView);
//            imgPhoto = itemView.findViewById(R.id.img_photo);
//            tvName = itemView.findViewById(R.id.txt_name);
////            btnFavorite = itemView.findViewById(R.id.favorite);
////            btnLike = itemView.findViewById(R.id.like);
////            btnUnlike = itemView.findViewById(R.id.unlike);
//            this.view = itemView;
//        }
//    }
//    public interface OnDetailClick{
//        void onClick(Result movie);
//    }
//
//    public void  setOnDetailClick (OnDetailClick onDetailClick){
//        this.onDetailClick = onDetailClick;
//    }
//}
