Inmo Air公共组件库封装 
1.基于自研应用越来越多的情况，避免多人开发时造成的组件混乱的情况。
2.此库基于640*400的分辨率进行布局。
3.组件库： 
  ui —————常用UI组件  公有样式： TODO
          目前包含组件有： 确认取消框-ConfirmCancelDialog.java 进度条-CommonProgressBar.java

  网络请求组件库： network —————常用的网络请求,包含get、post、put、上传、下载等常见的网络请求方式 
  工具类库： util ————— 常用工具类
  NetWorkUtil.java ————— 判断设备是否可以正常上网
  DisplayUtil.java ————— 判断硬件（摄像头、mic是否正常）、获取屏幕宽高等