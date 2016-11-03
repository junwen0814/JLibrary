# JunLibrary
常用工具库，平时收集的一些工具类，分享出来。


##使用方法：

###JitPack：

####.build.gradle
```
allprojects {
		repositories {
			...
			maven { url "https://jitpack.io" }
		}
	}
```
####app.build.gradle
```
dependencies {
      compile 'com.github.junwen0814:JLibrary:v1.0.4'
}
```

-------------------------------------------------------------------
##更新记录 
说明：提交工具类 1.0.1
</br>
时间：2016 - 08 - 19 

* JScreenUtls
</br>
添加设置屏幕亮度 

* JAudioUtils
</br>
1 添加音频播放操作类

* JApplicationUtils
</br>
添加获取应用程序下的所有Activity

* JStringUtils
</br>
添加检测字符串中是否包含汉字

* JIntent
</br>
1 添加检查有没有应用程序来接受处理你发出的 2 添加调用便携式热点和数据共享设置

* JBitmapUtils
</br>
添加从本软件新增、修改、删除图片、文件某一个文件（音频、视频）需要更新系统媒体库时使用，不必扫描整个SD卡

* JShareUtils
</br>
添加多进程Preferences数据共享

* JFileUtils
</br>
1 添加文件夹排序（先文件夹排序，后文件排序） 2 添加解压一个压缩文档 到指定位置

* JAddressUtils
</br>
添加地址工具类

* JRescourceUtils
</br>
添加从assets 文件夹中读取图片

-----------------------------------------------------------------------------------------------------------------------------
说明：提交工具类 1.0.0
</br>
时间：2016 - 08 - 11 

* JActivityManager Activity工具类

* JAnimationUtils 动画工具类

* JApplicationUtils 应用相关工具类

* JBitmapUtils  Bitmap工具类

* JCommand 通用类

* JDateUtils  日期工具类

* JDensityUtils 单位转换工具类

* JEncryptUtil 数据加密

* JFileUtils  文件工具类

* JIntent Intent工具类

* JKeyboardUtils 软键盘工具类

* JNetWorkUtils 网络工具类

* JNotificationUtils 通知栏工具类

* JOtherUtils 其他工具类

* JPathUtils 路径工具类

* JPhoneUtils 手机信息工具类

* JScreenUtls 屏幕工具类

* JSdcardUtils SD卡工具类

* JShareUtils Share工具类

* JStringUtils 字符串工具类

* JToast Toast吐司工具类

* JWidghtUtils View工具类

* SelectorDrawable 动态选择器工具类
