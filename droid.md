------------------------------------------------
2013/7/27
------------------------------------------------
        listview.addHeaderView(totalExpense);    
        listview.addFooterView(totalExpense);   
------------------------------------------------
2013/7/28
------------------------------------------------
        getResources().getResourceEntryName(resid);    
        getResources().getResourceName(resid);    
        getResources().getResourcePackageName(resid);    
        getResources().getResourceTypeName(resid);  
------------------------------------------------
2013/7/29
------------------------------------------------
        adapter.notifyDataSetChanged();             
------------------------------------------------
        @Override
        public void onBackPressed() {
             super.onBackPressed()
             fragment.onBackPressed();
        }
--------------------------------------------------
        setOnKeyListener( new OnKeyListener()
        {
        @Override
        public boolean onKey( View v, int keyCode, KeyEvent event )
        {
           if( keyCode == KeyEvent.KEYCODE_BACK )
             {
                 return true;
             }
        return false;
        }
        } );
------------------------------------------------
         Intent intent = new Intent();
			intent.setAction(Intent.ACTION_MAIN);
			intent.addCategory(Intent.CATEGORY_HOME);
			startActivity(intent);
------------------------------------------------
		@Override
		public boolean onKeyDown(int keyCode, KeyEvent event) {
			if (keyCode == event.KEYCODE_BACK) {
				textview.setText(R.string.action_settings);
				return true;
			}
			return super.onKeyDown(keyCode, event);
		}
------------------------------------------------
		@Override
		public void onBackPressed() {
    		if (this.currentDirectory.getParent() != null) {
        		// --> browse one folder up...
    		} else {
        		// --> you are already at the root folder
    		}
		}
------------------------------------------------
2013/7/30
------------------------------------------------
		public void onBackPressed() {
            String parent = file.getParent().toString();
            file = new File( parent ) ;         
            File list[] = file.listFiles();

            myList.clear();

            for( int i=0; i< list.length; i++)
            {
                myList.add( list[i].getName() );
            }
            Toast.makeText(getApplicationContext(), parent,          Toast.LENGTH_LONG).show(); 
            setListAdapter(new ArrayAdapter<String>(this,
                    android.R.layout.simple_list_item_1, myList ));
												
             }
------------------------------------------------
		http://stackoverflow.com/questions/13590627/android-listview-headers
------------------------------------------------
		alertDialog.setCanceledOnTouchOutside(true);
------------------------------------------------
		editText.setError("Please enter a non-empty name");
------------------------------------------------
2013/7/31
------------------------------------------------
		private void createFolder(String newFolderName) {
		File newFolder = new File(currentParent, newFolderName);
		if (newFolder.exists()) {
			Toast.makeText(mContext, R.string.failToCreate, Toast.LENGTH_SHORT)
					.show();
		} else {
			boolean success = newFolder.mkdirs();
			if (success) {
				Toast.makeText(mContext, R.string.foldercreated,
						Toast.LENGTH_SHORT).show();
				currentFiles = currentParent.listFiles();
				inflateListView(currentFiles);
			}
		}
		}
------------------------------------------------
		android:shadowColor="#ffffff"
        android:shadowDx="1"
        android:shadowDy="1"
        android:shadowRadius="2"
------------------------------------------------
		textview = (TextView) findViewById(R.id.textview);

		SpannableStringBuilder ssb = new SpannableStringBuilder(
				"Here's a smiley  , and here's a link http://blog.stylingandroid.com");
		Bitmap smiley = BitmapFactory.decodeResource(getResources(),
				R.drawable.arrow);
		ssb.setSpan(new ImageSpan(smiley), 16, 17,
				Spannable.SPAN_INCLUSIVE_INCLUSIVE);
		textview.setText(ssb, BufferType.SPANNABLE);
		Linkify.addLinks(textview, Linkify.WEB_URLS);
------------------------------------------------
2013/8/1
------------------------------------------------
<HorizontalScrollView
        android:id="@+id/locationScroll"
        android:layout_width="match_parent"
        android:layout_height="35dip"
        android:scrollbars="none" >    // no scrollbar

        <LinearLayout
            android:id="@+id/location"
            android:layout_width="match_parent"
            android:layout_height="35dip"
            android:background="#e8e8e8"
            android:gravity="left|center_vertical"
            android:isScrollContainer="true"
            android:orientation="horizontal"
            android:showDividers="middle" >
        </LinearLayout>
</HorizontalScrollView>
------------------------------------------------
		// auto scroll to right
		new Handler().postDelayed(new Runnable() {

				@Override
				public void run() {
					s.fullScroll(HorizontalScrollView.FOCUS_RIGHT);
				}
			}, 100L);
------------------------------------------------

		Use &lt; for <
		Use &gt; for >
		Use &amp; for &.

		etc.


------------------------------------------------
<string-array name="cloud_images">
        <item>@drawable/icon_google_drive</item>
        <item>@drawable/icon_dropbox</item>
        <item>@drawable/icon_sugar_sync</item>
        <item>@drawable/icon_baidu_cloud</item>
        <item>@drawable/icon_kingsorf_cloud</item>
        <item>@drawable/icon_sina_cloud</item>
    </string-array>
    <string-array name="cloud_names">
        <item>Google Drive</item>
        <item>Dropbox</item>
        <item>SugarSync</item>
        <item>Baidu Cloud</item>
        <item>Kingsoft Cloud</item>
        <item>Sina Cloud</item>
    </string-array>

		TypedArray cloud_images = getResources().obtainTypedArray(
				R.array.cloud_images);
		String[] cloud_names = getResources().getStringArray(
				R.array.cloud_names);
		for (int i = 0; i < cloud_names.length; i++) {
			addCloudItem(cloud_images.getResourceId(i, 0), cloud_names[i],
					cloud_items, null);
		}
------------------------------------------------
2013/8/2
------------------------------------------------
Useful website:
actionbarsherlock  http://actionbarsherlock.com/    
http://www.grokkingandroid.com/adding-actionbarsherlock-to-your-project/    

must extends SherlockActivity     
then can use getSupportActionBar() to get the actionBar   
------------------------------------------------
		private void setActinBarCenterTitleCustomView() {
		ActionBar actionBar = getSupportActionBar();
		// set LayoutParams
		ActionBar.LayoutParams params = new ActionBar.LayoutParams(
				ActionBar.LayoutParams.WRAP_CONTENT,
				ActionBar.LayoutParams.WRAP_CONTENT, Gravity.CENTER);
		// Set display to custom next
		actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
		// Do any other config to the action bar
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
		actionBar.setDisplayShowHomeEnabled(true);
		actionBar.setDisplayHomeAsUpEnabled(true);
		actionBar.setDisplayShowTitleEnabled(false);
		// Get custom view
		TextView actionbarTitleCenterView = (TextView) LayoutInflater
				.from(this).inflate(R.layout.actionbar_title, null);
		actionbarTitleCenterView.setText(R.string.config);
		// Now set custom view
		actionBar.setCustomView(actionbarTitleCenterView, params);
------------------------------------------------
http://stackoverflow.com/questions/10364045/actionbarsherlock-actionbar-custom-background-with-divider
actionbar bottom divider
------------------------------------------------
------------------------------------------------

