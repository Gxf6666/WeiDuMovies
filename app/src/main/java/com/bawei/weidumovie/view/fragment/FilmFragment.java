package com.bawei.weidumovie.view.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bawei.weidumovie.R;
import com.bawei.weidumovie.model.bean.Banners;
import com.bawei.weidumovie.model.bean.Home;
import com.bawei.weidumovie.model.bean.HomeOne;
import com.bawei.weidumovie.model.bean.Request;
import com.bawei.weidumovie.presenter.BannerPresente;
import com.bawei.weidumovie.presenter.HomePresenter;
import com.bawei.weidumovie.presenter.HomePresenter1;
import com.bawei.weidumovie.view.adpater.HomeMAdapter;
import com.bawei.weidumovie.view.adpater.HomeMAdapter1;
import com.bawei.weidumovie.view.consion.DataCall;
import com.bumptech.glide.Glide;
import com.stx.xhb.xbanner.XBanner;


import java.util.List;

/**
 * <p>文件描述：<p>
 * <p>作者：染<p>
 * <p>创建时间：2019/11/7<p>
 * <p>更改时间：2019/11/7<p>
 */
public class FilmFragment extends Fragment {
    private XBanner xbanner;
    private RecyclerView recycler_reying;
    private RecyclerView recycler_shangying;
    private ImageView iv_remenyindao;
    private TextView popularname_tv;
    private TextView popularscore_tv;
    private Button releasedmovie_bt;
    private RecyclerView recycler_remen;
    private BannerPresente bannerPresente;
    private HomePresenter homePresenter;
    private HomeMAdapter homeMAdapter;
    private HomeMAdapter1 homeMAdapter1;
    private HomePresenter1 homePresenter1;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.fragment_film, null);
        initView(view);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recycler_reying.setLayoutManager(linearLayoutManager);

        homeMAdapter = new HomeMAdapter(getContext());
        recycler_reying.setAdapter(homeMAdapter);


        LinearLayoutManager linearLayoutManager1 = new LinearLayoutManager(getContext());
        linearLayoutManager1.setOrientation(LinearLayoutManager.VERTICAL);
        recycler_shangying.setLayoutManager(linearLayoutManager1);


        homeMAdapter1 = new HomeMAdapter1(getContext());
        recycler_shangying.setAdapter(homeMAdapter1);


        bannerPresente = new BannerPresente(new BannersPresen());
        bannerPresente.Request();
        homePresenter = new HomePresenter(new HomePresen());
        homePresenter.Request(1,5);
        homePresenter1 = new HomePresenter1(new HomePresenOne());
        homePresenter1.Request(1,4);
        return view;
    }

    private void initView(View view) {
        xbanner = (XBanner) view.findViewById(R.id.xbanner);
        recycler_reying = (RecyclerView) view.findViewById(R.id.recycler_reying);
        recycler_shangying = (RecyclerView) view.findViewById(R.id.recycler_shangying);
        iv_remenyindao = (ImageView) view.findViewById(R.id.iv_remenyindao);
        popularname_tv = (TextView) view.findViewById(R.id.popularname_tv);
        popularscore_tv = (TextView) view.findViewById(R.id.popularscore_tv);
        releasedmovie_bt = (Button) view.findViewById(R.id.releasedmovie_bt);
        recycler_remen = (RecyclerView) view.findViewById(R.id.recycler_remen);

    }


    private class BannersPresen implements DataCall<List<Banners>> {
        @Override
        public void Success(final List<Banners> data) {

            xbanner.setData(data,null);
            xbanner.setmAdapter(new XBanner.XBannerAdapter() {
                @Override
                public void loadBanner(XBanner banner, View view, int position) {
                    Glide.with(getActivity()).load(data.get(position).imageUrl).into((ImageView) view);
                }
            });
        }

        @Override
        public void Error(Request request) {

        }
    }

    private class HomePresen implements DataCall<List<Home>> {
        @Override
        public void Success(List<Home> data) {
                homeMAdapter.addAll(data);

                homeMAdapter.notifyDataSetChanged();
        }

        @Override
        public void Error(Request request) {

        }
    }

    private class HomePresenOne implements DataCall<List<HomeOne>> {
        @Override
        public void Success(List<HomeOne> data) {
                homeMAdapter1.addAllOne(data);

                homeMAdapter1.notifyDataSetChanged();

        }

        @Override
        public void Error(Request request) {

        }
    }
}
