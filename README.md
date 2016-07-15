# SoftInputBoard

<br/>
##简介
<br/>
用Android View来实现软键盘，避免了复杂的Window对于窗口的处理。

- AutoPopLayout处理的是当EditText在屏幕的高度大于软键盘的高度，那么就将自己向上平移。内部还屏蔽了系统软键盘对EditText的操作
- BaseInputBoard处理的是软键盘的的操作，当然，你也可以拓展SoftInputBoard。
- AutoPopLayout完全支持密码框的操作
- 详情见[http://blog.csdn.net/yanghuinipurean/article/details/51323805](http://blog.csdn.net/yanghuinipurean/article/details/51323805)


##显示
![](https://github.com/Nipuream/SoftInputBoard/blob/master/SoftInputDemo/SoftInputBoard.gif)


##使用




        autoPopLayout = (AutoPopLayout)findViewById(R.id.autoPopLayout);

        et1 = (EditText)findViewById(R.id.auto_et1);
        et2 = (EditText)findViewById(R.id.auto_et2);
        passwordInputView = (PasswordInputView)findViewById(R.id.auto_et3);
        showBtn = (Button)findViewById(R.id.show_pwd);

        List<EditText> ets = new ArrayList<EditText>();
        ets.add(et1);
        ets.add(et2);
        ets.add(passwordInputView);

        BaseInputBoard baseInputBoard = new SoftInputBoard(this);

        autoPopLayout.hideSoftInputMethod(ets,new WeakReference<Activity>(this));
        autoPopLayout.initSoftInputBoard(baseInputBoard);

   

##拓展
继承BaseInputBoard,然后实现它的抽象方法，findViewsForResource()用于找出自己自定义键盘的控件，然后绑定它。onClick()确定点击布局内的那个控件，要显示什么，最后调用callBackData()方法，详情见代码。

