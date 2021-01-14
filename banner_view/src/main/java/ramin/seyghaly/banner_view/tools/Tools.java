package ramin.seyghaly.banner_view.tools;

import android.content.Context;
import android.util.TypedValue;

import androidx.annotation.ColorRes;
import androidx.core.content.ContextCompat;

public class Tools {

    public static int convertSptoPixel(Context context,float sp) {
        if (context != null) {
            return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, sp, context.getResources().getDisplayMetrics());
        }else {
            return 0;
        }
    }

    public static int getColor(Context context,@ColorRes int colorId) {
        if (context != null) {
            return ContextCompat.getColor(context, colorId);
        }else {
            return 0;
        }
    }

}
