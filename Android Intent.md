显示网页:   
   1. Uri uri = Uri.parse("http://www.google.com");   
   2. Intent it = new Intent(Intent.ACTION_VIEW,uri);   
   3. startActivity(it);
   
显示地图:   
1. Uri uri = Uri.parse("geo:38.899533,-77.036476");   
   2. Intent it = new Intent(Intent.Action_VIEW,uri);   
   3. startActivity(it);   
   
路径规划:   
   1. Uri uri = Uri.parse("http://maps.google.com/maps?f=d&saddr=startLat%20startLng&daddr=endLat%20endLng&hl=en");   
   2. Intent it = new Intent(Intent.ACTION_VIEW,URI);   
   3. startActivity(it);   
   
拨打电话:   
调用拨号程序   
  1. Uri uri = Uri.parse("tel:xxxxxx");   
   2. Intent it = new Intent(Intent.ACTION_DIAL, uri);     
   3. startActivity(it);   
   1. Uri uri = Uri.parse("tel.xxxxxx");   
   2. Intent it =new Intent(Intent.ACTION_CALL,uri);   
   3. 要使用这个必须在配置文件中加入<uses-permission id="Android.permission.CALL_PHONE" />   
   
发送SMS/MMS   
调用发送短信的程序   
  1. Intent it = new Intent(Intent.ACTION_VIEW);   
   2. it.putExtra("sms_body", "The SMS text");   
   3. it.setType("vnd.android-dir/mms-sms");   
   4. startActivity(it);      
发送短信   
  1. Uri uri = Uri.parse("smsto:0800000123");   
   2. Intent it = new Intent(Intent.ACTION_SENDTO, uri);   
   3. it.putExtra("sms_body", "The SMS text");   
   4. startActivity(it);     
发送彩信   
  1. Uri uri = Uri.parse("content://media/external/images/media/23");   
   2. Intent it = new Intent(Intent.ACTION_SEND);   
   3. it.putExtra("sms_body", "some text");   
   4. it.putExtra(Intent.EXTRA_STREAM, uri);   
   5. it.setType("image/png");   
   6. startActivity(it);   
   
发送Email   
   1.   
   2. Uri uri = Uri.parse("mailto:xxx@abc.com");   
   3. Intent it = new Intent(Intent.ACTION_SENDTO, uri);   
   4. startActivity(it);   
   1. Intent it = new Intent(Intent.ACTION_SEND);   
   2. it.putExtra(Intent.EXTRA_EMAIL, "me@abc.com");   
   3. it.putExtra(Intent.EXTRA_TEXT, "The email body text");   
   4. it.setType("text/plain");   
   5. startActivity(Intent.createChooser(it, "Choose Email Client"));     
   1. Intent it=new Intent(Intent.ACTION_SEND);    
   2. String[] tos={"me@abc.com"};      
   3. String[] ccs={"you@abc.com"};     
   4. it.putExtra(Intent.EXTRA_EMAIL, tos);     
   5. it.putExtra(Intent.EXTRA_CC, ccs);     
   6. it.putExtra(Intent.EXTRA_TEXT, "The email body text");      
   7. it.putExtra(Intent.EXTRA_SUBJECT, "The email subject text");      
   8. it.setType("message/rfc822");     
   9. startActivity(Intent.createChooser(it, "Choose Email Client"));     
    
添加附件   
  1. Intent it = new Intent(Intent.ACTION_SEND);    
   2. it.putExtra(Intent.EXTRA_SUBJECT, "The email subject text");    
   3. it.putExtra(Intent.EXTRA_STREAM, "[url=]file:///sdcard/mysong.mp3[/url]");    
   4. sendIntent.setType("audio/mp3");    
   5. startActivity(Intent.createChooser(it, "Choose Email Client"));    
    
播放多媒体    
  1.      
   2. Intent it = new Intent(Intent.ACTION_VIEW);     
   3. Uri uri = Uri.parse("[url=]file:///sdcard/song.mp3[/url]");    
   4. it.setDataAndType(uri, "audio/mp3");   
   5. startActivity(it);    
   1. Uri uri = Uri.withAppendedPath(MediaStore.Audio.Media.INTERNAL_CONTENT_URI, "1");      
   2. Intent it = new Intent(Intent.ACTION_VIEW, uri);         
   3. startActivity(it);   

 Uninstall 程序
  1. Uri uri = Uri.fromParts("package", strPackageName, null);      
   2. Intent it = new Intent(Intent.ACTION_DELETE, uri);        
   3. startActivity(it);         
         
 //调用相册
public static final String MIME_TYPE_IMAGE_JPEG = "image/*";      
 public static final int ACTIVITY_GET_IMAGE = 0;       
 Intent getImage = new Intent(Intent.ACTION_GET_CONTENT);       
 getImage.addCategory(Intent.CATEGORY_OPENABLE);       
 getImage.setType(MIME_TYPE_IMAGE_JPEG);      
 startActivityForResult(getImage, ACTIVITY_GET_IMAGE);      
      
 //调用系统相机应用程序，并存储拍下来的照片      
Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);       
 time = Calendar.getInstance().getTimeInMillis();      
 intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(new File(Environment      
 .getExternalStorageDirectory().getAbsolutePath()+"/tucue", time + ".jpg")));      
 startActivityForResult(intent, ACTIVITY_GET_CAMERA_IMAGE);      
      
 uninstall apk      
 /**未测试      
Uri uninstallUri = Uri.fromParts("package", "xxx", null);      
 returnIt = new Intent(Intent.ACTION_DELETE, uninstallUri);      
 */      
 Uri packageURI = Uri.parse("package:"+wistatmap);   
 Intent uninstallIntent = new Intent(Intent.ACTION_DELETE, packageURI);   
 startActivity(uninstallIntent);

 install apk      
 Uri installUri = Uri.fromParts("package", "xxx", null);      
 returnIt = new Intent(Intent.ACTION_PACKAGE_ADDED, installUri);            
 play audio      
 Uri playUri = Uri.parse("[url=]file:///sdcard/download/everything.mp3[/url]");      
 returnIt = new Intent(Intent.ACTION_VIEW, playUri);
      
 //发送附件
Intent it = new Intent(Intent.ACTION_SEND);   
 it.putExtra(Intent.EXTRA_SUBJECT, "The email subject text");         
 it.putExtra(Intent.EXTRA_STREAM, "[url=]file:///sdcard/eoe.mp3[/url]");         
 sendIntent.setType("audio/mp3");         
 startActivity(Intent.createChooser(it, "Choose Email Client"));      
      
 //搜索应用      
Uri uri = Uri.parse("market://search?q=pname:pkg_name");         
 Intent it = new Intent(Intent.ACTION_VIEW, uri);         
 startActivity(it);   
 //where pkg_name is the full package path for an application      
      
 //进入联系人页面      
Intent intent = new Intent();      
 intent.setAction(Intent.ACTION_VIEW);      
 intent.setData(People.CONTENT_URI);      
 startActivity(intent);      
      
 //查看指定联系人      
Uri personUri = ContentUris.withAppendedId(People.CONTENT_URI, info.id);//info.id联系人ID      
 Intent intent = new Intent();      
 intent.setAction(Intent.ACTION_VIEW);      
 intent.setData(personUri);      
 startActivity(intent);      