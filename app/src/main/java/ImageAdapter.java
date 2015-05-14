import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

/**
 * Created by Administrator on 2015/4/4.
 */
public class ImageAdapter extends BaseAdapter {
    private Context mContext;
    private Integer[] miImgArr;
    
    @Override
    public int getCount(){
        return miImgArr.length;
    };

    @Override
    public Object getItem(int position){
        return null;
    };

    @Override
    public long getItemId(int position){
        return 0;
    };

    @Override
    public View getView(int position,View convertView,ViewGroup parent){
        ImageView v;
        if(convertView==null){
            v=new ImageView(mContext);
            v.setLayoutParams(new GridView.LayoutParams(90,90));
            v.setScaleType(ImageView.ScaleType.CENTER_CROP);
            v.setPadding(10,10,10,10);
        }else{
            v=(ImageView) convertView;
        }
        v.setImageResource(miImgArr[position]);
        return v;
    };

}
