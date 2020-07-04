package com.noah.library.list;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;


/**
 * VER_3 LukaCardViewLayoutManager 버전 업데이트
 * VER_7 static > 객체화로 변경
 * LukaCardViewLayoutManager 라이브러리 업그레이드 개선
 * 리니어, 그리드, 스태거를 선택 가능
 * 싱글용, 오토용 선택 가능 추가
 * Created by luka on 2017-12-22.
 * 카드뷰의 디자인 레이아웃을 변경한다.
 * 1 = linear, 2 = Grid, 3 = Stagger
 */

public class CodeLukaCardViewLayoutManager {

    private static final String TAG = CodeLukaCardViewLayoutManager.class.getSimpleName();
    private volatile static CodeLukaCardViewLayoutManager instance;
    private RecyclerView rcView;
    private Context context;

    public interface RecyclerCallback{
        void call();
    }
    /**
     * VER_7 인스턴스 사용으로 메모리 최적화
     * 코드의 중복을 막기 위해 재생성되는 new 클래스를 줄임
     * 생성된 클래스가 있을 경우에는 new로 생성하지 않고 없을 경우에만 생성
     * getInstance()를 하고나서 init()을 사용해서 뷰와 콘텍스트를 추가한다.
     * @return instance
     */
    public static CodeLukaCardViewLayoutManager getInstance() {
        if (instance == null) {
            synchronized (CodeLukaCardViewLayoutManager.class) {
                if (instance == null) {
                    instance = new CodeLukaCardViewLayoutManager();
                }
            }
        }
        return instance;
    }

    /**
     * VER_7 뷰와 콘텍스트를 한번에 사용하는 생성자 개념
     * getInstance()를 하고난 직후 연결해서 사용
     * 코드의 중복을 줄여서 매개변수를 더욱 줄일 수 있게 됨
     * @param rcView RecyclerView
     * @param context Context
     */
    public void init(RecyclerView rcView, Context context) {
        this.rcView = rcView;
        this.context = context;
    }

    /**
     * 리니어 레이아웃 전용
     */
    public void setLinearLayoutManager() {
        // use a linear layout manager
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(context);
        rcView.setLayoutManager(mLayoutManager);
    }

    /**
     * VER_4 호리존탈 리니어 뷰 추가
     * setLinearLayoutManager(true)일 경우 수평 리니어 동작
     * false의 경우 기본 수직 리니어 동작
     *
     * @param horizontal 호리존탈 사용
     */
    public void setLinearLayoutManager(boolean horizontal) {
        if (horizontal) {
             /* 수평 레이아웃 */
            LinearLayoutManager horizontalLayoutManager = new LinearLayoutManager(context);
            horizontalLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
            rcView.setLayoutManager(horizontalLayoutManager);
        } else {
             /* 수직 레이아웃 */
            setLinearLayoutManager();
        }
    }

    /**
     * 그리드 레이아웃 전용
     */
    public void setGridLayoutManager(int row) {
        // use a grid layout manager
        GridLayoutManager mGridLayoutManager = new GridLayoutManager(context, row);
        rcView.setLayoutManager(mGridLayoutManager);
    }

    /**
     * 스태거 그리드 레이아웃 전용
     */
    public void setStaggerLayoutManager(int row) {
        // use a staggered grid layout manager
        StaggeredGridLayoutManager mStaggeredGridLayoutManager = new StaggeredGridLayoutManager(row, StaggeredGridLayoutManager.VERTICAL);
        rcView.setLayoutManager(mStaggeredGridLayoutManager);
    }

    /**
     * 싱글 레이아웃 > 리니어로 자동
     *
     */
    public void setSingleLayoutManager() {
        // use a linear layout manager
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(context);
        rcView.setLayoutManager(mLayoutManager);
    }

    /**
     * 오토 레이아웃
     * 리스트의 개수가 1개 이하일 경우 리니어레이아웃 사용
     * 리스트의 개수가 2개 이상일 경우 스태거를 사용하며 row는 2개 사용한다.
     *
     * @param listSize 리스트의 개수를 가져온다. size()
     */
    public void setAutoLayoutManager(int listSize) {
        if (listSize > 1) {
            // use a staggered grid layout manager
            StaggeredGridLayoutManager mStaggeredGridLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
            rcView.setLayoutManager(mStaggeredGridLayoutManager);
        } else {
            // use a linear layout manager
            LinearLayoutManager mLayoutManager = new LinearLayoutManager(context);
            rcView.setLayoutManager(mLayoutManager);
        }
    }

    /**
     * VER_6 리스트의 순서를 반대로 보여준다.
     * 리스트의 개수를 받아서 역순으로 재배열 한다.
     *
     * @param listSize 리스트의 개수
     */
    public void setReversePosition(int listSize) {
        rcView.scrollToPosition(listSize - 1);
    }

    /**
     * 구버전
     *
     * @param rcView  리사이클러뷰를 가져온다.
     * @param i       1 = linear, 2 = Grid, 3= Stagger
     * @param context 콘텍스트를 가져온다.
     */
    public void setLayoutManager(RecyclerView rcView, int i, Context context) {
        if (i == 0) {
            rcView.setLayoutManager(new LinearLayoutManager(context));
            // use a linear layout manager
            LinearLayoutManager mLayoutManager = new LinearLayoutManager(context);
            rcView.setLayoutManager(mLayoutManager);

        } else if (i == 1) {
            // use a grid layout manager
            GridLayoutManager mGridLayoutManager = new GridLayoutManager(context, 2);
            rcView.setLayoutManager(mGridLayoutManager);
        } else {
            // use a staggered grid layout manager
            StaggeredGridLayoutManager mStaggeredGridLayoutManager = new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL);
            rcView.setLayoutManager(mStaggeredGridLayoutManager);
        }
    }

    /**
     * VER_6 스냅 모드 추가
     *
     * @param rcView 리사이클러뷰
     */
    public void setSnap(RecyclerView rcView) {
        SnapHelper snapHelper = new LinearSnapHelper();
        snapHelper.attachToRecyclerView(rcView);
    }

    /**
     * 스크롤 페이징
     * 마지막 스크롤위치가 전체 수와 일치하면 callback 호출
     * @param rv
     * @param callback 페이징 이벤트 코드 추가
     */
    public void paging(RecyclerView rv,final RecyclerCallback callback){
        rv.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

                int lastPosition = ((LinearLayoutManager) recyclerView.getLayoutManager()).findLastCompletelyVisibleItemPosition();
                int totalCount = recyclerView.getAdapter().getItemCount()-1;

                if(lastPosition == totalCount){

                    callback.call();
                }
            }
        });
    }
}
