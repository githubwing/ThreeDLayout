# ThreeDLayout
一款3D Layout，他可以让任何view拥有3D效果，可以触摸展示3D效果，或者执行翻转动画。

[![](https://jitpack.io/v/githubwing/ThreeDLayout.svg)](https://jitpack.io/#githubwing/ThreeDLayout)


[ENGLISH README](https://github.com/githubwing/ThreeDLayout/blob/master/README_EN.md)
# 效果预览


![image](https://github.com/githubwing/ThreeDLayout/raw/master/img/1.gif)

![image](https://github.com/githubwing/ThreeDLayout/raw/master/img/2.gif)


![image](https://github.com/githubwing/ThreeDLayout/raw/master/img/3.gif)
# 如何使用
1.compile library
```gradle

allprojects {
  repositories {
    jcenter()
    maven { url "https://jitpack.io" }
  }
}

dependencies {
	        compile 'com.github.githubwing:ThreeDLayout:1.0.0'
	}

```
2.将ThreeDLayout包裹你想要的布局(注意:ThreeDlayout只能有一个子view)

```xml
 <com.wingsofts.threedlayout.ThreeDLayout
      android:background="@color/colorPrimary"
      android:id="@+id/td_header"
      android:layout_width="match_parent"
      android:layout_height="wrap_content"
      >

   <TextView
       android:id="@+id/textView"
      android:text="30℃"
      android:textColor="#fff"
      android:gravity="center"
      android:textSize="80sp"
      android:layout_width="match_parent"
      android:layout_height="wrap_content"
      />
  </com.wingsofts.threedlayout.ThreeDLayout>

```

之后，调用以下方法有对应效果

```java
//开启触摸模式
layout.setTouchable(true);

//改变触摸模式
layout.setTouchMode(ThreeDLayout.MODE_BOTH_X_Y);

//开始执行动画
startVerticalAnimate(long duration);
startVerticalAnimateDelayed(final long delayed, final long duration)

startHorizontalAnimate(long duration)
startHorizontalAnimateDelayed(final long delayed, final long duration)

//开启循环动画
startHorizontalAnimate()
//关闭循环动画
stopAnimate()

```

# License

    Copyright 2016 androidwing1992

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at
    
        http://www.apache.org/licenses/LICENSE-2.0
    
    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
