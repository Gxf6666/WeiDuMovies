package com.bawei.weidumovie.view.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.baidu.location.BDLocationListener;
import com.bawei.weidumovie.R;
import com.bawei.weidumovie.model.bean.Banners;
import com.bawei.weidumovie.model.bean.Home;
import com.bawei.weidumovie.model.bean.HomeOne;
import com.bawei.weidumovie.model.bean.Request;
import com.bawei.weidumovie.presenter.BannerPresente;
import com.bawei.weidumovie.presenter.HomePresenter;
import com.bawei.weidumovie.presenter.HomePresenter1;
import com.bawei.weidumovie.presenter.HomePresenter2;
import com.bawei.weidumovie.testlocation.BDLocationUtils;
import com.bawei.weidumovie.view.adpater.HomeMAdapter;
import com.bawei.weidumovie.view.adpater.HomeMAdapter1;
import com.bawei.weidumovie.view.adpater.HomeMAdapter2;
import com.bawei.weidumovie.view.consion.DataCall;
import com.bumptech.glide.Glide;
import com.stx.xhb.xbanner.XBanner;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * <p>文件描述：<p>
 * <p>作者：染<p>
 * <p>创建时间：2019/11/7<p>
 * <p>更改时间：2019/11/7<p>
 */
public class FilmFragment extends Fragment {
    TextView mLocation;
    Unbinder unbinder;
    private XBanner xbanner;
    private RecyclerView recycler_reying;
    private RecyclerView recycler_shangying;
    private ImageView rv_remen1;
    private TextView popularname_tv;
    private TextView popularscore_tv;
    private Button releasedmovie_bt;
    private RecyclerView recycler_remen;
    private BannerPresente bannerPresente;
    private HomePresenter homePresenter;
    private HomeMAdapter homeMAdapter, homeMAdapter2;
    private HomeMAdapter1 homeMAdapter1;
    private HomePresenter1 homePresenter1;
    private HomePresenter2 homePresenter2;
    private HomeMAdapter2 homeMAdapter3;
    private Boolean locationboolean=true;
    private BDLocationUtils bdLocationUtils;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.fragment_film, null);
        initView(view);

        mLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (locationboolean){
                   bdLocationUtils = new BDLocationUtils(getContext());
                   bdLocationUtils.doLocation();
                   bdLocationUtils.mLocationClient.start();
                    locationboolean=false;
                }else {
                    bdLocationUtils.mLocationClient.stop();
                    locationboolean=true;
                }
            }
        });

        //正在热映
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recycler_reying.setLayoutManager(linearLayoutManager);
        //正在热映适配器
        homeMAdapter = new HomeMAdapter(getContext());
        recycler_reying.setAdapter(homeMAdapter);

        //即将上映
        LinearLayoutManager linearLayoutManager1 = new LinearLayoutManager(getContext());
        linearLayoutManager1.setOrientation(LinearLayoutManager.VERTICAL);
        recycler_shangying.setLayoutManager(linearLayoutManager1);

        //即将上映适配器
        homeMAdapter1 = new HomeMAdapter1(getContext());
        recycler_shangying.setAdapter(homeMAdapter1);
        //热门电影
        LinearLayoutManager linearLayoutManager2 = new LinearLayoutManager(getContext());
        linearLayoutManager2.setOrientation(LinearLayoutManager.HORIZONTAL);
        recycler_remen.setLayoutManager(linearLayoutManager2);
        //热门电影适配器
        homeMAdapter2 = new HomeMAdapter(getContext());
        recycler_remen.setAdapter(homeMAdapter2);


        //Banner轮播
        bannerPresente = new BannerPresente(new BannersPresen());
        bannerPresente.Request();
        //正在热映Presenter
        homePresenter = new HomePresenter(new HomePresen());
        homePresenter.Request(1, 5);
        //即将上映Presenter
        homePresenter1 = new HomePresenter1(new HomePresenOne());
        homePresenter1.Request(1, 4);
        //热门电影Presenter
        homePresenter2 = new HomePresenter2(new HomePresenTwo());
        homePresenter2.Request(1, 5);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    private void initView(View view) {
        xbanner = (XBanner) view.findViewById(R.id.xbanner);
        recycler_reying = (RecyclerView) view.findViewById(R.id.recycler_reying);
        recycler_shangying = (RecyclerView) view.findViewById(R.id.recycler_shangying);
        rv_remen1 = view.findViewById(R.id.rv_remen1);
        popularname_tv = (TextView) view.findViewById(R.id.popularname_tv);
        popularscore_tv = (TextView) view.findViewById(R.id.popularscore_tv);
        releasedmovie_bt = (Button) view.findViewById(R.id.releasedmovie_bt);
        recycler_remen = (RecyclerView) view.findViewById(R.id.recycler_remen);
        mLocation=(TextView)view.findViewById(R.id.location);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }


    private class BannersPresen implements DataCall<List<Banners>> {
        @Override
        public void Success(final List<Banners> data) {

            xbanner.setData(data, null);
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

    /**
     * 正在热映
     */

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

    /**
     * 即将上映
     */
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

    /**
     * 热门电影
     */
    private class HomePresenTwo implements DataCall<List<Home>> {
        @Override
        public void Success(List<Home> data) {
            homeMAdapter2.addAll(data);
            homeMAdapter2.notifyDataSetChanged();
            Glide.with(getActivity()).load(data.get(0).imageUrl).into(rv_remen1);
        }

        @Override
        public void Error(Request request) {

        }
    }

}
