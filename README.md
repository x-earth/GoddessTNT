### Android常用工具类封装
### Android common tool class package
---

使用方法：

工程下build.gradle添加 **maven { url 'https://jitpack.io' }**
Add **maven { url ‘https://jitpack.io’ }** under build.gradle
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

Modle之下添加 **implementation 'com.github.ThirdGoddess:GoddessTNT:v1.1'**
Add under Modle **implementation 'com.github.ThirdGoddess:GoddessTNT:v1.1'**

```cpp
dependencies {
    ···
    implementation 'com.github.ThirdGoddess:GoddessTNT:v1.1'
}

```

---
**No1.** Dip和Px之间转换 (Conversion between Dip and Px)

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
**No2.** Md5加密（Md5 encryption）

```java
//Md5加密
//Md5 encryption
//Md5.toMd5(clearText);
String s = Md5.toMd5("明文/Clear text");
//s = 密文
//s = Ciphertext
```
---
**No3.** ViewPager加载Fragment适配器 (ViewPager loads Fragment adapter)

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
