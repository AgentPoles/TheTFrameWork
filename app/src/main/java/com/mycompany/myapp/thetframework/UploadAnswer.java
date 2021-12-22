package com.mycompany.myapp.thetframework;

import android.app.Service;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.media.ExifInterface;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class UploadAnswer extends Service {
    FirebaseDatabase firebaseDatabase;
    DatabaseReference frefa, frefb, frefc;
    FirebaseAuth firebaseAuth;
    AppDatabase mdb;
    static String coolthumbline;
    static String coolreal;
    File vfile;
    Uri firstpath;
    Uri secondpath;
    int id;
    Handler handler;
    double timestamp;
    Bitmap imagebitmap;
    String uidl;
    Answer ans;
    File fii, fid;
    List<Answer> answers;
    long timeStamp;
    question quer;
    int errormessage;
    StorageReference storageReference;
    FirebaseStorage storage;
    static int actualHeight = 0;
    static int actualWidth = 0;
    SharedPreferences mysharedpreferences;
    SharedPreferences.Editor myEditor;
    List<question> allQuestionsinsert, allquestionsupdate, allquestionsremove;

    public UploadAnswer() {
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Intent g = intent;
        final Bundle m = intent.getExtras();

        AppExecutor.getsInstance().diskIO().execute(
                new Runnable() {
                    @Override
                    public void run() {
                        try {
                            String coolid = m.getString("coolid");
                            String questioncoolid = m.getString("questioncoolid");
                            ans = mdb.answerdao().LoadOrdinaryAnswerbycoolid(coolid);
                            quer = mdb.questionDao().LoadOrdinaryBycoolId(questioncoolid);
                            if (ans != null) {
                                ans.setPending(false);
                                if (ans.isHasimage()) {
                                    imagebitmap = getbitmap(Uri.parse(ans.getUristring()));
                                    secondpath = convertofile(fii, imagebitmap);
                                    firstpath = convertoofile(fid, imagebitmap);
                                    processthrough(frefa, ans, firstpath, secondpath, quer);
                                }

                            }
                        }
                        catch (Exception e){

                        }
                    }

                }
        );


        return Service.START_NOT_STICKY;
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        return null;
//        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mdb = AppDatabase.getsInstance(getApplicationContext());
        firebaseAuth = FirebaseAuth.getInstance();
        firebaseDatabase = FirebaseDatabase.getInstance();
        frefa = firebaseDatabase.getReference("Answers");
        frefb = firebaseDatabase.getReference("question");
        storage = FirebaseStorage.getInstance();
        handler = new Handler();
        storageReference = storage.getReference("answerimages");
//        Toast.makeText(getApplicationContext(),"now in oncreate answer service",Toast.LENGTH_LONG).show();



//   MyViewModelFactory factory = new MyViewModelFactory(mdb,id);
//   final MySinglesViewModel viewModel = ViewModelProviders.of(getApplicationContext(),factory).get(MySinglesViewModel.class);
    }
    private Bitmap getbitmap(Uri filePath){
        Bitmap bitmap;
        try {
            bitmap = MediaStore.Images.Media.getBitmap(getApplication().getContentResolver(), filePath);
            return bitmap;
        }
        catch (Exception e){

        }
        return null;
    }
    private Answer runquesions(List<Answer> ans, int p, double timestamp ){
        for(int i=(ans.size()-p);i<ans.size();i++){
            if(ans.get(i).getTimestamp()==timestamp){
                return ans.get(i);
            }
        }
        return null;
    }
    private void processthrough(DatabaseReference databaseReference, Answer ans, Uri firstpath, Uri secondpath, question quer){

        uploadImage(ans.getAnswerid(),firstpath,secondpath,ans, quer);
        handler.post(new Runnable() {
            @Override
            public void run() {
//                Toast.makeText(getApplicationContext(),"processing true",Toast.LENGTH_LONG).show();
            }
        });

    }
    private void uploadImage(final String mmuid, Uri uri, final Uri secondpath, final Answer ans, final question quer) {

        if(uri != null)
        {

            StorageReference ref = storageReference.child(mmuid);
            ref.putFile(uri)
                    .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
//                            progressDialog.dismiss();
                            Uri questionthumbline;
                            questionthumbline =  taskSnapshot.getUploadSessionUri();

//
//
                            coolthumbline = questionthumbline.toString();
                            ans.setThumblineuri(coolthumbline);
                            askit(ans,mmuid,secondpath,quer);
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
//                                    Toast.makeText(getApplicationContext(),"loaded answer thumbline",Toast.LENGTH_LONG).show();
                                }
                            });

                        }
                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
//
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    Toast.makeText(getApplicationContext(),"failed to load thumbline",Toast.LENGTH_LONG).show();
                                }
                            });
                        }
                    })
                    .addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onProgress(UploadTask.TaskSnapshot taskSnapshot) {
                            double progress = (100.0*taskSnapshot.getBytesTransferred()/taskSnapshot.getTotalByteCount());

//                                trestee.setText(String.valueOf(dabble) + "%");
                        }

//

                    });

        }
        else {
            handler.post(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(getApplicationContext(),"could not find thumbline",Toast.LENGTH_LONG).show();
                }
            });
        }
    }
    private void uploadrealImage(String push, Uri uri, final Answer ans, final String mmuid) {
        if(uri != null)
        {
            StorageReference ref = storageReference.child("real"+push);
            ref.putFile(uri)
                    .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {



                            Uri realquestionuri =  taskSnapshot.getUploadSessionUri();
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
//                                    Toast.makeText(getApplicationContext(),"loaded answer real",Toast.LENGTH_LONG).show();
                                }
                            });
                            coolreal = realquestionuri.toString();
                            ans.setDownloaduri(coolreal);
                            frefa.child(mmuid).setValue(ans).addOnCompleteListener(
                                    new OnCompleteListener<Void>() {
                                        @Override
                                        public void onComplete(@NonNull Task<Void> task) {
                                            if(task.isSuccessful()){
                                                handler.post(new Runnable() {
                                                    @Override
                                                    public void run() {
//                                                        Toast.makeText(getApplicationContext(),"done with question",Toast.LENGTH_LONG).show();
                                                    }
                                                });
                                                stopSelf();
                                            }
                                            else {
                                                handler.post(new Runnable() {
                                                    @Override
                                                    public void run() {
//                                                        Toast.makeText(getApplicationContext(),"there is still a glitch",Toast.LENGTH_LONG).show();
                                                    }
                                                });
                                            }
                                        }
                                    }
                            );
//

                        }
                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    Toast.makeText(getApplicationContext(),"failed to load real",Toast.LENGTH_LONG).show();
                                }
                            });
                        }
                    })
                    .addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onProgress(UploadTask.TaskSnapshot taskSnapshot) {
                            double progress = (100.0 * taskSnapshot.getBytesTransferred()) / taskSnapshot.getTotalByteCount();

//                            trestee.setText(String.valueOf(progress)+"%");
//                            progressDialog.setMessage("Uploaded "+(int)progress+"%");
                        }
                    });

        }
        else {
            takenoterealpathfailed();
        }
    }
    public void takenoterealpathfailed(){
        errormessage = 4;
    }

    public void failedduringcompresso(){
        errormessage =9;
    }

    public void takenotethumbfailed(){
        errormessage = 3;
    }

    public void takenotethumblinepathfailed(){
        errormessage = 5;
    }

    public void takenoterealfailed(){
        errormessage = 2;
    }

    public void takenoteputquestionfailed(){
        errormessage = 1;
    }

    public void compressourinotExists(){
        errormessage = 8;
    }

    public void convertofilefailed(){
        errormessage = 7;
    }

    public void compressimagefailed(){
        errormessage = 6;
    }
    public void askit(final Answer anse, final String mmuid, final Uri seconpath, final question quer){

//        anse.setDownloaduri(coolreal);
        anse.setThumblineuri(coolthumbline);
        anse.setAnswerid(mmuid);
        anse.setPending(false);
        frefa.child(mmuid).setValue(anse).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()) {
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(getApplicationContext(),"successfully placed your answer",Toast.LENGTH_LONG).show();
                        }
                    });
                    quer.setAnspending(false);
                    quer.setRead(false);
                    frefb.child(quer.getQueid()).setValue(quer);
                    uploadrealImage(mmuid,seconpath,anse,mmuid);

                } else {

                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(getApplicationContext(),"failed to load your answer",Toast.LENGTH_LONG).show();
                        }
                    });
                }
            }

        });

    }
    public Uri convertofile(File file, Bitmap bit){
        Uri uri;
        file = new File(getApplicationContext().getCacheDir(), "images");
        try {
            file.createNewFile();
        }
        catch (Exception e){

        }
//Convert bitmap to byte array
        Bitmap bitmap = bit;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
//        bitmap.compress(Bitmap.CompressFormat.JPEG, 100 /*ignored for PNG*/, bos);
        byte[] bitmapdata = bos.toByteArray();

//write the bytes in file
        try {
            FileOutputStream fos = new FileOutputStream(file);

            fos.write(bitmapdata);
            fos.flush();
            fos.close();
            uri= Uri.fromFile(file);
//            uri = Uri.parse(compressImage(uri.toString()));
        }
        catch (Exception e){
//       displayo(e.toString());



            convertofilefailed();
            uri = null;
        }
        return uri;

    }
    public Uri convertoofile(File file, Bitmap bit){
        Uri uri;
        file = new File(getApplicationContext().getCacheDir(), "images");
        try {
            file.createNewFile();
        }
        catch (Exception e){

        }
//Convert bitmap to byte array
        Bitmap bitmap = bit;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 10 /*ignored for PNG*/, bos);
        byte[] bitmapdata = bos.toByteArray();

//write the bytes in file
        try {
            FileOutputStream fos = new FileOutputStream(file);

            fos.write(bitmapdata);
            fos.flush();
            fos.close();
            uri= Uri.fromFile(file);
            uri = Uri.parse(compressoImage(uri.toString()));
        }
        catch (Exception e){
//            displayo(e.toString());
            compressourinotExists();
            uri = null;
        }
        return uri;

    }
    public String compressoImage(String imageUri) {

        String filePathy = getRealPathFromURI(imageUri);
        Bitmap scaledBitmap = null;
        InputStream is = null;
//        try {
//            URL url = new URL(imageUri);
//            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
//
//            is = connection.getInputStream();
//        }
//        catch (Exception e){
//
//        }
//        BitmapFactory.Options options = new BitmapFactory.Options();
//        options.inJustDecodeBounds = true;

//        BitmapFactory.decodeStream(is, null, options);
//        URL url = new URL(mCurrentPhotoPath);
//        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
//
//        InputStream is = connection.getInputStream();
        BitmapFactory.Options options = new BitmapFactory.Options();

//      by setting this field as true, the actual bitmap pixels are not loaded in the memory. Just the bounds are loaded. If
//      you try the use the bitmap here, you will get null.
        options.inJustDecodeBounds = true;
//        Bitmap bmp = BitmapFactory.decodeStream(is, null, options);
        Bitmap bmp = BitmapFactory.decodeFile(filePathy, options);
//        Bitmap bmp = BitmapFactory.decodeFile(new File(filePath.getPath()).getAbsolutePath(), options);
//
//
        actualHeight = options.outHeight;
        actualWidth = options.outWidth;

//        int actualHeight = 504;
//        int actualWidth = 504;

//      max Height and width values of the compressed image is taken as 816x612

        float maxHeight = 816.0f;
        float maxWidth = 612.0f;
        float imgRatio = actualWidth / actualHeight;
        float maxRatio = maxWidth / maxHeight;

//      width and height values are set maintaining the aspect ratio of the image

        if (actualHeight > maxHeight || actualWidth > maxWidth) {
            if (imgRatio < maxRatio) {
                imgRatio = maxHeight / actualHeight;
                actualWidth = (int) (imgRatio * actualWidth);
                actualHeight = (int) maxHeight;
            } else if (imgRatio > maxRatio) {
                imgRatio = maxWidth / actualWidth;
                actualHeight = (int) (imgRatio * actualHeight);
                actualWidth = (int) maxWidth;
            } else {
                actualHeight = (int) maxHeight;
                actualWidth = (int) maxWidth;

            }
        }


        options.inSampleSize = calculateInSampleSize(options, actualWidth, actualHeight);

//      inJustDecodeBounds set to false to load the actual bitmap
        options.inJustDecodeBounds = false;

//      this options allow android to claim the bitmap memory if it runs low on memory
        options.inPurgeable = true;
        options.inInputShareable = true;
        options.inTempStorage = new byte[16 * 1024];

        try {
//          load the bitmap from its path
            bmp = BitmapFactory.decodeFile(filePathy, options);
        } catch (OutOfMemoryError exception) {
            exception.printStackTrace();

        }
        try {
            scaledBitmap = Bitmap.createBitmap(actualWidth, actualHeight, Bitmap.Config.ARGB_8888);
        } catch (OutOfMemoryError exception) {
            exception.printStackTrace();
        }

        float ratioX = actualWidth / (float) options.outWidth;
        float ratioY = actualHeight / (float) options.outHeight;
        float middleX = actualWidth / 2.0f;
        float middleY = actualHeight / 2.0f;

        Matrix scaleMatrix = new Matrix();
        scaleMatrix.setScale(ratioX, ratioY, middleX, middleY);

        Canvas canvas = new Canvas(scaledBitmap);
        canvas.setMatrix(scaleMatrix);
        canvas.drawBitmap(bmp, middleX - bmp.getWidth() / 2, middleY - bmp.getHeight() / 2, new Paint(Paint.FILTER_BITMAP_FLAG));

//      check the rotation of the image and display it properly
        ExifInterface exif;
        try {
            exif = new ExifInterface(filePathy);

            int orientation = exif.getAttributeInt(
                    ExifInterface.TAG_ORIENTATION, 0);
            Log.d("EXIF", "Exif: " + orientation);
            Matrix matrix = new Matrix();
            if (orientation == 6) {
                matrix.postRotate(90);
                Log.d("EXIF", "Exif: " + orientation);
            } else if (orientation == 3) {
                matrix.postRotate(180);
                Log.d("EXIF", "Exif: " + orientation);
            } else if (orientation == 8) {
                matrix.postRotate(270);
                Log.d("EXIF", "Exif: " + orientation);
            }
            scaledBitmap = Bitmap.createBitmap(scaledBitmap, 0, 0,
                    scaledBitmap.getWidth(), scaledBitmap.getHeight(), matrix,
                    true);
        } catch (IOException e) {
            e.printStackTrace();
        }

//        }
        Uri uri;
        vfile = new File(getApplicationContext().getCacheDir(), "scaledimages");
        try {
            vfile.createNewFile();
        }
        catch (Exception e){

        }
//Convert bitmap to byte array
//        Bitmap bitmap = bit;

        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        scaledBitmap.compress(Bitmap.CompressFormat.JPEG, 10 /*ignored for PNG*/, bos);
        byte[] bitmapdata = bos.toByteArray();

//write the bytes in file
        try {
            FileOutputStream fos = new FileOutputStream(vfile);

            fos.write(bitmapdata);
            fos.flush();
            fos.close();
            uri= Uri.fromFile(vfile);
//            uri = Uri.parse(compressImage(uri.toString()));
        }
        catch (Exception e){
//            displayo(e.toString());
            failedduringcompresso();
//            displayo("failed already");
            uri = null;
        }
        return uri.toString();
//        return filename;

    }
    private String getRealPathFromURI(String contentURI) {
        Uri contentUri = Uri.parse(contentURI);
        Cursor cursor = getApplication().getContentResolver().query(contentUri, null, null, null, null);
        if (cursor == null) {
            return contentUri.getPath();
        } else {
            cursor.moveToFirst();
            int index = cursor.getColumnIndex(MediaStore.Images.ImageColumns.DATA);
            return cursor.getString(index);
        }

    }
    public int calculateInSampleSize(BitmapFactory.Options options, int reqWidth, int reqHeight) {
        final int height = options.outHeight;
        final int width = options.outWidth;
        int inSampleSize = 1;

        if (height > reqHeight || width > reqWidth) {
            final int heightRatio = Math.round((float) height / (float) reqHeight);
            final int widthRatio = Math.round((float) width / (float) reqWidth);
            inSampleSize = heightRatio < widthRatio ? heightRatio : widthRatio;
        }
        final float totalPixels = width * height;
        final float totalReqPixelsCap = reqWidth * reqHeight * 2;
        while (totalPixels / (inSampleSize * inSampleSize) > totalReqPixelsCap) {
            inSampleSize++;
        }

        return inSampleSize;
    }
    public String compressImage(String imageUri) {

        String filePathy = getRealPathFromURI(imageUri);
        Bitmap scaledBitmap = null;
        InputStream is = null;
//        try {
//            URL url = new URL(imageUri);
//            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
//
//            is = connection.getInputStream();
//        }
//        catch (Exception e){
//
//        }
//        BitmapFactory.Options options = new BitmapFactory.Options();
//        options.inJustDecodeBounds = true;

//        BitmapFactory.decodeStream(is, null, options);
//        URL url = new URL(mCurrentPhotoPath);
//        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
//
//        InputStream is = connection.getInputStream();
        BitmapFactory.Options options = new BitmapFactory.Options();

//      by setting this field as true, the actual bitmap pixels are not loaded in the memory. Just the bounds are loaded. If
//      you try the use the bitmap here, you will get null.
        options.inJustDecodeBounds = true;
//        Bitmap bmp = BitmapFactory.decodeStream(is, null, options);
        Bitmap bmp = BitmapFactory.decodeFile(filePathy, options);
//        Bitmap bmp = BitmapFactory.decodeFile(new File(filePath.getPath()).getAbsolutePath(), options);
//
//
        actualHeight = options.outHeight;
        actualWidth = options.outWidth;

//        int actualHeight = 504;
//        int actualWidth = 504;

//      max Height and width values of the compressed image is taken as 816x612

        float maxHeight = 816.0f;
        float maxWidth = 612.0f;
        float imgRatio = actualWidth / actualHeight;
        float maxRatio = maxWidth / maxHeight;

//      width and height values are set maintaining the aspect ratio of the image

        if (actualHeight > maxHeight || actualWidth > maxWidth) {
            if (imgRatio < maxRatio) {
                imgRatio = maxHeight / actualHeight;
                actualWidth = (int) (imgRatio * actualWidth);
                actualHeight = (int) maxHeight;
            } else if (imgRatio > maxRatio) {
                imgRatio = maxWidth / actualWidth;
                actualHeight = (int) (imgRatio * actualHeight);
                actualWidth = (int) maxWidth;
            } else {
                actualHeight = (int) maxHeight;
                actualWidth = (int) maxWidth;

            }
        }

//      setting inSampleSize value allows to load a scaled down version of the original image

        options.inSampleSize = calculateInSampleSize(options, actualWidth, actualHeight);

//      inJustDecodeBounds set to false to load the actual bitmap
        options.inJustDecodeBounds = false;

//      this options allow android to claim the bitmap memory if it runs low on memory
        options.inPurgeable = true;
        options.inInputShareable = true;
        options.inTempStorage = new byte[16 * 1024];

        try {
//          load the bitmap from its path
            bmp = BitmapFactory.decodeFile(filePathy, options);
        } catch (OutOfMemoryError exception) {
            exception.printStackTrace();

        }
        try {
            scaledBitmap = Bitmap.createBitmap(actualWidth, actualHeight, Bitmap.Config.ARGB_8888);
        } catch (OutOfMemoryError exception) {
            exception.printStackTrace();
        }

        float ratioX = actualWidth / (float) options.outWidth;
        float ratioY = actualHeight / (float) options.outHeight;
        float middleX = actualWidth / 2.0f;
        float middleY = actualHeight / 2.0f;

        Matrix scaleMatrix = new Matrix();
        scaleMatrix.setScale(ratioX, ratioY, middleX, middleY);

        Canvas canvas = new Canvas(scaledBitmap);
        canvas.setMatrix(scaleMatrix);
        canvas.drawBitmap(bmp, middleX - bmp.getWidth() / 2, middleY - bmp.getHeight() / 2, new Paint(Paint.FILTER_BITMAP_FLAG));

//      check the rotation of the image and display it properly
        ExifInterface exif;
        try {
            exif = new ExifInterface(filePathy);

            int orientation = exif.getAttributeInt(
                    ExifInterface.TAG_ORIENTATION, 0);
            Log.d("EXIF", "Exif: " + orientation);
            Matrix matrix = new Matrix();
            if (orientation == 6) {
                matrix.postRotate(90);
                Log.d("EXIF", "Exif: " + orientation);
            } else if (orientation == 3) {
                matrix.postRotate(180);
                Log.d("EXIF", "Exif: " + orientation);
            } else if (orientation == 8) {
                matrix.postRotate(270);
                Log.d("EXIF", "Exif: " + orientation);
            }
            scaledBitmap = Bitmap.createBitmap(scaledBitmap, 0, 0,
                    scaledBitmap.getWidth(), scaledBitmap.getHeight(), matrix,
                    true);
        } catch (IOException e) {
            e.printStackTrace();
        }

//        FileOutputStream out = null;
//        String filename = getFilename();
//        try {
//            out = new FileOutputStream(filename);
//
////          write the compressed bitmap at the destination specified by filename.
//            scaledBitmap.compress(Bitmap.CompressFormat.JPEG, 80, out);
//
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
        Uri uri;
        vfile = new File(getApplicationContext().getCacheDir(), "scaledimages");
        try {
            vfile.createNewFile();
        }
        catch (Exception e){

        }
//Convert bitmap to byte array
//        Bitmap bitmap = bit;

        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        scaledBitmap.compress(Bitmap.CompressFormat.JPEG, 90 /*ignored for PNG*/, bos);
        byte[] bitmapdata = bos.toByteArray();

//write the bytes in file
        try {
            FileOutputStream fos = new FileOutputStream(vfile);

            fos.write(bitmapdata);
            fos.flush();
            fos.close();
            uri= Uri.fromFile(vfile);
//            uri = Uri.parse(compressImage(uri.toString()));
        }
        catch (Exception e){
//            displayo(e.toString());
            compressimagefailed();
//            displayo("failed already");
            uri = null;
        }
        return uri.toString();
//        return filename;

    }

}