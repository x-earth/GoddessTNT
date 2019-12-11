### Android常用工具类封装

Android common tool class package

---

@[toc]

---
源代码：

**Github**: [https://github.com/ThirdGoddess/GoddessTNT](https://github.com/ThirdGoddess/GoddessTNT) <br>

**CSDN**: [https://myhub.blog.csdn.net](https://myhub.blog.csdn.net)

欢迎大家在Github上共维护，方便大家使用！
刚开始写这个库，东西有点少，以后我将时常增加东西！

---
使用方法：

工程下build.gradle添加 **maven { url 'https://jitpack.io' }**<br>
Add **maven { url ‘https://jitpack.io’ }** under build.gradle<br>
```java
allprojects {
    repositories {
        google()
        jcenter(
        
		//add
        maven { url 'https://jitpack.io' }
    }
}
```

Modle之下添加 **implementation 'com.github.ThirdGoddess:GoddessTNT:v1.5'**<br>
Add under Modle **implementation 'com.github.ThirdGoddess:GoddessTNT:v1.5'**<br>

```cpp
dependencies {
    ···
    implementation 'com.github.ThirdGoddess:GoddessTNT:v1.5'
}

```

---
### No1. Dip和Px之间转换 (Conversion between Dip and Px)

```java
//px转dip
//Convert px to dip
//DipPx.pxGoDip(Context, dpValue);
DipPx.pxGoDip(this, 123f);

//dip转px
//Convert dip to px
//DipPx.pxGoDip(Context, pxValue);
DipPx.dipGoPx(this, 123f);
```
---
### No2. Md5加密（Md5 encryption）

```java
//Md5加密
//Md5 encryption
//Md5.toMd5(clearText);
String s = Md5.toMd5("明文/Clear text");
//s = 密文
//s = Ciphertext
```
---
### No3. SHA常用加密 (SHA commonly used encryption)

```java
//Sha常用加密
String sha1 = SHA.toSHA1("#");
String sha224 = SHA.toSHA224("#");
String sha256 = SHA.toSHA256("#");
String sha384 = SHA.toSHA384("#");
String sha512 = SHA.toSHA512("#");
```

---
### No4. ViewPager加载Fragment适配器 (ViewPager loads Fragment adapter) <br>
适用于普通 (Suitable for ordinary) <br>

```java
ViewPager viewPager = (ViewPager) findViewById(R.id.viewPager);
List<Fragment> fragmentList = new ArrayList<>();
fragmentList.add(new TestFragment());
fragmentList.add(new TestFragment());
...

//下面二选一 （Adapter one by one）
viewPager.setAdapter(new ViewPagerFragmentStateAdapter(getSupportFragmentManager(), fragmentList));
//或者 or
viewPager.setAdapter(new ViewPagerFragmentAdapter(getSupportFragmentManager(), fragmentList));

//FragmentStatePagerAdapter：在每次切换页面的时候，是将fragment进行回收，适合页面较多的fragment使用，这样就不会消耗更多的内存。
//FragmentStatePagerAdapter: Each time the page is switched, the fragment is recycled, which is suitable for the fragment with more pages, so that it does not consume more memory.

//FragmentPagerAdapter：在每次切换页面的时候，是将fragment进行分离，适合页面较少的fragment使用以保存一些内存，对系统内存不会有太大影响。
//FragmentPagerAdapter: Each time the page is switched, the fragment is separated, and the fragment is used for a small number of pages to save some memory, which does not have much impact on system memory.
```

---
### No5. 剪贴板复制和粘贴操作 (Clipboard copy and paste operations)

```java
//将字符串复制到剪贴板
//Copy this string to clipboard.
Clipboard.putClipboard(this, "copy the text!");
Clipboard.putClipboard(this, "lable", "copy the text!");

//获取剪贴板上的值
//Get string on clipboar.
String clipboard = Clipboard.getClipboard(this);
```

---

### No6. 自定义加载框 (Custom load box)
![在这里插入图片描述](https://img-blog.csdnimg.cn/20191211233926609.png)

所有用法（ProgressBar的颜色跟随你的App颜色走的）
```java
//启动App时初始化一次，需要什么set什么，主要用于全局设定，不用全部set
DialogUtils dialogTool = new DialogUtils.DialogSetting()
                .setDialogTextColor("#000000")//设置加载框字体颜色，默认跟随系统
                .setBackgroundColor(null)//设置背景颜色，默认是白色
                .setDialogTextStyle(true)//字体是否加粗，默认不加粗
                .setTextSize(15f)//字体大小，默认大小是根据布局设定
                .setCancelable(false)//点击空白处是否停止加载，默认false
                .setText("加载中...")//加载提示文字，默认就是加载中
                .setTextGone(false)//是否隐藏文字，默认不隐藏
                .over();//必须调用over

```

```java
//创建Dialog
final LoadDialog loadDialog = new LoadDialog(this);

//点击空白处是否停止加载,这里的优先级最高
loadDialog.setCancelable(true);

//加载提示文字,这里的优先级最高
loadDialog.setText("加载中...");

//是否隐藏文字,这里的优先级最高
loadDialog.setTextGone(false);

//显示加载框
loadDialog.show();

//模拟6s后加载完成
new Handler().postDelayed(new Runnable() {
    @Override
    public void run() {
		//关闭加载框
		loadDialog.dismiss();
	}
}, 6000);
```

以上是这个加载框的所有方法，一般不用那么多，只需要按下面这样写就行

```java
//启动App时初始化一次，需要什么set什么，主要用于全局设定，不用全部set
DialogUtils dialogTool = new DialogUtils.DialogSetting()
                .setDialogTextColor("#000000")//设置加载框字体颜色，默认跟随系统
                .setBackgroundColor(null)//设置背景颜色，默认是白色
                .setDialogTextStyle(true)//字体是否加粗，默认不加粗
                .setTextSize(15f)//字体大小，默认大小是根据布局设定
                .setCancelable(false)//点击空白处是否停止加载，默认false
                .setText("加载中...")//加载提示文字，默认就是加载中
                .setTextGone(false)//是否隐藏文字，默认不隐藏
                .over();//必须调用over
//==================================================================
//创建Dialog
final LoadDialog loadDialog = new LoadDialog(this);

//显示加载框
loadDialog.show();

//模拟6s后加载完成
new Handler().postDelayed(new Runnable() {
    @Override
    public void run() {
		//关闭加载框
		loadDialog.dismiss();
	}
}, 6000);
```

---

### No7. Bitmap保存到本地相册 (Bitmap save to local album)
==注意！一定要有动态申请读写权限！虽然工具类中已经集成动态申请读写权限，但不建议用这里的动态申请，以免首次操作保存图片失败！！！建议提前申请，比如App启动的时候，下面给出动态申请的方法：==

```xml
<uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE" />
<uses-permission
	android:name="android.permission.MOUNT_UNMOUNT_FILESYSTEMS"
	tools:ignore="ProtectedPermissions" />
```
动态申请
```java
//申请读写权限
if (Build.VERSION.SDK_INT > Build.VERSION_CODES.LOLLIPOP) {
	if (ActivityCompat.checkSelfPermission(context, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
		ActivityCompat.requestPermissions((Activity) context, PERMISSIONS_STORAGE, 690);
	}
}
```
工具类使用方法：
```java

//模拟数据源
imageView.setImageResource(R.mipmap.xm);

//模拟Bitmap
Bitmap bitmap = ((BitmapDrawable) ((ImageView) imageView).getDrawable()).getBitmap();

//第一种方法，会自动生成路径和文件名来进行保存
//上下文, bitmap
boolean b = ImageUtils.saveBitmap(this, bitmap);

//第二种方法，自定义路径和文件名来保存
//上下文, bitmap, 路径和文件名
boolean b1 = ImageUtils.saveBitmap(this, bitmap, "/sdcard/pic/helloworld.jpg");

//第三种方法，增加动态申请权限回调 onRequestPermissionsResult 方法
//上下文, bitmap, 路径和文件名, 返回状态码
boolean b2 = ImageUtils.saveBitmap(this, bitmap, "/sdcard/pic/helloworld.jpg", 123);

if (b) {
	Toast.makeText(this, "保存成功", Toast.LENGTH_SHORT).show();
} else {
	Toast.makeText(this, "保存失败", Toast.LENGTH_SHORT).show();
}

//以上都是返回布尔类型，返回true代表保存成功，false代表保存失败，可以不接
//收值，直接调用，如下
ImageUtils.saveBitmap(this, bitmap);

```

<br><br><br>
