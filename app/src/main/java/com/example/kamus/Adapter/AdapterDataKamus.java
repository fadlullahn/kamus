package com.example.kamus.Adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.kamus.Config;
import com.example.kamus.Model.Kamus.Kamus;
import com.example.kamus.KamusDetailActivity;
import com.example.kamus.R;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AdapterDataKamus extends RecyclerView.Adapter<AdapterDataKamus.MyViewHolder> {
    List<Kamus> mHerosList;
    private List<Kamus> mHerosListFull;
    public AdapterDataKamus(List<Kamus> HerosList) {
        mHerosList = HerosList;
        mHerosListFull = new ArrayList<>(HerosList);
        sortList(mHerosListFull); // Sort the list for binary search
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View mView = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_item_kamus, parent, false);
        MyViewHolder mViewHolder = new MyViewHolder(mView);
        return mViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {

        holder.mTextViewName.setText(mHerosList.get(position).getName());
        holder.mTextViewDeskripsi.setText(mHerosList.get(position).getDeskripsi());
        holder.mTextViewIlmiah.setText(mHerosList.get(position).getIlmiah());

        Glide.with(holder.itemView.getContext())
                .load(Config.IMAGES_URL + mHerosList.get(position).getImage())
                .apply(new RequestOptions().override(350, 350))
                .into(holder.mImageViewFoto);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mIntent;

                mIntent = new Intent(view.getContext(), KamusDetailActivity.class);

                mIntent.putExtra("Id", mHerosList.get(position).getId());
                mIntent.putExtra("Name", mHerosList.get(position).getName());
                mIntent.putExtra("Ilmiah", mHerosList.get(position).getIlmiah());
                mIntent.putExtra("Deskripsi", mHerosList.get(position).getDeskripsi() );
                mIntent.putExtra("Image", mHerosList.get(position).getImage());
                view.getContext().startActivity(mIntent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mHerosList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView mTextViewName, mTextViewIlmiah, mTextViewDeskripsi;
        public ImageView mImageViewFoto;

        public MyViewHolder(View itemView) {
            super(itemView);
            mTextViewName = (TextView) itemView.findViewById(R.id.tv_item_name);
            mTextViewIlmiah = (TextView) itemView.findViewById(R.id.tv_item_ilmiah);
            mTextViewDeskripsi = (TextView) itemView.findViewById(R.id.tv_item_deskripsi);
            mTextViewDeskripsi.setVisibility(View.GONE);
            mImageViewFoto = itemView.findViewById(R.id.img_item_photo);
            mImageViewFoto.setVisibility(View.GONE);
        }
    }

    public void filter(String text) {
        List<Kamus> filteredList = binarySearch(text);
        mHerosList.clear();
        mHerosList.addAll(filteredList);
        notifyDataSetChanged();
    }

    private List<Kamus> binarySearch(String query) {
        List<Kamus> result = new ArrayList<>();
        int low = 0;
        int high = mHerosListFull.size() - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            Kamus midItem = mHerosListFull.get(mid);
            int comparison = midItem.getName().compareToIgnoreCase(query);

            if (comparison == 0) {
                result.add(midItem);
                // Add items around the found item
                int left = mid - 1;
                while (left >= 0 && mHerosListFull.get(left).getName().equalsIgnoreCase(query)) {
                    result.add(mHerosListFull.get(left));
                    left--;
                }
                int right = mid + 1;
                while (right < mHerosListFull.size() && mHerosListFull.get(right).getName().equalsIgnoreCase(query)) {
                    result.add(mHerosListFull.get(right));
                    right++;
                }
                break;
            } else if (comparison < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return result;
    }

    private void sortList(List<Kamus> list) {
        Collections.sort(list, (k1, k2) -> k1.getName().compareToIgnoreCase(k2.getName()));
    }


}