------------------2013/7/27------------------------------
        listview.addHeaderView(totalExpense);    
        listview.addFooterView(totalExpense);   
------------------2013/7/28------------------------------
        getResources().getResourceEntryName(resid);    
        getResources().getResourceName(resid);    
        getResources().getResourcePackageName(resid);    
        getResources().getResourceTypeName(resid);  
------------------2013/7/29------------------------------
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
