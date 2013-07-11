-----------------------------------------------------------------------------------------

I had the same problem mostly with the Samsung handsets.Apparently Samsung phones set the EXIF orientation tag, rather than rotating individual pixels.Reading the Bitmap using BitmapFactory does not support this tag.What i found the solution to this problem was using ExifInterface in onActivityResult method of the activity.Which checks for orientation associated with URI of the captured image from the camera.

                int rotate = 0;
                try {
                    getContentResolver().notifyChange(imageUri, null);
                    File imageFile = new File(imagePath);
                    ExifInterface exif = new ExifInterface(
                            imageFile.getAbsolutePath());
                    int orientation = exif.getAttributeInt(
                            ExifInterface.TAG_ORIENTATION,
                            ExifInterface.ORIENTATION_NORMAL);

                    switch (orientation) {
                    case ExifInterface.ORIENTATION_ROTATE_270:
                        rotate = 270;
                        break;
                    case ExifInterface.ORIENTATION_ROTATE_180:
                        rotate = 180;
                        break;
                    case ExifInterface.ORIENTATION_ROTATE_90:
                        rotate = 90;
                        break;
                    }
                    Log.v(Common.TAG, "Exif orientation: " + orientation);
                } catch (Exception e) {
                    e.printStackTrace();
                }


------------------------------------------------------------------------------------------------

you can just simpaly rotate it

get the orietation of the image taken using this code in onActvityresult ....

File imageFile = new File(imageUri.toString());
       ExifInterface exif = new ExifInterface(imageFile.getAbsolutePath());
       int orientation = exif.getAttributeInt(ExifInterface.TAG_ORIENTATION, ExifInterface.ORIENTATION_NORMAL);
       int rotate = 0;
       switch(orientation) {
         case ORIENTATION_ROTATE_270:
             rotate-=90;break;
         case ORIENTATION_ROTATE_180:
             rotate-=90;break
         case ORIENTATION_ROTATE_90:
             rotate-=90;break
       }

-------------------------------------------------------------------------------------------------

// create a matrix for the manipulation
 Matrix matrix = new Matrix();
 // resize the bit map
 matrix.postScale(scaleWidth, scaleHeight);
 // rotate the Bitmap
 matrix.postRotate(90);

 // recreate the new Bitmap
 Bitmap resizedBitmap = Bitmap.createBitmap(bitmapOriginal, 0, 0, widthOriginal, heightOriginal, matrix, true);

---------------------------------------------------------------------------------------------------
