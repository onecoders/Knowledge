Firstly, the concept of "application" in Android is slightly an extended one.       

An application - technically a process - can have multiple activities, services, content providers and/or broadcast listeners. If at least one of them is running, the application is up and running (the process).      

So, what you have to identify is how do you want to "start the application".       

Ok... here's what you can try out:       

    Create an intent with action=MAIN and category=LAUNCHER       
    Get the PackageManager from the current context using context.getPackageManager       
    packageManager.queryIntentActivity(<intent>, 0) where intent has category=LAUNCHER, action=MAIN or packageManager.resolveActivity(<intent>, 0) to get the first activity with main/launcher       
    Get the ActivityInfo you're interested in       
    From the ActivityInfo, get the packageName and name       
    Finally, create another intent with with category=LAUNCHER, action=MAIN, componentName = new ComponentName(packageName, name) and setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)       
    Finally, context.startActivity(newIntent)       



Intent intent = getActivity().getPackageManager().getLaunchIntentForPackage(com.package.address);
if (intent != null)
{
    // start the activity
    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
    startActivity(intent);
}
else
{
    // bring user to the market
    // or let them choose an app?
    intent = new Intent(Intent.ACTION_VIEW);
    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
    intent.setData(Uri.parse("market://details?id="+"com.package.address"));
    startActivity(intent);
}




