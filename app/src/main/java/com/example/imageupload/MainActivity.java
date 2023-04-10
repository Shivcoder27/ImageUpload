package com.example.imageupload;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
ImageView main_image,dailog_image1,dailog_image2,f1,f2,f3,f4,main_img2;
Button btn_choose_img;
int GALLERY_REQUEST_CODE = 100;
Uri uri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        main_image = findViewById(R.id.main_imageView);
        btn_choose_img = findViewById(R.id.btn_image);
        main_img2 = findViewById(R.id.main_imageView2);
/////////////////////////////////////////////////////////////////////////////////////
        LayoutInflater inflater = LayoutInflater.from(this);
        View dialogLayout = inflater.inflate(R.layout.dailog_option, null);
        ImageView imageView2 = dialogLayout.findViewById(R.id.dialog_image2);
///////////////////////////////////////////////////////////////////////////////////
       btn_choose_img.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               showGalleryDialog();
           }
       });

    }
    private void showGalleryDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Select Image");
        builder.setItems(new CharSequence[]{"Gallery"}, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                switch (which) {
                    case 0:
                        Intent galleryIntent = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                        startActivityForResult(galleryIntent, GALLERY_REQUEST_CODE);

                        break;
                }
            }
        });
        builder.show();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == GALLERY_REQUEST_CODE && resultCode == RESULT_OK) {
            if (data != null) {
                Uri selectedImageUri = data.getData();
                if (selectedImageUri != null) {
                    dailog_image2.setImageURI(selectedImageUri);
                    main_image.setImageURI(selectedImageUri);
                }
            }
        }
    }
////////////////////////////////////////////////////////////////////////////////////////
    //handling dailog box activity
//    public void showImageDialog() {
//        // inflate the dialog layout
//        LayoutInflater inflater = LayoutInflater.from(this);
//        View dialogLayout = inflater.inflate(R.layout.dailog_option, null);
//
//        // find the ImageView by its ID
//        ImageView imageView1 = dialogLayout.findViewById(R.id.dialog_image_view1);
//        ImageView imageView2 = dialogLayout.findViewById(R.id.dialog_image2);
//
//
//        ImageView f1 = dialogLayout.findViewById(R.id.frame_image_view_1);
//        ImageView f2 = dialogLayout.findViewById(R.id.frame_image_view_2);
//        ImageView f3 = dialogLayout.findViewById(R.id.frame_image_view_3);
//        ImageView f4 = dialogLayout.findViewById(R.id.frame_image_view_4);
//
//        f1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                imageView1.setImageResource(R.drawable.user_image_frame_1);
//                imageView1.setZ(1);
//                imageView1.setAlpha(0.8f);
//               main_img2.setImageResource(R.drawable.user_image_frame_1);
//            }
//        });
//        f2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                imageView1.setImageResource(R.drawable.user_image_frame_2);
//                imageView1.setZ(1);
//                imageView1.setAlpha(0.8f);
//                main_img2.setImageResource(R.drawable.user_image_frame_1);
//            }
//        });
//        f3.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                imageView1.setImageResource(R.drawable.user_image_frame_3);
//                imageView1.setZ(1);
//                imageView1.setAlpha(0.8f);
//                main_img2.setImageResource(R.drawable.user_image_frame_1);
//            }
//        });
//        f4.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                imageView1.setImageResource(R.drawable.user_image_frame_4);
//                imageView1.setZ(1);
//                imageView1.setAlpha(0.8f);
//                main_img2.setImageResource(R.drawable.user_image_frame_1);
//            }
//        });
//
//        // display the dialog with the inflated layout
//        AlertDialog.Builder builder = new AlertDialog.Builder(this);
//        builder.setView(dialogLayout);
//        builder.show();
//    }


}