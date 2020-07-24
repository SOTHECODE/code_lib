package com.noah.library.lib.noah;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;

import androidx.databinding.ViewDataBinding;


public class Code_NoahDialog {

    Context mContext;

    // layout data binding
    ViewDataBinding mBinding;

    public interface DialogdCallback<T> {
        void view();

        void event();
    }

    private DialogdCallback callback;

    private Dialog dlg;

    /**
     * 콜백과 화면을 넣고 다양하게 사용가능한 다이얼로그
     *
     * @param context
     * @param callback 화면 컨트롤
     * @param binding  데이터 바인딩
     */
    public Code_NoahDialog(Context context, DialogdCallback callback, ViewDataBinding binding) {
        this.mContext = context;
        this.callback = callback;
        mBinding = binding;
    }


    /**
     * 호출할 다이얼로그 함수를 정의한다.
     * DataBindingUtil.inflate(LayoutInflater.from(mContext), layout, null, false)
     */
    public void callFunction() {

        // 커스텀 다이얼로그를 정의하기위해 Dialog클래스를 생성한다.
        dlg = new Dialog(mContext);

        dlg.setContentView(mBinding.getRoot());
        dlg.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));


        // 커스텀 다이얼로그를 노출한다.
        dlg.show();

        callback.view();
        callback.event();


    }

    public Dialog getDlg() {
        return dlg;
    }


}
