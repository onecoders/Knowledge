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
