package com.huangshan.demo.ui.adapter;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.huangshan.demo.R;
import com.huangshan.demo.bean.Movie;
import com.huangshan.demo.utils.Tools;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

/**
 * Author(s): danyun
 * Date: 2017/4/30
 */
public class MovieAdapter extends BaseAdapter {

    private final Context mContext;
    private LayoutInflater mInflater;
    private final List<Movie> mMovieList;

    public MovieAdapter(Context context, List<Movie> movieList) {
        this.mContext = context;
        this.mMovieList = movieList;
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return mMovieList.size();
    }

    @Override
    public Movie getItem(int position) {
        return mMovieList.get(position);
    }

    @Override
    public long getItemId(int position) {
        Movie movie = mMovieList.get(position);
        String imdbId = movie.getImdbId();
        imdbId = imdbId.substring(0, 2);
        return Long.parseLong(imdbId);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final MovieHolder holder;
        if (convertView == null) {
            holder = new MovieHolder();
            convertView = mInflater.inflate(R.layout.adapter_l33_movies, parent, false);
            holder.mTitleTextView = (TextView) convertView.findViewById(R.id.l33_tv_title);
            holder.mYearTextView = (TextView) convertView.findViewById(R.id.l33_tv_year);
            holder.mPosterImageView = (ImageView) convertView.findViewById(R.id.l33_iv_poster);
            convertView.setTag(holder);
        } else {
            holder = (MovieHolder) convertView.getTag();
        }

        final Movie movie = mMovieList.get(position);
        holder.mTitleTextView.setText(movie.getTitle());
        holder.mYearTextView.setText(movie.getYear());
        handlePoster(holder.mPosterImageView, movie);
        return convertView;
    }

    /**
     * 通过判断 movie 对象中的 bitmap 属性，只进行一次图片下载
     * 在图片未下载时，展示默认图
     */
    private void handlePoster(final ImageView imageView, final Movie movie) {
        if (movie.getPosterBitmap() == null) {
            imageView.setImageResource(R.mipmap.ic_launcher);
            final String urlAddress = movie.getPosterUrl();
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        // 下载图片数据
                        final Bitmap bitmap = downloadPoster(urlAddress);
                        // 把下载到的图片放入 movie 对象
                        movie.setPosterBitmap(bitmap);
                        // 将图片绑定到 imageView 控件上
                        bindBitmap(imageView, bitmap);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        } else {
            imageView.setImageBitmap(movie.getPosterBitmap());
        }
    }

    private void bindBitmap(final ImageView imageView, final Bitmap bitmap) {
        if (bitmap != null) {
            if (mContext instanceof Activity) {
                Activity activity = (Activity) mContext;
                activity.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        imageView.setImageBitmap(bitmap);
                    }
                });
            }
        }
    }

    private Bitmap downloadPoster(String urlAddress) throws IOException {
        urlAddress = urlAddress.replace("300.jpg", "100.jpg");
        Tools.debug("downloadPoster, url: " + urlAddress);
        URL url = new URL(urlAddress);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setConnectTimeout(10 * 1000);
        conn.setDoInput(true);
        int responseCode = conn.getResponseCode();
        if (responseCode == 200) {
            InputStream in = null;
            try {
                in = conn.getInputStream();
                byte[] buffer = new byte[1024];
                int length;
                ByteArrayOutputStream out = new ByteArrayOutputStream();
                while ((length = in.read(buffer)) != -1) {
                    out.write(buffer, 0, length);
                }
                byte[] bytes = out.toByteArray();
                return BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (in != null) {
                    try {
                        in.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return null;
    }

    private class MovieHolder {
        TextView mTitleTextView;
        TextView mYearTextView;
        ImageView mPosterImageView;
    }

}
