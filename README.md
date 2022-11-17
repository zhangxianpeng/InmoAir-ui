Inmo Air UI
### 调用前提
在app的build.gradle文件里面配置：
dataBinding {
  enabled = true
}

1.全局Toast 调用：AirToast.showToast(string res)

2.二次确认弹窗 EnsureDialogAct.class (以Activity为载体做窗口展示，避免dialog直接获取焦点UI显示异常的问题)
调用： 
2.1 弹窗展示 
Intent intent = new Intent(this, EnsureDialogAct.class); 
// 是否展示顶部的icon boolean类型 （必要，true时需要传icon资源   false时需要传一级标题）
intent.putExtra(EnsureDialogAct.EXTRA_IS_SHOW_TOP_IMAGE, true); 
// 顶部icon的byte[]
intent.putExtra(EnsureDialogAct.EXTRA_ICON, byte[] icon);
// 一级标题 
intent.putExtra(EnsureDialogAct.EXTRA_TITLE, String 一级标题);
// 二级标题 
intent.putExtra(EnsureDialogAct.EXTRA_SUB_TITLE, String 二级标题); 
// 左边按钮文字 
intent.putExtra(EnsureDialogAct.EXTRA_LEFT_BTN_TEXT, String 左边按钮文字); 
// 右边按钮文字
intent.putExtra(EnsureDialogAct.EXTRA_RIGHT_BTN_TEXT, String 右边按钮文字); 
startActivityForResult(intent, 10000);

2.2 左右按钮的事件回调 @Override protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) { super.onActivityResult(requestCode,
resultCode, data); if (requestCode == 10000 && resultCode == RESULT_OK) { String extra = data.getStringExtra("btnClickEvent"); if (TextUtils.isEmpty(
extra)) return; switch (extra) { case "right":
// 右边按钮事件 break; case "left":
// 左边按钮事件 break; default:
break; } } }

3.跑马灯效果textView
引入方式:
3.1 把xml文件中的TextView改成com.inmoair.ui.textView.MarqueeTextView
3.2 加入 singleLine 属性，设置为true
