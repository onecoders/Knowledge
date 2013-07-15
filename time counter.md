Timer T=new Timer();      
T.scheduleAtFixedRate(new TimerTask() {         
        @Override
        public void run() {
            runOnUiThread(new Runnable()
            {
                @Override
                public void run()
                {
                    myTextView.setText("count="+count);
                    count++;                
                }
            });
        }
    }, 1000, 1000);        


 onClick(View v)     
 {      
      //this is 'Pause' button click listener     
      T.cancel();      
 }      
