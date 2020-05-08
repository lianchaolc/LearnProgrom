package activity.ljsw.com.leanprogrom.activity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import activity.ljsw.com.leanprogrom.R;
import activity.ljsw.com.leanprogrom.viewutils.view.CropImageView;

/****
 * 图片剪裁
 */
public class CropImageView2Activity extends AppCompatActivity {
private  CropImageView  crop_imageView;
    private Button cropOk;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crop_image_view2);
        crop_imageView= (CropImageView) findViewById(R.id.activity_crop_image_view);
        crop_imageView.setImageResource(R.drawable.timg);
        cropOk= (Button) findViewById(R.id.cropOk);
        cropOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bitmap cropBitMap = crop_imageView.getCroppedImage();
                crop_imageView.setImageBitmap(cropBitMap);
            }
        });

    }
}
