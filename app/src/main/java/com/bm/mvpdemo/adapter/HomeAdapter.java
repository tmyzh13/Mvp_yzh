package com.bm.mvpdemo.adapter;

import android.text.Html;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bm.mvpdemo.R;
import com.bm.mvpdemo.bean.ArticleBean;
import com.bm.mvpdemo.utils.ImageLoader;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

public class HomeAdapter extends BaseQuickAdapter<ArticleBean,BaseViewHolder> {

    private OnCollectViewClickListener listener;

    public HomeAdapter(){
        super(R.layout.rv_item_article);
    }

    public void setOnCollectViewClickListener(OnCollectViewClickListener listener){
        this.listener=listener;
    }

    @Override
    protected void convert(BaseViewHolder helper, ArticleBean item) {
        helper.setText(R.id.tv_title,Html.fromHtml(item.getTitle()));
        helper.setText(R.id.tv_autor,item.getAuthor());
        helper.setText(R.id.tv_time,item.getNiceDate());
        helper.setText(R.id.tv_super_chapter_name,item.getSuperChapterName());
        helper.setText(R.id.tv_chapter_name,item.getChapterName());
        TextView tv_new =helper.getView(R.id.tv_new);
        if(item.isFresh()){
            tv_new.setVisibility(View.VISIBLE);
        }else{
            tv_new.setVisibility(View.GONE);
        }
        ImageView iv_img =helper.getView(R.id.iv_img);
        if(!TextUtils.isEmpty(item.getEnvelopePic())){
            ImageLoader.image(iv_img, item.getEnvelopePic());
            iv_img.setVisibility(View.VISIBLE);
        }else{
            iv_img.setVisibility(View.GONE);
        }
        TextView tv_tag = helper.getView(R.id.tv_tag);
        if (item.getTags() != null && item.getTags().size() > 0) {
            tv_tag.setText(item.getTags().get(0).getName());
            tv_tag.setVisibility(View.VISIBLE);
        } else {
            tv_tag.setVisibility(View.GONE);
        }

    }

    public interface OnCollectViewClickListener{
        void onClick(BaseViewHolder helper,View view,int position);
    }
}
