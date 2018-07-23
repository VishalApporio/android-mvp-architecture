package com.tukin.user.mvp.ui.activity.profile;

import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TextInputEditText;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.crowdfire.cfalertdialog.CFAlertDialog;
import com.tukin.user.R;
import com.tukin.user.mvp.data.network.ApiEndPoint;
import com.tukin.user.mvp.sampermissionutils.AfterPermissionGranted;
import com.tukin.user.mvp.sampermissionutils.EasyPermissions;
import com.tukin.user.mvp.sampermissionutils.helper.ImageCompressMode;
import com.tukin.user.mvp.ui.activity.profile.changenumber.ChangeNumberActivity;
import com.tukin.user.mvp.ui.base.BaseActivity;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ProfileViewActivity extends BaseActivity implements AppBarLayout.OnOffsetChangedListener, ProfileMvpView {

    @Inject
    ProfileMvpPresenter<ProfileMvpView> mPresenter;

    private static final float PERCENTAGE_TO_SHOW_TITLE_AT_TOOLBAR = 0.9f;
    private static final float PERCENTAGE_TO_HIDE_TITLE_DETAILS = 0.3f;
    private static final int ALPHA_ANIMATIONS_DURATION = 200;

    private boolean mIsTheTitleVisible = false;
    private boolean mIsTheTitleContainerVisible = true;

    @BindView(R.id.mainToolbar)
    Toolbar mToolbar;

    @BindView(R.id.main_textview_title)
    TextView mTitle;

    @BindView(R.id.main_linearlayout_title)
    LinearLayout mTitleContainer;

    @BindView(R.id.main_appbar)
    AppBarLayout mAppBarLayout;

    @BindView(R.id.iv_profile_pic)
    ImageView iv_profile_pic;

    @BindView(R.id.et_first_name)
    TextInputEditText et_first_name;

    @BindView(R.id.et_last_name)
    TextInputEditText et_last_name;

    @BindView(R.id.et_email)
    TextInputEditText et_email;

    @BindView(R.id.et_phone_no)
    TextInputEditText et_phone_no;

    @BindView(R.id.et_password)
    TextInputEditText et_password;

    @BindView(R.id.btn_server_edit)
    Button btn_server_edit;

    @BindView(R.id.btn_server_submit)
    Button btn_server_submit;

    @BindView(R.id.text_header_text)
    TextView text_header_text;

    String str_user_image;
    private static final int RC_CAMERA_PERM = 123;
    private ContentValues values;
    private Bitmap thumbnail;
    private static final int CAMERS_PICKER = 122;
    private Uri imageUri;
    Uri selectedImage;
    Bitmap bitmap1;
    String imagePath = "", imagePathCompressed = "";


    public static Intent getStartIntent(Context context) {
        Intent intent = new Intent(context, ProfileViewActivity.class);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loading_layout);
        bindActivity();
    }

    @Override
    protected void setUp() {

        setUnBinder(ButterKnife.bind(this));

        mAppBarLayout.addOnOffsetChangedListener(this);

        mToolbar.inflateMenu(R.menu.menu_profile);

        mToolbar.setTitle("");
        startAlphaAnimation(mTitle, 0, View.INVISIBLE);

        btn_server_edit.setVisibility(View.VISIBLE);
        btn_server_submit.setVisibility(View.GONE);
        et_first_name.setEnabled(false);
        et_last_name.setEnabled(false);
        et_email.setEnabled(false);
        et_phone_no.setEnabled(false);
        et_password.setEnabled(false);
        et_password.setText("1234567");

        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });


        iv_profile_pic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CFAlertDialog.Builder builder = new CFAlertDialog.Builder(ProfileViewActivity.this);
                builder.setDialogStyle(CFAlertDialog.CFAlertStyle.ALERT);
                builder.setTitle("Upload Profile Picc");
                builder.setItems(new String[]{"Camera", "Gallery"}, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int index) {
                        if (index == 0) {
                            try {
                                cameraTask();
                            } catch (Exception e) {
                            }
                        } else if (index == 1) {

                            Intent intent = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                            startActivityForResult(intent, 101);

                        }
                        dialogInterface.dismiss();
                    }
                });
                builder.show();
            }
        });

    }

    private void bindActivity() {
        setSupportActionBar(mToolbar);
        getActivityComponent().inject(this);
        mPresenter.onAttach(ProfileViewActivity.this);
        mPresenter.onViewProfileDetails();

    }


    @AfterPermissionGranted(RC_CAMERA_PERM)
    public void cameraTask() throws Exception {
        if (EasyPermissions.hasPermissions(this, android.Manifest.permission.CAMERA)) {
            try { // Have permission, do the thing!
                values = new ContentValues();
                values.put(MediaStore.Images.Media.TITLE, "New Picture");
                values.put(MediaStore.Images.Media.DESCRIPTION, "From your Camera");
                imageUri = getContentResolver().insert(
                        MediaStore.Images.Media.EXTERNAL_CONTENT_URI, values);
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                intent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri);
                startActivityForResult(intent, CAMERS_PICKER);
            } catch (Exception e) {
            }
        } else {
            EasyPermissions.requestPermissions(this, "Feature needs to access your device camera", RC_CAMERA_PERM, android.Manifest.permission.CAMERA);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        try {
            cameraTask();
        } catch (Exception e) {
        }
    }

    @OnClick(R.id.btn_server_submit)
    void onServerSubmitClick() {

        Log.e("ImagePathCompressed", "" + imagePathCompressed);

        mPresenter.onClickSubmitButton(et_first_name.getText().toString(),
                et_last_name.getText().toString(),
                et_email.getText().toString(),
                et_phone_no.getText().toString(), imagePathCompressed);
    }

    @OnClick(R.id.btn_server_edit)
    void onServerEdtitClick() {
        et_first_name.setEnabled(true);
        et_last_name.setEnabled(true);
        et_email.setEnabled(true);
        et_phone_no.setEnabled(true);
        btn_server_edit.setVisibility(View.GONE);
        btn_server_submit.setVisibility(View.VISIBLE);
    }

    @Override
    public void updateUserProfileDetails(String first_name, String last_name, String email, String phone_no, String user_image) {
        setContentView(R.layout.activity_new_profile);

        setUp();
        et_last_name.setVisibility(View.GONE);
        et_first_name.setText(first_name);
        et_last_name.setText(last_name);
        et_email.setText(email);
        et_phone_no.setText(phone_no);
        text_header_text.setText(first_name);

        //str_user_image = user_image;

        if (!user_image.equals("")) {
            Glide.with(this)
                    .load(ApiEndPoint.ENDPOINT_FOR_IMAGE + user_image)
                    .asBitmap()
                    .centerCrop()
                    .into(iv_profile_pic);
        }
    }

    @Override
    public void openChangePhoneNumberActivity() {
        startActivity(new Intent(this, ChangeNumberActivity.class));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.

        Toast.makeText(this, "is ut woirking", Toast.LENGTH_SHORT).show();
        getMenuInflater().inflate(R.menu.menu_profile, menu);
        MenuItem action_done = menu.findItem(R.id.menu_edit);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {

            case R.id.menu_edit:
                Toast.makeText(this, "is ut woirking", Toast.LENGTH_SHORT).show();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//
//
//        Toast.makeText(this, "is ut woirking", Toast.LENGTH_SHORT).show();
//        getMenuInflater().inflate(R.menu.menu_profile, menu);
//
//        MenuItem item = menu.findItem(R.id.menu_edit);
////        Drawable drawable = item.getIcon();
////        if (drawable instanceof Animatable) {
////            ((Animatable) drawable).start();
////        }
//
//        if (item != null) {
//            item.getActionView().setOnClickListener(new View.OnClickListener() {
//
//                @Override
//                public void onClick(View v) {
//                    Log.d("Listener", "Clicked");
//                }
//            });
//        }
//
//        return super.onCreateOptionsMenu(menu);
//    }

//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle item selection
//        Drawable drawable = item.getIcon();
//        if (drawable instanceof Animatable) {
//            ((Animatable) drawable).start();
//        }
//
//        if (item.getItemId() == R.id.menu_edit) {
//            Log.e("Click Me", "Click me");
//        }
//        return super.onOptionsItemSelected(item);
//
//
////        switch (item.getItemId()) {
////            case R.id.menu_edit:
////
////                Log.e("Click Me", "Click me");
////                et_first_name.setEnabled(true);
////                et_last_name.setEnabled(true);
////                et_email.setEnabled(true);
////                et_phone_no.setEnabled(true);
////
////                return true;
////            default:
////                return super.onOptionsItemSelected(item);
//    }

    @Override
    public void onOffsetChanged(AppBarLayout appBarLayout, int offset) {
        int maxScroll = appBarLayout.getTotalScrollRange();
        float percentage = (float) Math.abs(offset) / (float) maxScroll;

        handleAlphaOnTitle(percentage);
        handleToolbarTitleVisibility(percentage);
    }

    private void handleToolbarTitleVisibility(float percentage) {
        if (percentage >= PERCENTAGE_TO_SHOW_TITLE_AT_TOOLBAR) {

            if (!mIsTheTitleVisible) {
                startAlphaAnimation(mTitle, ALPHA_ANIMATIONS_DURATION, View.VISIBLE);
                mIsTheTitleVisible = true;
            }

        } else {

            if (mIsTheTitleVisible) {
                startAlphaAnimation(mTitle, ALPHA_ANIMATIONS_DURATION, View.INVISIBLE);
                mIsTheTitleVisible = false;
            }
        }
    }

    private void handleAlphaOnTitle(float percentage) {
        if (percentage >= PERCENTAGE_TO_HIDE_TITLE_DETAILS) {
            if (mIsTheTitleContainerVisible) {
                startAlphaAnimation(mTitleContainer, ALPHA_ANIMATIONS_DURATION, View.INVISIBLE);
                mIsTheTitleContainerVisible = false;
            }

        } else {

            if (!mIsTheTitleContainerVisible) {
                startAlphaAnimation(mTitleContainer, ALPHA_ANIMATIONS_DURATION, View.VISIBLE);
                mIsTheTitleContainerVisible = true;
            }
        }
    }

    public static void startAlphaAnimation(View v, long duration, int visibility) {
        AlphaAnimation alphaAnimation = (visibility == View.VISIBLE)
                ? new AlphaAnimation(0f, 1f)
                : new AlphaAnimation(1f, 0f);

        alphaAnimation.setDuration(duration);
        alphaAnimation.setFillAfter(true);
        v.startAnimation(alphaAnimation);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        try {
            switch (requestCode) {
                case 101:

                    selectedImage = data.getData();
                    imagePath = getPath(selectedImage);
                    ImageCompressMode imageCompressMode = new ImageCompressMode(this);
                    imagePathCompressed = imageCompressMode.compressImage(imagePath);
                    String[] filePathColumn = {MediaStore.Images.Media.DATA};
                    Cursor cursor = getContentResolver().query(selectedImage, filePathColumn, null, null, null);
                    cursor.moveToFirst();
                    int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
                    String filePath = cursor.getString(columnIndex);
                    cursor.close();
                    // Set the Image in ImageView after decoding the String
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    options.inJustDecodeBounds = true;
                    BitmapFactory.decodeFile(filePath, options);
                    final int REQUIRED_SIZE = 300;
                    int scale = 1;
                    while (options.outWidth / scale / 2 >= REQUIRED_SIZE && options.outHeight / scale / 2 >= REQUIRED_SIZE)
                        scale *= 2;
                    options.inSampleSize = scale;
                    options.inJustDecodeBounds = false;
                    bitmap1 = BitmapFactory.decodeFile(filePath, options);

                    iv_profile_pic.setImageBitmap(bitmap1);

                    break;
                case CAMERS_PICKER:
                    thumbnail = MediaStore.Images.Media.getBitmap(getContentResolver(), imageUri);
                    iv_profile_pic.setImageBitmap(thumbnail);
                    imagePath = getRealPathFromURI(imageUri);
                    ImageCompressMode imageCompressModee = new ImageCompressMode(this);
                    imagePathCompressed = imageCompressModee.compressImage(imagePath);
                    break;
            }
        } catch (Exception e) {
        }

    }

    public String getRealPathFromURI(Uri uri) {
        Cursor cursor = getContentResolver().query(uri, null, null, null, null);
        cursor.moveToFirst();
        int idx = cursor.getColumnIndex(MediaStore.Images.ImageColumns.DATA);
        return cursor.getString(idx);
    }

    public String getPath(Uri uri) {

        String[] projection = {MediaStore.Images.Media.DATA};

        Cursor cursor = managedQuery(uri, projection, null, null, null);

        int column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);

        cursor.moveToFirst();

        return cursor.getString(column_index);

    }

}
